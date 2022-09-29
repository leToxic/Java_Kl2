package datum;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DatumTest {

    private static final String[] MONTHS = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli",
            "August", "September", "Oktober", "November", "Dezember"};
    private static final String[] DAYS = {"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"};

    private static Stream<Arguments> dayProvider() {
        return IntStream.range(5, 32).mapToObj(Arguments::of);
    }

    @ParameterizedTest(name = "{0}.12.2016")
    @MethodSource("dayProvider")
    public void computes_week_day(int day) {
        Datum d = new Datum(day, 12, 2016);

        assertEquals(DAYS[(day - 5) % DAYS.length], d.wochentag());
    }

    @ParameterizedTest
    @MethodSource("dayProvider")
    public void computes_week_day_number(int day) {
        Datum d = new Datum(day, 12, 1988);

        assertEquals((day - 5) % DAYS.length, d.wochentagNummer());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12})
    public void gets_month_as_string(int month) {
        Datum d = new Datum(1, month, 2000);

        assertEquals(MONTHS[month - 1], d.getMonatAsString());
    }

    @Test
    void creating_without_arguments_returns_today() {
        LocalDate today = LocalDate.now();
        Datum expected = new Datum(today.getDayOfMonth(), today.getMonthValue(), today.getYear());

        Datum shouldBeSystemDate = new Datum();

        assertEquals(expected, shouldBeSystemDate);
    }

    @Nested
    class Adding {

        @Test
        public void no_days_doesnt_change_date() {
            Datum d = new Datum(1, 1, 2000);
            Datum expected = new Datum(1, 1, 2000);

            d.addiereTage(0);

            assertEquals(expected, d);
        }

        @ParameterizedTest
        @CsvSource({
                "1, 1, 1900, -1",
                "20, 2, 1982, -30001",
        })
        public void fails_if_result_would_be_before_1900(int day, int month, int year, int daysToAdd) {
            Datum d = new Datum(day, month, year);

            assertThrows(IllegalArgumentException.class, () -> d.addiereTage(daysToAdd));
        }

        @Test
        public void negative_days_can_result_in_01_01_1900() {
            Datum d = new Datum(20, 2, 1982);
            Datum expected = new Datum(1, 1, 1900);

            d.addiereTage(-30_000);

            assertEquals(expected, d);
        }

        @Test
        public void days_results_in_future_date() {
            Datum d = new Datum(1, 1, 1900);
            Datum expected = new Datum(1, 1, 2300);

            d.addiereTage(146_097);

            assertEquals(expected, d);
        }

        @Test
        public void days_works_for_any_date() {
            Datum d = new Datum(18, 8, 1983);
            Datum expected = new Datum(7, 9, 2016);

            d.addiereTage(12_074);

            assertEquals(expected, d);
        }
    }

    @Nested
    class Computes_days_between {

        @Test
        public void equal_date_returns_0() {
            Datum from = new Datum(1, 1, 2003);
            Datum to = new Datum(1, 1, 2003);

            assertEquals(0, Datum.tageZwischen(from, to));
        }

        @Test
        public void one_year_later_returns_365() {
            Datum from = new Datum(1, 1, 2003);
            Datum to = new Datum(1, 1, 2004);

            assertEquals(365, Datum.tageZwischen(from, to));
        }

        @Test
        public void one_year_before_returns_negative_365() {
            Datum from = new Datum(1, 1, 2004);
            Datum to = new Datum(1, 1, 2003);

            assertEquals(-365, Datum.tageZwischen(from, to));
        }

        @Test
        public void if_leap_years_between() {
            Datum from = new Datum(31, 12, 2003);
            Datum to = new Datum(1, 3, 2004);

            assertEquals(61, Datum.tageZwischen(from, to));
        }

        @Test
        public void future_dates() {
            Datum from = new Datum(1, 1, 1900);
            Datum to = new Datum(1, 1, 2300);

            assertEquals(146_097, Datum.tageZwischen(from, to));
        }

        @Test
        public void past_dates() {
            Datum from = new Datum(1, 1, 2300);
            Datum to = new Datum(1, 1, 1900);

            assertEquals(-146_097, Datum.tageZwischen(from, to));
        }
    }

    @Nested
    class Formats {

        @Test
        public void for_short_format() {
            Datum d = new Datum(14, 4, 2008);

            assertEquals("14.04.08", d.toString(Datum.FORMAT_SHORT));
        }

        @Test
        public void for_normal_format() {
            Datum d = new Datum(14, 4, 2008);

            assertEquals("14.04.2008", d.toString(Datum.FORMAT_NORMAL));
        }

        @Test
        public void for_long_format() {
            Datum d = new Datum(14, 4, 2008);

            assertEquals("14.April 2008, Montag", d.toString(Datum.FORMAT_LONG));
        }

        @Test
        public void for_US_format() {
            Datum d = new Datum(14, 4, 2008);

            assertEquals("2008/14/04", d.toString(Datum.FORMAT_US));
        }

        @Test
        public void fails_for_invalid_format() {
            Datum d = new Datum(14, 4, 2008);

            assertThrows(IllegalArgumentException.class, () -> d.toString(42));
        }

        @Test
        public void defaults_to_normal_format() {
            Datum d = new Datum(14, 4, 2008);

            assertEquals("14.04.2008", d.toString());
        }
    }

    @Nested
    class Comparing {

        @Test
        public void to_later_date_returns_negative_value() {
            Datum from = new Datum(12, 2, 2007);
            Datum to = new Datum(13, 2, 2007);

            assertTrue(from.compareTo(to) < 0);
        }

        @Test
        public void to_earlier_date_returns_positive_value() {
            Datum from = new Datum(13, 2, 2007);
            Datum to = new Datum(12, 2, 2007);

            assertTrue(from.compareTo(to) > 0);
        }

        @Test
        public void to_equal_date_returns_0() {
            Datum from = new Datum(13, 2, 2007);
            Datum to = new Datum(13, 2, 2007);

            assertEquals(0, from.compareTo(to));
        }
    }

    @Nested
    class Detects_leap_years {

        @ParameterizedTest
        @ValueSource(ints = {2000, 1600, 2004})
        public void if_leap_year(int year) {
            assertTrue(Datum.isSchaltjahr(year));
        }

        @ParameterizedTest
        @ValueSource(ints = {1900, 1907, 1901, 1999})
        public void if_no_leap_year(int year) {
            assertFalse(Datum.isSchaltjahr(year));
        }
    }

    @Nested
    class Creating_from_string {

        @ParameterizedTest
        @ValueSource(strings = {
                "",
                "text",
                "01012000",
                "01.13.2000",
                "32.01.2000",
                "31.12.1899",
                "29.02.2001"
        })
        public void fails_for_invalid_date(String date) {
            assertThrows(IllegalArgumentException.class, () -> new Datum(date));
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "01.02.2003",
                "31.12.2000",
                "29.02.2004",
                "28.02.2000"
        })
        public void for_valid_dates(String date) {
            Datum d = new Datum(date);
            assertEquals(date, d.toString());
        }

        @Test
        public void fails_if_days_are_negative() {
            assertThrows(IllegalArgumentException.class, () -> new Datum(-1));
        }
    }

    @Nested
    class Creating_from_days_after_01_01_1900 {

        @Test
        public void _0_days() {
            Datum d = new Datum(0);

            assertEquals(new Datum(1, 1, 1900), d);
        }

        @Test
        public void _31_days() {
            Datum d = new Datum(31);

            assertEquals(new Datum(1, 2, 1900), d);
        }

        @Test
        public void _365_days() {
            Datum d = new Datum(365);

            assertEquals(new Datum(1, 1, 1901), d);
        }

        @Test
        public void _40000_days() {
            Datum d = new Datum(40_000);

            assertEquals(new Datum(8, 7, 2009), d);
        }
    }

    @Nested
    class Creating_from_given_arguments {

        @ParameterizedTest
        @ValueSource(ints = {2000, 2004})
        public void for_2902_in_leap_years(int year) {
            assertDoesNotThrow(() -> new Datum(29, 2, year));
        }

        @ParameterizedTest
        @ValueSource(ints = {1900, 2001})
        public void _fails_for_2902_if_no_leap_year(int year) {
            assertThrows(IllegalArgumentException.class, () -> new Datum(29, 2, year));
        }

        @Test
        public void fails_for_negative_days() {
            assertThrows(IllegalArgumentException.class, () -> new Datum(-1, 3, 2010));
        }

        @Test
        public void fails_if_month_too_large() {
            assertThrows(IllegalArgumentException.class, () -> new Datum(4, 13, 2010));
        }

        @Test
        public void fails_if_month_0() {
            assertThrows(IllegalArgumentException.class, () -> new Datum(4, 0, 2010));
        }

        @Test
        public void fails_if_year_before_1900() {
            assertThrows(IllegalArgumentException.class, () -> new Datum(31, 12, 1899));
        }

        @ParameterizedTest(name = "{0}.{1}.{2}")
        @CsvSource({
                "31, 1, 2000",
                "29, 2, 2000",
                "28, 2, 2001",
                "28, 2, 1900",
                "31, 3, 2000",
                "30, 4, 2000",
                "31, 5, 2000",
                "30, 6, 2000",
                "31, 7, 2000",
                "31, 8, 2000",
                "30, 9, 2000",
                "31, 10, 2000",
                "30, 11, 2000",
                "31, 12, 2000"})
        public void for_last_day_of_month(int day, int month, int year) {
            assertDoesNotThrow(() -> new Datum(day, month, year));
        }

        @ParameterizedTest(name = "{0}.{1}.{2}")
        @CsvSource({
                "32, 1, 2000",
                "30, 2, 2000",
                "29, 2, 2001",
                "29, 2, 1900",
                "32, 3, 2000",
                "31, 4, 2000",
                "32, 5, 2000",
                "31, 6, 2000",
                "32, 7, 2000",
                "32, 8, 2000",
                "31, 9, 2000",
                "32, 10, 200",
                "31, 11, 200",
                "32, 12, 200"})
        public void fails_for_first_false_day_each_month(int day, int month, int year) {
            assertThrows(IllegalArgumentException.class, () -> new Datum(day, month, year));
        }

        @ParameterizedTest(name = "{0}.{1}.{2}")
        @CsvSource({
                "1, 1, 1900",
                "17, 12, 1937",
                "31, 8, 2020"})
        public void for_valid_arguments(int day, int month, int year) {
            assertDoesNotThrow(() -> new Datum(17, 12, 2017));
        }
    }
}
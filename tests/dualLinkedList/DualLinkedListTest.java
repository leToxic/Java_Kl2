package dualLinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Instanzvariable wird im <code>@AfterEach</code> auf Konsistenz überprüft, daher keine lokale Referenz.
 */
public class DualLinkedListTest {

    DualLinkedList list;

    private static <T> Object getField(String fieldName, T source) throws IllegalAccessException {
        Field field = null;
        try {
            field = source.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException ex) {
            fail("Liste hat kein Datenfeld" + fieldName);
        }
        field.setAccessible(true);
        return field.get(source);
    }

    /**
     * Testet, ob die Liste von vorne und hinten gelesen gleich ist.
     *
     * @throws IllegalAccessException
     */
    @AfterEach
    private void assertConsistent() throws IllegalAccessException {
        if (list.size() == 0) {
            return;
        }
        DualListNode first = (DualListNode) getField("first", list);
        assertNull(first.getPrevious());
        DualListNode last = (DualListNode) getField("last", list);
        assertNull(last.getNext());

        DualListNode current = first;
        Object[] items = new Object[list.size()];
        for (int i = 0; current != null; i++, current = current.getNext()) {
            items[i] = current.getData();
        }
        current = last;

        for (int i = items.length - 1; current != null; i--, current = current.getPrevious()) {
            assertEquals(current.getData(), items[i], "Next und Previous widersprüchlich. ");
        }
    }

    @Test
    public void addsElements() {
        list = new DualLinkedList();
        int value = 3;

        list.add(value);

        assertEquals(value, list.get(0));
    }

    @Test
    public void addsNull() {
        list = new DualLinkedList();

        list.add(null);

        assertNull(list.get(0));
    }

    @Test
    public void cannotAddAtNegativeIndex() {
        list = new DualLinkedList();

        String errorMsg = assertThrows(IndexOutOfBoundsException.class, () -> list.add("data", -1)).getMessage();
        assertTrue(errorMsg.contains("-1"));
    }

    @Test
    public void cannotAddAtTooLargeIndex() {
        list = new DualLinkedList();

        String errorMsg = assertThrows(IndexOutOfBoundsException.class, () -> list.add("data", 1)).getMessage();
        assertTrue(errorMsg.contains("1"));
    }

    @Test
    public void addsExactlyAtEnd() {
        list = new DualLinkedList();

        list.add("data", 0);

        assertEquals("data", list.get(0));
    }

    @Test
    public void addsInMiddle() {
        list = new DualLinkedList();
        list.add(0);
        list.add(1);
        list.add(4);
        list.add(9);
        list.add(16);
        DualLinkedList expected = new DualLinkedList();
        expected.add(0);
        expected.add(1);
        expected.add(4);
        expected.add(42);
        expected.add(9);
        expected.add(16);

        list.add(42, 3);

        assertEquals(expected, list);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void hasCorrectSize(int size) {
        list = new DualLinkedList();

        for (int i = 0; i < size; i++)
            list.add(0);

        assertEquals(size, list.size());
    }

    @Test
    public void size_noElements_0() {
        list = new DualLinkedList();

        assertEquals(0, list.size());
    }

    @Test
    public void cannotRemoveAtNegativeIndex() {
        list = new DualLinkedList();

        String errorMsg = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1)).getMessage();
        assertTrue(errorMsg.contains("-1"));
    }

    @Test
    public void cannotRemoveAtTooLargeIndex() {
        list = new DualLinkedList();

        String errorMsg = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0)).getMessage();
        assertTrue(errorMsg.contains("0"));
    }

    @Test
    public void removalOfFirstCorrectlyUpdatesFirst() {
        list = new DualLinkedList();
        list.add("first");
        list.add("second");
        list.add("last");
        DualLinkedList expected = new DualLinkedList();
        expected.add("second");
        expected.add("last");

        Object removedData = list.remove(0);

        assertEquals("first", removedData);
        assertEquals(expected, list);
    }

    @Test
    public void removalOfLastCorrectlyUpdatesLast() {
        list = new DualLinkedList();
        list.add("first");
        list.add("second");
        list.add("last");

        Object removedData = list.remove(2);

        assertEquals("last", removedData);
        assertEquals(2, list.size());
    }

    @Test
    public void removesAnElement() {
        list = new DualLinkedList();
        list.add(0);
        list.add(1);
        list.add(4);
        list.add(9);
        list.add(16);
        DualLinkedList expected = new DualLinkedList();
        expected.add(0);
        expected.add(1);
        expected.add(9);
        expected.add(16);

        Object removedData = list.remove(2);

        assertEquals(4, removedData);
        assertEquals(expected, list);
    }

    @Test
    public void hasCorrectStringRepresentation() {
        list = new DualLinkedList();
        list.add(0);
        list.add(1);
        list.add(2);

        assertEquals("{0, 1, 2}", list.toString());
    }

    @Test
    public void emptyListIsRepresentedWithEmptyBrackets() {
        list = new DualLinkedList();

        assertEquals("{ }", list.toString());
    }

    @Test
    public void removesAllElements() {
        list = new DualLinkedList();
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(0);
        list.add(2);
        list.add(0);
        list.add(0);
        DualLinkedList expected = new DualLinkedList();
        expected.add(1);
        expected.add(2);

        list.removeAll(0);

        assertEquals(expected, list);
    }

    @Test
    public void removesAllEvenIfResultingInEmptyList() {
        list = new DualLinkedList();
        list.add(0);
        list.add(0);
        list.add(0);

        list.removeAll(0);

        assertEquals(0, list.size());
    }

    @Test
    public void removingNotContainedLeavesListUnchanged() {
        list = new DualLinkedList();
        list.add(0);
        list.add(1);
        DualLinkedList expected = new DualLinkedList();
        expected.add(0);
        expected.add(1);

        list.removeAll(42);

        assertEquals(expected, list);
    }
}
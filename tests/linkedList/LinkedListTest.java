package linkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void add_element_elementAdded() {
        LinkedList list = new LinkedList();

        list.add(3);

        assertEquals(3, list.get(0));
    }

    @Test
    public void add_elementNull_elementAdded() {
        LinkedList list = new LinkedList();

        list.add(null);

        assertNull(list.get(0));
        assertNull(list.set(0, 0));
    }

    @Test
    public void add_indexNegative_exception() {
        LinkedList list = new LinkedList();

        String errorMsg = assertThrows(IndexOutOfBoundsException.class, () -> list.add("data", -1)).getMessage();
        assertTrue(errorMsg.contains("-1"));
    }

    @Test
    public void add_indexTooBig_exception() {
        LinkedList list = new LinkedList();

        String errorMsg = assertThrows(IndexOutOfBoundsException.class, () -> list.add("data", 1)).getMessage();
        assertTrue(errorMsg.contains("1"));
    }

    @Test
    public void add_elementAtEnd_elementAppended() {
        LinkedList list = new LinkedList();

        list.add("data", 0);

        assertEquals("data", list.get(0));
    }

    @Test
    public void add_elementAtIndex_elementInserted() {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(1);
        list.add(4);
        list.add(9);
        list.add(16);
        assertEquals(5, list.size());
        list.add(42, 3);
        assertEquals(6, list.size());
        assertEquals(42, list.get(3));
        assertEquals(6, list.size());
        assertEquals(9, list.get(4));
        Object o = list.set("Hugo", 4);
        assertEquals("Hugo", list.get(4));
        assertEquals(9, o);
        assertEquals(6, list.size());
    }

    @Test
    public void size_noElements_0() {
        LinkedList list = new LinkedList();

        assertEquals(0, list.size());
    }

    @Test
    public void size_threeElements_3() {
        LinkedList list = new LinkedList();

        list.add(0);
        list.add(0);
        list.add(0);

        assertEquals(3, list.size());
    }

    @Test
    public void remove_indexNegative_exception() {
        LinkedList list = new LinkedList();

        String errorMsg = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1)).getMessage();
        assertTrue(errorMsg.contains("-1"));
    }

    @Test
    public void remove_indexTooBig_exception() {
        LinkedList list = new LinkedList();

        String errorMsg = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0)).getMessage();
        assertTrue(errorMsg.contains("0"));
    }

    @Test
    public void remove_single_ElementList_listEmpty() {
        LinkedList list = new LinkedList();
        list.add(42);

        list.remove(0);

        assertEquals(0, list.size());
        assertThrows(NullPointerException.class, list::getFirst);
        assertThrows(NullPointerException.class, list::getLast);
    }

    @Test
    public void remove_index0_firstRemovedNewFirstSet() {
        LinkedList list = new LinkedList();
        list.add("first");
        list.add("second");
        list.add("last");

        Object removedData = list.remove(0);

        assertEquals("first", removedData);
        assertEquals(2, list.size());
        assertEquals("second", list.getFirst());
        assertEquals("last", list.getLast());
    }

    @Test
    public void remove_indexLast_lastRemovedNewLastSet() {
        LinkedList list = new LinkedList();
        list.add("first");
        list.add("second");
        list.add("last");

        Object removedData = list.remove(2);

        assertEquals("last", removedData);
        assertEquals(2, list.size());
        assertEquals("first", list.getFirst());
        assertEquals("second", list.getLast());
    }

    @Test
    public void remove_indexMiddle_removed() {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(1);
        list.add(4);
        list.add(9);
        list.add(16);
        LinkedList expected = new LinkedList();
        expected.add(0);
        expected.add(1);
        expected.add(9);
        expected.add(16);

        Object removedData = list.remove(2);

        assertEquals(4, removedData);
        assertEquals(expected, list);
    }

    @Test
    public void toString_listNotEmpty_resultAsSpecified() {
        LinkedList list = new LinkedList();

        list.add(0);
        list.add(1);
        list.add(2);

        assertEquals("{0, 1, 2}", list.toString());
    }

    @Test
    public void toString_emptyList_emptyBracketsresultAsSpecified() {
        LinkedList list = new LinkedList();

        assertEquals("{ }", list.toString());
    }

    @Test
    public void removeAll_emptyList_noChange() {
        LinkedList list = new LinkedList();

        list.removeAll("emptyList");

        assertEquals(new LinkedList(), list);
    }

    @Test
    public void removeAll_targetPresentAtStartMiddleEnd_rest() {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(2);
        list.add(0);
        LinkedList expected = new LinkedList();
        expected.add(1);
        expected.add(2);

        list.removeAll(0);

        assertEquals(expected, list);
        list.remove();
        assertEquals(0, list.size());
        assertThrows(NullPointerException.class, () -> list.getFirst());
        assertThrows(NullPointerException.class, list::getLast);
    }

    @Test
    public void removeAll_listContainsOnlyTarget_emptyList() {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(0);
        list.add(0);

        list.removeAll(0);

        assertEquals(0, list.size());
    }

    @Test
    public void removeAll_targetNotPresent_listUnchanged() {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(1);
        LinkedList expected = new LinkedList();
        expected.add(0);
        expected.add(1);

        list.removeAll(42);

        assertEquals(expected, list);
    }

    @Test
    public void get_indexTooLarge_exception() {
        LinkedList list = new LinkedList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 0));
    }

    @Test
    public void get_indexNegative_exception() {
        LinkedList list = new LinkedList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, -1));
    }
}
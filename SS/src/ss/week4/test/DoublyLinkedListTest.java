package ss.week4.test;

import org.junit.Before;
import org.junit.Test;
import ss.week4.DoublyLinkedList;

import static org.junit.Assert.assertEquals;

public class DoublyLinkedListTest {
    private DoublyLinkedList<Object> list;
    private Object object1;
    private Object object2;
    private Object object3;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
        object1 = new Object();
        object2 = new Object();
        object3 = new Object();
    }

    @Test
    public void testSetup() {
        assertEquals(list.size(), 0);
    }

    @Test
    public void testAdd() {
        list.add(0, object1);
        list.add(0, object2);

        assertEquals(list.size(), 2);
        assertEquals(object1, list.get(1));
        assertEquals(object2, list.get(0));
    }

    @Test
    public void testRemoveHead() {
        list.add(0, object1);
        list.add(1, object2);
        list.add(2, object3);

        list.remove(0);
        assertEquals(list.get(0), object2);
        assertEquals(list.size(), 2);
    }

    @Test
    public void testRemove() {
        list.add(0, object1);
        list.add(1, object2);
        list.add(2, object3);

        list.remove(1);
        assertEquals(list.get(1), object3);
        assertEquals(list.size(), 2);
    }
}

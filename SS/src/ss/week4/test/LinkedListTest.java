package ss.week4.test;

import org.junit.Before;
import org.junit.Test;
import ss.week4.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LinkedListTest {
    private LinkedList<Object> list;
    private Object object1;
    private Object object2;
    private Object object3;

    @Before
    public void setUp() {
        list = new LinkedList<>();

        object1 = new Object();
        object2 = new Object();
        object3 = new Object();
        list.add(0, object1);
        list.add(1, object2);
        list.add(2, object3);
    }

    @Test
    public void testSetup() {
        assertEquals(list.size(), 3);
    }

    @Test
    public void testFindBefore() {
        assertNull(list.findBefore(object1));
        assertEquals(object1, list.findBefore(object2).getElement());
        assertEquals(object2, list.findBefore(object3).getElement());
    }

    @Test
    public void testRemoveHead() {
        list.remove(object1);
        assertEquals(list.get(0), object2);
        assertEquals(list.size(), 2);
    }

    @Test
    public void testRemove() {
        list.remove(object2);
        assertEquals(list.get(1), object3);
        assertEquals(list.size(), 2);
    }
}

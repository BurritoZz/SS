package ss.week5.test;

import org.junit.Test;
import ss.week5.MapUtil;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InverseTest {

    @Test
    public void testEmptyMap() {
        Map<Integer, Integer> f1 = new HashMap<Integer, Integer>();
        assertTrue(MapUtil.inverse(f1).isEmpty());
    }

    @Test
    public void testOneToOne() {
        Map<Integer, Character> f1 = new HashMap<Integer, Character>();
        f1.put(1, 'a');

        Map<Character, Set<Integer>> f1Inv = new HashMap<Character, Set<Integer>>();
        f1Inv.put('a', new HashSet<Integer>(Arrays.asList(1)));

        assertEquals(f1Inv, MapUtil.inverse(f1));
    }

    @Test
    public void testManyToOne() {
        Map<Integer, Character> f1 = new HashMap<Integer, Character>();
        f1.put(1, 'a');
        f1.put(2, 'b');
        f1.put(3, 'a');

        Map<Character, Set<Integer>> f1Inv = new HashMap<Character, Set<Integer>>();
        f1Inv.put('a', new HashSet<Integer>(Arrays.asList(1, 3)));
        f1Inv.put('b', new HashSet<Integer>(Arrays.asList(2)));

        assertEquals(f1Inv, MapUtil.inverse(f1));
    }
}

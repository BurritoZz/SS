package ss.week5.test;

import org.junit.Test;
import ss.week5.MapUtil;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InverseBijectionTest {

    @Test
    public void testInverseBijection() {
        Map<Integer, Character> f1 = new HashMap<Integer, Character>();
        f1.put(1, 'a');

        Map<Character, Integer> f1Inv = new HashMap<Character, Integer>();
        f1Inv.put('a', 1);

        assertEquals(f1Inv, MapUtil.inverseBijection(f1));
    }

    @Test
    public void testInverseInverse() {
        Map<Integer, Character> f1 = new HashMap<Integer, Character>();
        f1.put(1, 'a');

        Map<Character, Integer> f1Inv = new HashMap<Character, Integer>();
        f1Inv.put('a', 1);

        assertEquals(f1, MapUtil.inverseBijection(MapUtil.inverseBijection(f1)));
    }

    @Test
    public void testInverseBijectionMap() {
        Map<Integer, Character> f1 = new HashMap<>();
        assertTrue(MapUtil.inverseBijection(f1).isEmpty());
    }
}

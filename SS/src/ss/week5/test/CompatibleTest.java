package ss.week5.test;

import org.junit.Before;
import org.junit.Test;
import ss.week5.MapUtil;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompatibleTest {
    private Map<Character, Double> f3;

    @Before
    public void setUp() {
        f3 = new HashMap<Character, Double>();
        f3.put('a', 3.0);
    }

    @Test
    public void testEmptyMap() {
        Map<Integer, Character> f1 = new HashMap<Integer, Character>();
        Map<Character, Integer> f2 = new HashMap<Character, Integer>();

        assertTrue(MapUtil.compatible(f1, f2));
        assertTrue(MapUtil.compatible(f2, f1));

        f2.put('a', 1);

        assertFalse(MapUtil.compatible(f2, f1));
        assertTrue(MapUtil.compatible(f1, f2));
    }

    @Test
    public void testCorrectMap() {
        Map<Integer, Character> f4 = new HashMap<Integer, Character>();
        f4.put(1, 'a');
        f4.put(2, 'a');

        assertTrue(MapUtil.compatible(f4, f3));
    }

    @Test
    public void testWrongMap() {
        Map<Integer, Character> f5 = new HashMap<Integer, Character>();
        f5.put(1, 'a');
        f5.put(2, 'b');

        assertFalse(MapUtil.compatible(f5, f3));
    }
}

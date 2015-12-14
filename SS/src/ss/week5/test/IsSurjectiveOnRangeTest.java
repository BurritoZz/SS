package ss.week5.test;

import org.junit.Test;
import ss.week5.MapUtil;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsSurjectiveOnRangeTest {
    private Map<Integer, Character> f1;
    private Set<Character> range;

    @Test
    public <K, V> void testEmptyMap() {
        f1 = new HashMap<Integer, Character>();
        range = new HashSet<Character>();

        assertTrue(MapUtil.isSurjectiveOnRange(f1, range));
    }

    @Test
    public <K, V> void testCorrectMap() {
        f1 = new HashMap<Integer, Character>();
        f1.put(1, 'a');
        f1.put(2, 'b');

        range = new HashSet<Character>(Arrays.asList('a', 'b'));

        assertTrue(MapUtil.isSurjectiveOnRange(f1, range));
    }

    @Test
    public void testWrongMap() {
        f1 = new HashMap<Integer, Character>();
        f1.put(1, 'b');
        f1.put(2, 'b');

        range = new HashSet<Character>(Arrays.asList('a', 'b'));

        assertFalse(MapUtil.isSurjectiveOnRange(f1, range));
    }

}

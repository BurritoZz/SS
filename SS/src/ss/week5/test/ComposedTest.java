package ss.week5.test;

import org.junit.Test;
import ss.week5.MapUtil;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ComposedTest {

    @Test
    public void testCorrectMap() {
        Map<Integer, Character> f1 = new HashMap<Integer, Character>();
        f1.put(1, 'a');
        f1.put(2, 'a');
        f1.put(3, 'b');

        Map<Character, Double> f2 = new HashMap<Character, Double>();
        f2.put('a', 3.0);
        f2.put('b', -4.2);

        Map<Integer, Double> f3 = MapUtil.compose(f1, f2);

        assertEquals(f3.get(1), 3.0, 0.001);
        assertEquals(f3.get(2), 3.0, 0.001);
        assertEquals(f3.get(3), -4.2, 0.001);
    }

}

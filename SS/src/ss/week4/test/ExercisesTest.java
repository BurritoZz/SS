package ss.week4.test;

import org.junit.Test;
import ss.week4.Exercises;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ExercisesTest {
    @Test
    public void testCountNegativeNumbers() {
        assertEquals(0, Exercises.countNegativeNumbers(new int[]{}));
        assertEquals(0, Exercises.countNegativeNumbers(new int[]{1}));
        assertEquals(3, Exercises.countNegativeNumbers(new int[]{1,2,3,0,-1,-2,-3}));
    }

    @Test
    public void testReverseArrayEmptyArray() {
        int[] array = {};
        Exercises.reverseArray(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    public void testReverseArrayOneElement() {
        int[] array = {1};
        Exercises.reverseArray(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    public void testReverseArrayEvenElements() {
        int[] array = {1, 2, 3, 4};
        Exercises.reverseArray(array);
        assertArrayEquals(new int[]{4, 3, 2, 1}, array);
    }

    @Test
    public void testReverseArrayUnevenElements() {
        int[] array = {1, 2, 3, 4, 5};
        Exercises.reverseArray(array);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, array);
    }
}

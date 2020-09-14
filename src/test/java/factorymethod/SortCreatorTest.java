package factorymethod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortCreatorTest {
    private int[] array1;
    private int[] array2;

    @BeforeEach
    void setUp() {
        int SIZE = 1000;
        array1 = new int[SIZE];
        array2 = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            int item = (int) (Math.random() * 200);
            array1[i] = item;
            array2[i] = item;
        }
    }

    @Test
    void TestSelectionSort() {
        SortCreator.selectionSort().sort(array1);
        Arrays.sort(array2);
        Assertions.assertArrayEquals(array1, array2);
    }

    @Test
    void TestHeapsort() {
        SortCreator.heapsort().sort(array1);
        Arrays.sort(array2);
        Assertions.assertArrayEquals(array1, array2);
    }

    @Test
    void TestRadixSort() {
        SortCreator.radixSort().sort(array1);
        Arrays.sort(array2);
        Assertions.assertArrayEquals(array1, array2);
    }
}
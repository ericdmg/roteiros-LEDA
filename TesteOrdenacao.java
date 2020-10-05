package sorting.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.AbstractSorting;
import sorting.divideAndConquer.QuickSort;
import sorting.divideAndConquer.threeWayQuicksort.ThreeWayQuickSort;


import java.util.Arrays;
import java.util.Random;

public class TesteOrdenacao {

    private Integer[] arr;
    private AbstractSorting<Integer> sorting;
    private Random random;

    @Before
    public void setUp() {
        sorting = new ThreeWayQuickSort<>();
        random = new Random();
        arr = new Integer[20000 + random.nextInt(50000)];
    }

    private void preencheArray() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(25000);
        }
    }

    @Test
    public void testSort() {
        preencheArray();
        Integer[] copyArr = Arrays.copyOf(arr, arr.length);
        long tempoInicial = System.currentTimeMillis();
        sorting.sort(arr, 0, arr.length - 1);
        System.out.println("o metodo executou em " + (System.currentTimeMillis() - tempoInicial));
        Arrays.sort(copyArr, 0, copyArr.length);
        Assert.assertArrayEquals(copyArr, arr);
    }

}

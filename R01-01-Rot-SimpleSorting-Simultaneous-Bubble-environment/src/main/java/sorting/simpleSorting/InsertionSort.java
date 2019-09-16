package sorting.simpleSorting;

import sorting.AbstractSorting;

import java.util.Arrays;

import static util.Util.swap;
import static util.Util.validaOrdenacao;


/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validaOrdenacao(array, leftIndex, rightIndex)) {
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				T key = array[i];
				int j = i;
				while (j > leftIndex && array[j-1].compareTo(key) > 0) {
					swap(array, j, j - 1);
					System.out.println(Arrays.toString(array));
					j--;
				}
				System.out.println(Arrays.toString(array));
				array[j] = key;
			}
		}
	}
}
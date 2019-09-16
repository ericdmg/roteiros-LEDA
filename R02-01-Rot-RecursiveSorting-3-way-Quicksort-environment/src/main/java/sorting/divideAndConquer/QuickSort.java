package sorting.divideAndConquer;

import sorting.AbstractSorting;

import java.util.Arrays;

import static util.Util.swap;


/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validaOrdenacao(array, leftIndex, rightIndex)) {
			if (leftIndex < rightIndex) {
				int j = separar(array, leftIndex, rightIndex);
				sort(array, leftIndex, j - 1);
				sort(array, j + 1, rightIndex);

			}
		}
	}

	private int separar(T[] array, int leftIndex, int rightIndex) {
		int j = rightIndex;
		int i = leftIndex + 1;
		T pivo = array[leftIndex];

		while (i <= j) {
			if (pivo.compareTo(array[i]) > 0 || pivo.compareTo(array[i]) == 0) {
				i++;
			} else if (pivo.compareTo(array[j]) < 0) {
				j--;
			} else if (i <= j) {
				System.out.println(Arrays.toString(array));
				swap(array, i, j);
				i++;
				j--;
			}
		}
		swap(array, leftIndex, j);

		System.out.println(j);
		return j;
	}

	private boolean validaOrdenacao(Object[] array, int leftIndex, int rightIndex){
		boolean retorno;
		if ((array != null) && (leftIndex < rightIndex) && (leftIndex >= 0) && (rightIndex > 0)
				&& (rightIndex < array.length)) {
			retorno = true;
		}
		else retorno = false;

		return retorno;
	}
}

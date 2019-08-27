package sorting.simpleSorting;

import sorting.AbstractSorting;


import static util.Util.swap;
import static util.Util.validaOrdenacao;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validaOrdenacao(array,leftIndex,rightIndex)) {
			boolean swapped = true;
			int j = rightIndex;
			while (swapped) {
				swapped = false;
				for (int i = leftIndex; i < j; i++) {
					if (array[i].compareTo(array[i + 1]) > 0) {
						swap(array, i, i + 1);
						swapped = true;
					}

				}
			}
		}
	}


}





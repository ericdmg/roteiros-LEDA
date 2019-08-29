package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		T[] arrayAuxiliar = (T[])new Comparable[array.length];

		mergeSort(array, arrayAuxiliar, leftIndex, rightIndex);
	}

	private void mergeSort(T[] array, T[] arrayAuxiliar, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int meio = (leftIndex + rightIndex) / 2;

			mergeSort(array, arrayAuxiliar, leftIndex, meio);
			mergeSort(array, arrayAuxiliar, meio + 1, rightIndex);
			unir(array, arrayAuxiliar, leftIndex, meio, rightIndex);
		}
	}

	private void unir(T[] array, T[] arrayAuxiliar, int leftIndex, int meio, int rightIndex) {
		for (int index = leftIndex; index <= rightIndex; index++){
			arrayAuxiliar[index] = array[index];
		}

		int i = leftIndex;
		int j = meio + 1;

		for(int k = leftIndex; k <= rightIndex; k++){
			if(i > meio){
				array[k] = arrayAuxiliar[j];
				j++;
			}
			else if(j > rightIndex){
				array[k] = arrayAuxiliar[i];
				i++;
			}
			else if(arrayAuxiliar[i].compareTo(arrayAuxiliar[j]) < 0){
				array[k] = arrayAuxiliar[i];
				i++;
			}
			else{
				array[k] = arrayAuxiliar[j];
				j++;
			}
		}
	}
}

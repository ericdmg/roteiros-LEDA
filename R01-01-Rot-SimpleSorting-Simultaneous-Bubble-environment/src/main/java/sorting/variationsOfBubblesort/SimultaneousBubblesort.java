package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

import static util.Util.swap;
import static util.Util.validaOrdenacao;

/**
 * This algorithm applies two bubblesorts simultaneously. In a same iteration, a
 * bubblesort pushes the greatest elements to the right and another bubblesort
 * pushes the smallest elements to the left. At the end of the first iteration,
 * the smallest element is in the first position (index 0) and the greatest
 * element is the last position (index N-1). The next iteration does the same
 * from index 1 to index N-2. And so on. The execution continues until the array
 * is completely ordered.
 */
public class SimultaneousBubblesort<T extends Comparable<T>> extends AbstractSorting<T> {
	/**
	 *As flags maximoDireita e maximoEsquerda servem pra denotar o índice máximo que o
	 *elemento da vez da iteração pode ir, dependendo do sentido.
	 */

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validaOrdenacao(array, leftIndex, rightIndex)) {
			for (int i = leftIndex; i <= rightIndex; i++) {

				int j = leftIndex;
				int k = rightIndex;

				while (j < rightIndex - 1 && k > leftIndex + 1) {
					j++;
					k--;
					if (array[j].compareTo(array[j + 1]) > 0) {
						swap(array, j, j + 1);

					}


					if (array[k].compareTo(array[k - 1]) < 0) {
						swap(array, k, k - 1);

					}
				}
			}
		}
	}
}







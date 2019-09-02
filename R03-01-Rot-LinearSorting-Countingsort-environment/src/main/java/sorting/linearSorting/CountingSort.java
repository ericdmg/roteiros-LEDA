package sorting.linearSorting;

import sorting.AbstractSorting;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		Integer maior = array[leftIndex];
		Integer menor = array[leftIndex];

		for(int i = leftIndex; i <= rightIndex; i++){
			if(array[i].compareTo(maior) > 0){
				maior = array[i];
			}
			else if(array[i].compareTo(maior) < 0){
				menor = array[i];
			}
		}

		int[] countArray = new int[array.length];
		for (int k = leftIndex; k <= rightIndex; k++){
			countArray[array[k] - 1] += 1;
		}
		System.out.println(Arrays.toString(countArray));

		for (int j = leftIndex + 1; j <= rightIndex; j++){
			countArray[j] += countArray[j-1];
		}
		System.out.println(Arrays.toString(countArray));

		int[] auxB = new int[array.length];
		for (int m = rightIndex; m >= leftIndex; m--){
			auxB[countArray[array[m]-1] - 1] = array[m];
			countArray[array[m]-1]--;


		}
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(auxB));

	}

}

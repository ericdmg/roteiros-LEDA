package sorting.linearSorting;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {
	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			Integer[] maiorMenor = calculaMaiorMenor(array,leftIndex,rightIndex);
			int maior = maiorMenor[0];
			int menor = maiorMenor[1];


			Integer[] countArray = new Integer[maior  - menor + 1];
			Arrays.fill(countArray, 0);

			Integer[] arrayAuxiliar = new Integer[array.length];
			Arrays.fill(arrayAuxiliar, 0);

			for (int k = leftIndex; k <= rightIndex; k++) {
				countArray[array[k]-menor] += 1;
			}


			for (int j = leftIndex + 1; j < countArray.length; j++) {
				countArray[j] += countArray[j - 1];

			}

			for (int i = rightIndex; i >= leftIndex; i--) {
				arrayAuxiliar[countArray[array[i]-menor] - 1] = array[i];
				countArray[array[i]-menor] -= 1;
			}

			for(int j = leftIndex; j <= rightIndex;j++){
				array[j] = arrayAuxiliar[j];
			}


		}

	}

	private Integer[] calculaMaiorMenor(Integer[] array, int leftIndex, int rightIndex) {
		int maior = Integer.MIN_VALUE;
		int menor = Integer.MAX_VALUE;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(maior) > 0) {
				maior = array[i];
			} else if (array[i].compareTo(menor) < 0) {
				menor = array[i];
			}
		}
		Integer[] maiorMenor = {maior,menor};
		return maiorMenor;
	}

}

package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;

import static util.Util.swap;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitoe elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(rightIndex >= leftIndex) {
			int[] extremos = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, extremos[1] - 1);
			sort(array, extremos[0] + 1, rightIndex);
		}

	}

	private int[] partition(T[] array, int leftIndex, int rightIndex) {
	int[] arrayExtremos = new int[2];
	int pivotInicio = leftIndex;
	int i = leftIndex;
	int pivotFim = rightIndex;

	while (pivotFim >= i){
		if(array[i].compareTo(array[pivotInicio]) < 0){
			swap(array,pivotInicio,i);
			i++;
			pivotInicio++;
		}

		else if(array[i].compareTo(array[pivotInicio]) > 0){
			swap(array,pivotFim,i);
			pivotFim--;
		}
		else if(array[i].compareTo(array[pivotInicio]) == 0){
			i++;
		}
	}
		int[] extremos = {pivotInicio, pivotFim};
		return extremos;
	}


}

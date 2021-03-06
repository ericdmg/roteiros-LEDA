package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem
	 * desejada sem modificar o array original.
	 * <p>
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no
	 * array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 * elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 * como o selectionsort mas sem modificar nenhuma posicao do array).
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null.
	 * - Considerar que k varia de 1 a N
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {


			if (array == null || k > array.length || k < 1) {
				return null;
			}
			T menor = array[0];
			for (int i = 0; i < array.length; i++) {
				if (array[i].compareTo(menor) < 0) {
					menor = array[i];
				}
			}
			return selectionSearch(array, menor, k - 1);

		}


	public T selectionSearch(T[] array, T menorAnterior, int k) {
		if(k == 0){
			return menorAnterior;
		}
		T aux = null;
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(menorAnterior) > 0) {
				if (aux == null){
					aux = array[i];
				}
				else if (array[i].compareTo(aux) < 0) {
					aux = array[i];
				}
			}
		}

		return selectionSearch(array,aux,k-1);

	}

}

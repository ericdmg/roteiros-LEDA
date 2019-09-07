package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		return binarySearchFloor(array, 0, array.length - 1, x);
	}

	private Integer binarySearchFloor(Integer[] array, int leftIndex, int rightIndex, Integer x) {
		Integer retorno = null;
		int meio = (leftIndex + rightIndex) / 2;

		if(array != null && array.length > 0  && x != null) {

			if (leftIndex <= rightIndex) {
				if (array[meio].compareTo(x) == 0) {
					retorno = array[meio];
				}

				else if (array[meio].compareTo(x) > 0) {
					retorno = binarySearchFloor(array, leftIndex, meio-1, x);
				}

				else retorno = binarySearchFloor(array, meio + 1, rightIndex, x);

			}

			else {

				if (array[meio].compareTo(x) < 0 || array[meio].compareTo(x) == 0) {
					retorno = array[meio];
				}
			}
		}

		return retorno;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		return binarySearchCeil(array, 0, array.length - 1, x);
	}

	private Integer binarySearchCeil(Integer[] array, int leftIndex, int rightIndex, Integer x) {
		Integer retorno = null;
		int meio = (leftIndex + rightIndex) / 2;
		if(array != null && array.length > 0 && x != null) {

			if (leftIndex < rightIndex) {
				if (array[meio].compareTo(x) == 0) {
					retorno = array[meio];

				}

				else if (array[meio].compareTo(x) > 0) {
					retorno = binarySearchCeil(array, leftIndex, meio, x);

				}

				else retorno = binarySearchCeil(array, meio + 1, rightIndex, x);
			}

			else if (array[meio].compareTo(x) > 0 || array[meio].compareTo(x) == 0) {
					retorno = array[meio];

			}
		}

			return retorno;

	}
}


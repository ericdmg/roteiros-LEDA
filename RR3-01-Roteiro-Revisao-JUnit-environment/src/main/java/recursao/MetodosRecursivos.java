package recursao;

import java.lang.reflect.Array;

public class MetodosRecursivos {
	public static void main(String[] args) {
		System.out.println("\n--- FATORIAL ---");
		calcularFatorial(10);

		System.out.println("\n--- FIBONACCI ---");
		System.out.println(calcularFibonacci(3));

		System.out.println("\n--- POTÊNCIA DE 2 ---");
		System.out.println(potenciaDe2(4));

		System.out.println("\n--- COUNT NOT NULL ---");
		Object[] array = new Object[10];
		for (int i = 1; i < array.length; i++){
			if(i <= 4) {
				array[i - 1] = i;
			}
		}
		System.out.println(countNotNull(array));

	}

	public static int calcularSomaArray(int[] array){
		int result = 0;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS EMENTOS DE UM ARRAY
		return result;
	}
	private static long calcularFatorial(int n) {
		if (n == 0){
			System.out.println(n + "! = 1");
			return 1;
		}

		long resultado =  n * calcularFatorial(n-1);
		System.out.println(n + "! = " + resultado);
		return resultado;

	}

	public static int calcularFibonacci(int n) {
		int result = 1;
		if (0 == n){
			return 0;
		}
		else if (1 == n){
			return n;
		}
		return calcularFibonacci(n-1) + calcularFibonacci(n-2);
	}

	public static int countNotNull(Object[] array) {
		return countNotNullAuxiliar(array, 0);
	}

	public static int countNotNullAuxiliar(Object[] array,int index){
		int soma = 0;
		if (array.length == 0 || index == array.length){
			return 0;
		}
		else if(array[index] != null){
			soma += 1;
		}
		return soma + countNotNullAuxiliar(array, index+1);
	}

	private static double potenciaDe2(int expoente) {
		if (expoente == 0){
			return 1;
		}

		return 2 * potenciaDe2(expoente - 1);
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		return result;
	}


}

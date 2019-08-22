package minhasSolucoesRecursao;

public class MainRecursao {
    public static void main(String[] args) {
        //geraSequencia(10);
        System.out.println(somaDeUjmAteN(5));
    }

    private static void geraSequencia(int x){
        if (x < 0){
            System.out.println("Apenas números naturais!");
        }
        else{
            if(x == 0){
                System.out.println(x);
            }
            else{
                geraSequencia(x-1);
                System.out.println(x);
            }
        }
    }

    private static int somaDeUjmAteN(int n){
        if(n < 1){
            throw new IllegalArgumentException("N deve ser maior que 1.");
        }

        else if (n == 1) {
            return n;
        }

        return n + somaDeUjmAteN(n-1);


    }
}

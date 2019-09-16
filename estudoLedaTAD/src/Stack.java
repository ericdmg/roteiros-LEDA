import java.lang.reflect.Array;
import java.util.*;

public class Stack<T> {
    private  int size;

    public T[] getPilha() {
        return pilha;
    }

    private T[] pilha;
    private int top;


    public Stack(int size) {
        this.pilha =  (T[]) new Integer[size];
        this.top = -1;
        this.size = size;

    }

    public void push(T objeto){
        if(top == size){
            throw new StackOverflowError();
        }
        this.top++;
        this.pilha[top] = objeto;


    }

    public T pop() {
        T retorno = null;
        if (isEmpty()) {
            try {
                throw new StackUnderFlowException("Não há o que remover do topo, a pilha está vazia.");
            } catch (StackUnderFlowException e) {
                e.printStackTrace();
            }
        }

        else {
            this.top--;
            retorno =  this.pilha[top + 1];
        }
        return retorno;
    }

    public T top(){
        return this.pilha[top];
    }

    public boolean isEmpty(){
        if (top == -1){
            return true;
        }
        else return false;
    }
}

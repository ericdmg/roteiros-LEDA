package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T retorno;
		if (isEmpty()) {
			retorno = null;
		}

		else {
			retorno =  this.array[top];
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
	    boolean retorno = false;
		if (this.top == -1){
			retorno = true;
		}
		return retorno;
	}

	@Override
	public boolean isFull() {
	    boolean retorno = false;
		if (this.top == this.array.length){
			retorno = true;
		}
        return retorno;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.top == this.array.length - 1) {
			throw new StackOverflowException();
		} else if (element != null) {
			this.top++;
			this.array[top] = element;

		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T retorno = null;
		if (isEmpty()) {
			throw new StackUnderflowException();
		}

		else {
			this.top--;
			retorno =  this.array[top + 1];
		}
		return retorno;
	}

	public T searchByInsertionOrder(int order){
		T retorno = null;
		for(int i = 0; i < this.array.length;i++){
			if (i == order-1){
				retorno = this.array[i];
			}
		}
		return retorno;
	}

	public boolean checkInput(String entrada) throws StackUnderflowException, StackOverflowException {
		boolean completo = true;
		String parentese = "";
		int maiorSequencia = 0;
		for (int i = 0; i < entrada.length(); i++) {
			String complementoParentese = "";
			parentese = "" + entrada.charAt(i);
			if(parentese.equals("(")) {
				push((T) parentese);
			}
			else {
				if(i == 0){
					completo = false;
				}
				else complementoParentese = (String) pop();

				if(parentese.equals(")") && !complementoParentese.equals("(")){
					completo = false;
				}
				else maiorSequencia++;
			}
		}
		if(parentese.equals("(")){
			completo = false;
		}
		else if(!isEmpty()){
			completo = false;
		}
		System.out.println(maiorSequencia);
		return completo;
	}


}

public class Queue<T> {
    private boolean tailAproximaHead;
    private boolean headAproximaTail;
    private int size;

    public T[] getFila() {
        return fila;
    }

    private T[] fila;
    private int tail;
    private int head;

    public Queue(int size) {
        this.size = size;
        this.fila =  (T[]) new Integer[size];
        this.tail = 0;
        this.head = 0;
        this.tailAproximaHead = false;
        this.headAproximaTail = false;
    }

    public void enqueue(T item) {
        if ((tail == head && this.tailAproximaHead) || (head == 0 && tail == this.fila.length)) {

            try {
                throw new QueueOverflowException("A fila já está cheia");
            } catch (QueueOverflowException e) {
                e.printStackTrace();
            }
        }


        else if (tail == this.fila.length) {
            tail = 0;
        }
        if (tail!= this.fila.length){
            this.fila[tail] = item;
            tail++;
            this.tailAproximaHead = true;
            this.headAproximaTail = false;
        }


    }

    public T dequeue(){
        T retorno = null;
        if (this.head == this.tail && this.headAproximaTail)
            try {
            throw new QueueOverflowException("A lista está vazia!");
        } catch (QueueOverflowException e) {
            e.printStackTrace();
        }
        else if(!isEmpty()) {
            if (head() == this.fila.length) {
                head = 0;
            } if (head() != this.fila.length){
                retorno = this.fila[head()];
                head++;
                this.tailAproximaHead = false;
                this.headAproximaTail = true;
            }
        }
        return retorno;
    }






    private void shiftLeft() {
        for (int i = 0; i <= this.tail ; i++) {
            this.fila[i] = this.fila[i+1];
        }
    }

    private boolean isEmpty() {
        if(tail == -1){
            return true;
        }
        return false;
    }

    private int head(){
        return this.head;
    }
}

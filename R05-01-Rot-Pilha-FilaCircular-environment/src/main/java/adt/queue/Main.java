package adt.queue;

import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class Main {
    public static void main(String[] args) throws StackUnderflowException, StackOverflowException, QueueOverflowException, QueueUnderflowException {
        StackImpl stack = new StackImpl(50);
        System.out.println(stack.checkInput("(()"));
        QueueImpl queue = new QueueImpl(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);


        int i= 0;
        System.out.println("Como a fila tava");
        while(i < 5){
            Object d = queue.dequeue();
            System.out.println(d);
            queue.enqueue(d);
            i++;
        }
        reverseQueue(queue);
        System.out.println("como a fila ta");
        i = 0;
        while(i < 5){
            Object d = queue.dequeue();
            System.out.println(d);
            queue.enqueue(d);
            i++;
        }



    }

    public static void reverseQueue(QueueImpl queue) throws QueueUnderflowException, StackOverflowException, StackUnderflowException, QueueOverflowException {
        StackImpl stack = new StackImpl(5);
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        while(!queue.isFull()){
            queue.enqueue(stack.pop());
        }
    }
}

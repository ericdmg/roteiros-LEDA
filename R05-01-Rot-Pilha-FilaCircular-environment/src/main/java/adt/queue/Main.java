package adt.queue;

import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class Main {
    public static void main(String[] args) throws StackUnderflowException, StackOverflowException {
        StackImpl stack = new StackImpl(50);
        System.out.println(stack.checkInput("(((((((((((((()))))))))))))"));

    }
}

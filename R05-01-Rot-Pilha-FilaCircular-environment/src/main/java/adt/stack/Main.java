package adt.stack;

public class Main {
    public static void main(String[] args) throws StackOverflowException {
        StackImpl stack = new StackImpl(10);
        stack.push(1);
        stack.push(2);

        stack.push(3);

        stack.push(4);

        System.out.println(stack.searchByInsertionOrder(1));


    }
}

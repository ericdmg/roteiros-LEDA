import java.io.ObjectStreamException;

public class Main {
    public static void main(String[] args) {
        /**Stack stack = new Stack(10);
         System.out.println(stack.isEmpty());
         stack.pop();
         stack.push(10);
         stack.push(15);
         stack.push(16);
         stack.push(16);
         stack.push(16);
         stack.push(16);
         stack.push(16);
         stack.push(16);
         stack.push(16);
         stack.push(48);


         for (Object element : stack.getPilha()){
         System.out.println(element);
         }
         System.out.println(stack.top() + "top!");
         **/

        Queue queue = new Queue(5);
        queue.enqueue(5);
        queue.enqueue(5);
        queue.enqueue(5);
        queue.enqueue(5);
        queue.enqueue(5);

        for (Object element : queue.getFila()) {
            System.out.println(element);

        }

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        for (Object element : queue.getFila()) {
            System.out.println(element);

        }

        queue.enqueue(6);
        for (Object element : queue.getFila()) {
            System.out.println(element);

        }
        queue.dequeue();
    }
}

package adt.linkedList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import adt.queue.QueueDoubleLinkedListImpl;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListQueueTest {

    public QueueDoubleLinkedListImpl<Integer> queue1;
    public QueueDoubleLinkedListImpl<Integer> queue2;
    public QueueDoubleLinkedListImpl<Integer> queue3;


    @Before
    public void setUp() throws QueueOverflowException {

        getImplementations();

        // Fila com 3 elementos não cheia.
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        // Fila com 2 elementos de tamanho 2. Fila cheia.
        queue2.enqueue(1);
        queue2.enqueue(2);

    }

    private void getImplementations() {
        // TODO O aluno deve ajustar aqui para instanciar sua implementação
        queue1 = new QueueDoubleLinkedListImpl<>(5);
        queue2 = new QueueDoubleLinkedListImpl<>(2);
        queue3 = new QueueDoubleLinkedListImpl<>(1);

    }

    // MÉTODOS DE TESTE
    @Test
    public void testHeadLinear() throws QueueUnderflowException {
        assertEquals(new Integer(1), queue1.head());
        queue1.dequeue();
        assertEquals(new Integer(2),queue1.head());
    }



    @Test
    public void testIsEmptyLinear() {
        assertFalse(queue1.isEmpty());
        assertTrue(queue3.isEmpty());
    }



    @Test
    public void testIsFullLinear() {
        assertFalse(queue1.isFull());
        assertTrue(queue2.isFull());
    }

    @Test
    public void testEnqueueLinear() {
        try {
            queue1.enqueue(new Integer(5));
        } catch (QueueOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    @Test(expected = QueueOverflowException.class)
    public void testEnqueueComErroLinear() throws QueueOverflowException {
        queue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
        // foi iniciada!!!
    }


    @Test
    public void testDequeueLinear() {
        try {
            assertEquals(new Integer(1), queue1.dequeue());
            assertEquals(new Integer(2), queue1.dequeue());
            assertEquals(new Integer(3), queue1.dequeue());
            assertTrue(queue1.isEmpty());
        } catch (QueueUnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    @Test(expected = QueueUnderflowException.class)
    public void testDequeueComErroLinear() throws QueueUnderflowException {
        assertEquals(new Integer(1), queue3.dequeue()); // vai depender do
        // tamanho que a fial
        // foi iniciada!!!
    }




}
package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;
	public CircularQueue<Integer> circularQueue1;
	public CircularQueue<Integer> circularQueue2;
	public CircularQueue<Integer> circularQueue3;

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

		// Fila circular com 3 elementos não cheia.
		circularQueue1.enqueue(1);
		circularQueue1.enqueue(2);
		circularQueue1.enqueue(3);

		// Fila circular com 2 elementos de tamanho 2. Fila cheia.
		circularQueue2.enqueue(1);
		circularQueue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueImpl<>(5);
		queue2 = new QueueImpl<>(2);
		queue3 = new QueueImpl<>(1);
		circularQueue1 = new CircularQueue<>(5);
		circularQueue2 = new CircularQueue<>(2);
		circularQueue3 = new CircularQueue<>(6);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHeadLinear() throws QueueUnderflowException{
		assertEquals(new Integer(1), queue1.head());
		queue1.dequeue();
		assertEquals(new Integer(2),queue1.head());
	}

	@Test
	public void testHeadCircular() throws QueueUnderflowException{
		assertEquals(new Integer(1), circularQueue1.head());
		circularQueue1.dequeue();
		assertEquals(new Integer(2), circularQueue1.head());


	}

	@Test
	public void testIsEmptyLinear() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsEmptyCircular() {
		assertFalse(circularQueue1.isEmpty());
		assertTrue(circularQueue3.isEmpty());
	}

	@Test
	public void testIsFullLinear() {
		assertFalse(queue1.isFull());
		assertTrue(queue2.isFull());
	}
	@Test
	public void testIsFullCircular() {
		assertFalse(circularQueue1.isFull());
		assertTrue(circularQueue2.isFull());
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

	@Test
	public void testEnqueueCircular() {
		try {
			circularQueue1.enqueue(new Integer(5));
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

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErroCircular() throws QueueOverflowException {
		circularQueue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
		// foi iniciada!!!
	}

	@Test
	public void testDequeueLinear() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
			assertEquals(new Integer(2), queue1.dequeue());
			assertEquals(new Integer(3), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDequeueCircular() {
		try {
			assertEquals(new Integer(1), circularQueue1.dequeue());
			assertEquals(new Integer(2), circularQueue1.dequeue());
			assertEquals(new Integer(3), circularQueue1.dequeue());
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

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErroCircular() throws QueueUnderflowException {
		assertEquals(new Integer(1), circularQueue3.dequeue()); // vai depender do
		// tamanho que a fial
		// foi iniciada!!!
	}

	@Test
	public void testTailHeadResetarCircular(){
		try {
			circularQueue3.enqueue(10);
			circularQueue3.enqueue(9);
			circularQueue3.enqueue(8);
			circularQueue3.enqueue(7);
		} catch (QueueOverflowException e) {
			e.printStackTrace();
		}

		try {
			assertEquals(new Integer(10), circularQueue3.dequeue());
			assertEquals(new Integer(9), circularQueue3.dequeue());
			assertEquals(new Integer(8), circularQueue3.dequeue());
			assertEquals(new Integer(7), circularQueue3.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			circularQueue3.enqueue(10);



		} catch (QueueOverflowException e) {
			e.printStackTrace();
		}

		try {
			assertEquals(new Integer(10), circularQueue3.dequeue());
		} catch (QueueUnderflowException e) {
			e.printStackTrace();
		}



	}
}
package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);


		// Lista com 1 elemento.
		lista3.insert(1);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new RecursiveDoubleLinkedListImpl<>();
		lista2 = new RecursiveDoubleLinkedListImpl<>();
		lista3 = new RecursiveDoubleLinkedListImpl<>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		((DoubleLinkedList<Integer>) lista2).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
		Assert.assertArrayEquals(new Integer[] { 4 }, lista2.toArray());


	}
	@Test
	public void testInsertLast() {
		((DoubleLinkedList<Integer>) lista1).insert(4);
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1, 4 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista3).insert(4);
		Assert.assertArrayEquals(new Integer[] { 1, 4 }, lista3.toArray());
		((DoubleLinkedList<Integer>) lista2).insert(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista2.toArray());
	}
	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] { }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista3).removeFirst();
		Assert.assertArrayEquals(new Integer[] { }, lista3.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());

	}
	@Test
	public void remove1(){
		// Lista com 10 elementos.
		lista2.insert(0);
		lista2.insert(1);
		lista2.insert(2);
		lista2.insert(3);
		lista2.insert(4);
		lista2.insert(5);
		lista2.insert(6);
		lista2.insert(7);
		lista2.insert(8);
		lista2.insert(9);
		lista2.insert(10);

		((DoubleLinkedList<Integer>) lista2).remove(9);
		Assert.assertArrayEquals(new Integer[] { 0,1,2,3,4,5,6,7,8,10 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).remove(1);
		Assert.assertArrayEquals(new Integer[] { 0,2,3,4,5,6,7,8,10 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).remove(8);
		Assert.assertArrayEquals(new Integer[] { 0,2,3,4,5,6,7,10 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).remove(2);
		Assert.assertArrayEquals(new Integer[] { 0,3,4,5,6,7,10 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).remove(7);
		Assert.assertArrayEquals(new Integer[] { 0,3,4,5,6,10 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).remove(3);
		Assert.assertArrayEquals(new Integer[] { 0,4,5,6,10 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).remove(6);
		Assert.assertArrayEquals(new Integer[] { 0,4,5,10 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).remove(4);
		Assert.assertArrayEquals(new Integer[] { 0,5,10 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).remove(5);
		Assert.assertArrayEquals(new Integer[] { 0,10 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).remove(0);
		Assert.assertArrayEquals(new Integer[] { 10 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).remove(10);
		Assert.assertArrayEquals(new Integer[] {  }, lista2.toArray());

	}
}
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
		lista1 = new DoubleLinkedListImpl<>();
		lista2 = new DoubleLinkedListImpl<>();
		lista3 = new DoubleLinkedListImpl<>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}

	@Test
	public void testInsertFirstVazio() {
		((DoubleLinkedList<Integer>) lista2).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).insertFirst(3);
		Assert.assertArrayEquals(new Integer[] { 3, 4 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).insert(347);
		Assert.assertArrayEquals(new Integer[] { 3, 4, 347 }, lista2.toArray());
	}

	@Test
	public void testRemoveFirst() {
		Assert.assertEquals(3,lista1.size());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
		Assert.assertEquals(2,lista1.size());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertEquals(1,lista1.size());
		Assert.assertArrayEquals(new Integer[] { 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertEquals(0,lista1.size());
		Assert.assertArrayEquals(new Integer[] {  }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] {  }, lista1.toArray());

	}

	@Test
	public void testRemoveEAdiciona() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] {  }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] {  }, lista1.toArray());

		((DoubleLinkedList<Integer>) lista1).insert(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).insertFirst(5);
		Assert.assertArrayEquals(new Integer[] { 5,4 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 4 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] {  }, lista1.toArray());



	}
	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
	}
}
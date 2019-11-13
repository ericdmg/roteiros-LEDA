package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import adt.bst.BSTNode;

import java.util.Arrays;

public class StudentAVLTest {

	private AVLTree<Integer> avl;
	private BSTNode<Integer> NIL = new BSTNode<Integer>();

	private void fillTree() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40,5 };
		for (int i : array) {
			System.out.println(i);
			avl.insert(i);
			System.out.println(Arrays.toString(avl.preOrder()));

		}
	}

	@Before
	public void setUp() {
		avl = new AVLTreeImpl<>();
	}

	@Test
	public void testInit() {
		assertTrue(avl.isEmpty());
		assertEquals(0, avl.size());
		assertEquals(-1, avl.height());
		assertEquals(NIL, avl.getRoot());
	}

	@Test
	public void testInsert() {
		avl.insert(-10);
		assertEquals(1, avl.size());
		assertEquals(0, avl.height());
		assertArrayEquals(new Integer[] { -10 }, avl.preOrder());

		assertFalse(avl.isEmpty());
		assertEquals(new Integer(-10), avl.getRoot().getData());

		avl.insert(-15);
		assertEquals(2, avl.size());
		assertEquals(1, avl.height());
		assertArrayEquals(new Integer[] { -10, -15 }, avl.preOrder());

		avl.insert(20);
		assertEquals(3, avl.size());
		assertEquals(1, avl.height());
		assertArrayEquals(new Integer[] { -10, -15, 20 }, avl.preOrder());
	}

	@Test
	public void testInsert2(){ // left -> right dps vira left / left
		avl.insert(7);
		avl.insert(3);
		avl.insert(11);
		avl.insert(4);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 7,3,4,11}, avl.preOrder());
		avl.remove(11);
		assertEquals(1,avl.height());
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 4,3,7 }, avl.preOrder());
	}

	@Test
	public void testInsert3(){ // right -> right
		avl.insert(7);
		avl.insert(3);
		avl.insert(11);
		avl.insert(12);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 7,3,11,12 }, avl.preOrder());
		avl.remove(3);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertEquals(1,avl.height());
		assertArrayEquals(new Integer[] { 11,7,12 }, avl.preOrder());
	}

	@Test
	public void testInsert4(){ // right -> left
		avl.insert(7);
		avl.insert(3);
		avl.insert(11);
		avl.insert(10);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 7,3,11,10 }, avl.preOrder());
		avl.remove(3);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 10,7,11 }, avl.preOrder());
	}

	@Test
	public void testInsert5(){ // left -> left
		avl.insert(7);
		avl.insert(3);
		avl.insert(11);
		avl.insert(2);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 7,3,2,11 }, avl.preOrder());
		avl.remove(11);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 3,2,7 }, avl.preOrder());
	}
	@Test
	public void testRemove() {
		avl.insert(55);
		avl.insert(9);
		avl.insert(91);
		avl.insert(12);

		avl.remove(-1);
		assertEquals(4, avl.size());

		avl.remove(91);
		assertEquals(3, avl.size());
		assertArrayEquals(new Integer[] { 12, 9, 55 }, avl.preOrder());

		avl.remove(12);
		assertEquals(2, avl.size());
		assertArrayEquals(new Integer[] { 55, 9 }, avl.preOrder());

		avl.remove(9);
		avl.remove(55);
		assertEquals(NIL, avl.getRoot());
		assertTrue(avl.isEmpty());
	}

	@Test
	public void testRemove2(){// remover nó com 2 filhos, raiz pesada pra direita após rotação
		avl.insert(7);
		avl.insert(3);
		avl.insert(11);
		avl.insert(2);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 7,3,2,11 }, avl.preOrder());

		avl.remove(7);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 3,2,11 }, avl.preOrder());
	}

	@Test
	public void testRemove3(){// remover nó com 2 filhos, raiz pesada pra esquerda após rotação
		avl.insert(7);
		avl.insert(3);
		avl.insert(11);
		avl.insert(12);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 7,3,11,12 }, avl.preOrder());

		avl.remove(7);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 11,3,12 }, avl.preOrder());
	}

	@Test
	public void testRemove4(){// remover nó com 1 filho à direita, raiz pesada pra direita após rotação
		avl.insert(7);
		avl.insert(3);
		avl.insert(11);
		avl.insert(2);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 7,3,2,11 }, avl.preOrder());

		avl.remove(3);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 7,2,11 }, avl.preOrder());
	}

	@Test
	public void testRemove5(){// remover nó com 1 filho à esquerda, raiz pesada pra esquerda após rotação
		avl.insert(7);
		avl.insert(3);
		avl.insert(11);
		avl.insert(10);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 7,3,11,10 }, avl.preOrder());

		avl.remove(11);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertArrayEquals(new Integer[] { 7,3,10 }, avl.preOrder());
	}

	@Test
	public void testMinMax() {
		avl.insert(6);
		assertEquals(new Integer(6), avl.minimum().getData());
		assertEquals(new Integer(6), avl.maximum().getData());

		avl.insert(23);
		assertEquals(new Integer(6), avl.minimum().getData());
		assertEquals(new Integer(23), avl.maximum().getData());

		avl.insert(-34);
		assertEquals(new Integer(-34), avl.minimum().getData());
		assertEquals(new Integer(23), avl.maximum().getData());

		avl.insert(5);
		assertEquals(new Integer(-34), avl.minimum().getData());
		assertEquals(new Integer(23), avl.maximum().getData());

		avl.insert(9);
		assertEquals(new Integer(-34), avl.minimum().getData());
		assertEquals(new Integer(23), avl.maximum().getData());
	}

	@Test
	public void testSucessorPredecessor() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(null, avl.predecessor(-40));
		assertEquals(new Integer(-34), avl.sucessor(-40).getData());

		assertEquals(new Integer(-40), avl.predecessor(-34).getData());
		assertEquals(new Integer(0), avl.sucessor(-34).getData());

		assertEquals(new Integer(-34), avl.predecessor(0).getData());
		assertEquals(new Integer(2), avl.sucessor(0).getData());

		assertEquals(new Integer(0), avl.predecessor(2).getData());
		assertEquals(new Integer(5), avl.sucessor(2).getData());
		assertEquals(new Integer(67), avl.sucessor(23).getData());
	}

	@Test
	public void testSize() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		int size = 12;
		assertEquals(size, avl.size());
		while (!avl.isEmpty()) {
			avl.remove(avl.getRoot().getData());
			assertEquals(--size, avl.size());
		}
	}

	@Test
	public void testHeight() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232
		System.out.println(Arrays.toString(avl.preOrder()));
		Integer[] preOrder = new Integer[] { 6, 2, -34, -40, 0, 5, 23, 9, 12, 76, 67, 232 };
		assertArrayEquals(preOrder, avl.preOrder());
		assertEquals(3, avl.height());

		avl.remove(0);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertEquals(3, avl.height());

		avl.remove(2);
		System.out.println(Arrays.toString(avl.preOrder()));
		assertEquals(3, avl.height());
	}

	@Test
	public void testRemove6() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] order = { -40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, avl.order());

		avl.remove(6);
		order = new Integer[] { -40, -34, 0, 2, 5, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, avl.order());

		avl.remove(9);
		order = new Integer[] { -40, -34, 0, 2, 5, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, avl.order());

		assertEquals(NIL, avl.search(6));
		assertEquals(NIL, avl.search(9));

	}

	@Test
	public void testSearch() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(new Integer(-40), avl.search(-40).getData());
		assertEquals(new Integer(-34), avl.search(-34).getData());
		assertEquals(NIL, avl.search(2534));
	}
}

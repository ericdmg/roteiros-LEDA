package adt.heap;

import org.junit.Before;

import java.util.Comparator;

public class StudentPriorityQueueTest {
    PriorityQueue<Integer> pq;

    @Before
    public void setUp() {
        // TODO Instancie seu comparator para fazer sua estrutura funcionar como
        // uma min heap aqui. Use instanciacao anonima da interface
        // Comparator!!!!
        Comparator comparator = new CompareByPriority();
        pq = new PriorityQueue<>(comparator);
    }
}

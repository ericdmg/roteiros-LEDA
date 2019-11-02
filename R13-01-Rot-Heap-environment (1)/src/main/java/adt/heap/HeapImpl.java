package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import util.Util;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o maior sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 3 > 2),
 * essa heap deixa os elementos maiores no topo. Essa comparação não é feita 
 * diretamente com os elementos armazenados, mas sim usando um comparator. 
 * Dessa forma, dependendo do comparator, a heap pode funcionar como uma max-heap 
 * ou min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

   protected T[] heap;
   protected int index = -1;
   /**
    * O comparador é utilizado para fazer as comparações da heap. O ideal é
    * mudar apenas o comparator e mandar reordenar a heap usando esse
    * comparator. Assim os metodos da heap não precisam saber se vai funcionar
    * como max-heap ou min-heap.
    */
   protected Comparator<T> comparator;

   private static final int INITIAL_SIZE = 20;
   private static final int INCREASING_FACTOR = 10;

   /**
    * Construtor da classe. Note que de inicio a heap funciona como uma
    * min-heap.
    */
   @SuppressWarnings("unchecked")
   public HeapImpl(Comparator<T> comparator) {
      this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
      this.comparator = comparator;
   }

   // /////////////////// METODOS IMPLEMENTADOS
   private int parent(int i) {
      return (i - 1) / 2;
   }

   /**
    * Deve retornar o indice que representa o filho a esquerda do elemento
    * indexado pela posicao i no vetor
    */
   private int left(int i) {
      return (i * 2 + 1);
   }

   /**
    * Deve retornar o indice que representa o filho a direita do elemento
    * indexado pela posicao i no vetor
    */
   private int right(int i) {
      return (i * 2 + 1) + 1;
   }

   @Override
   public boolean isEmpty() {
      return (index == -1);
   }

   @Override
   public T[] toArray() {
      ArrayList<T> resp = new ArrayList<T>();
      for (int i = 0; i <= this.index; i++) {
         resp.add(this.heap[i]);
      }
      return (T[]) resp.toArray(new Comparable[0]);
   }

   // ///////////// METODOS A IMPLEMENTAR
   /**
    * Valida o invariante de uma heap a partir de determinada posicao, que pode
    * ser a raiz da heap ou de uma sub-heap. O heapify deve colocar os maiores
    * (comparados usando o comparator) elementos na parte de cima da heap.
    */
   private void heapify(int position) {
      int largest = position;
      int right = right(position);
      int left = left(position);
      T[] heap = getHeap();
      Comparator<T> comparator = getComparator();
      if (heap[left] != null) {
         if (comparator.compare(heap[left], heap[largest]) > 0) {
            if (heap[right] == null || comparator.compare(heap[left], heap[right]) > 0) {
               largest = left;
            }
         }
      }

      if (heap[right] != null) {
         if (comparator.compare(heap[right], heap[largest]) > 0 && comparator.compare(heap[right], heap[left]) > 0) {
            largest = right;
         }
      }

      if (largest != position) {
         Util.swap(heap, position, largest);
         heapify(parent(position));
         if (topDown(heap, largest)) {
            heapify(largest);
         }
      }

   }
    //Este método verifica se o heapify a ser executado utiliza a
    //abordagem top -> down
   private boolean topDown(T[] heap, int largest) {
      boolean answer = false;
      if (left(largest) >= this.heap.length || right(largest) >= this.heap.length) {
         answer = false;
      } else if (heap[left(largest)] != null && getComparator().compare(heap[left(largest)], heap[largest]) > 0) {
         answer = true;
      }

      else if (heap[right(largest)] != null && getComparator().compare(heap[right(largest)], heap[largest]) > 0) {
         answer = true;
      }
      return answer;
   }

   @Override
   public void insert(T element) {
      if (element != null) {
         // ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
         if (index == heap.length - 1) {
            heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
         }
         this.index++;
         getHeap()[index] = element;
         heapify(parent(index));
      }

   }

   @Override
   public void buildHeap(T[] array) {
      if (array != null) {
         if (!isEmpty()) {
            index = -1;
            this.heap = (T[]) (new Comparable[array.length]);
         }
         for (int i = 0; i < array.length; i++) {
            insert(array[i]);
         }
      }

   }

   @Override
   public T extractRootElement() {
      T extractedRoot = null;
      if (!isEmpty()) {
         extractedRoot = getHeap()[0];
         getHeap()[0] = getHeap()[this.index];
         getHeap()[this.index] = null;
         this.index--;
         heapify(0);

      }
      return extractedRoot;
   }

   @Override
   public T rootElement() {
      T root = null;
      if (!isEmpty()) {
         root = getHeap()[0];
      }
      return root;
   }

   @Override
	public T[] heapsort(T[] array) {
	    if(array != null) {
	        Comparator<T> currentComparator = this.getComparator();
            this.setComparator((o1, o2) -> o2.compareTo(o1));
            buildHeap(array);

            for (int i = 0; i < array.length; i++) {
                array[i] = this.extractRootElement();
            }

            this.setComparator(currentComparator);
        }


		return array;
	}

   @Override
   public int size() {
      return index + 1;
   }

   public Comparator<T> getComparator() {
      return comparator;
   }

   public void setComparator(Comparator<T> comparator) {
      this.comparator = comparator;
   }

   public T[] getHeap() {
      return heap;
   }

}

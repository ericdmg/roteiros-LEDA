import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.SelectionSort;

public class Main {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        Integer[] array = new Integer[10];
        array[0] = 5;
        array[1] = 4;
        array[2] = 3;
        array[3] = 2;
        array[4] = 7;
        array[5] = 12;
        array[6] = 132;
        array[7] = 464;
        array[8] = 78;
        array[9] = 48;


        //bubbleSort.sort(array,0,array.length-1);
        selectionSort.sort(array,0,array.length-1);
        for(Integer a : array){
            System.out.println(a);
        }
    }
}

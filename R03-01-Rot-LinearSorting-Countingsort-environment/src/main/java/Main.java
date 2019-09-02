import sorting.linearSorting.CountingSort;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1,1,4,5,6,7,4};
        CountingSort countingSort = new CountingSort();
        countingSort.sort(array,0,array.length-1);
    }
}

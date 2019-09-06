import orderStatistic.OrderStatisticsSelectionImpl;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        OrderStatisticsSelectionImpl orderStatisticsSelection = new OrderStatisticsSelectionImpl();
        Integer[] array = {4,2,7,8,9,3,4};
        System.out.println(orderStatisticsSelection.getOrderStatistics(array,3));

    }


    private static Integer[] geradorArray(int n){
        Random gerador = new Random();
        Integer []v = new Integer[n];
        for(int i = 0; i < n; i++){
            v[i] = gerador.nextInt(n);
        }
        return v;
    }
}

package adt.heap;

import java.util.Comparator;

public class Position<T>  implements Comparable<Position> {
    public T getData() {
        return data;
    }

    T data;
    Integer priority;

    public Position(T data, int priority) {
        this.data = data;
        this.priority = priority;
    }

    public Integer getPriority() {
        return this.priority;
    }


    @Override
    public int compareTo(Position o) {
        return 0;
    }
}

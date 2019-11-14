package adt.heap;

import java.util.Comparator;

public class CompareByPriority implements Comparator<Position> {
    public int compare(Position pos1, Position pos2){
        return pos1.getPriority().compareTo(pos2.getPriority());
    }
}
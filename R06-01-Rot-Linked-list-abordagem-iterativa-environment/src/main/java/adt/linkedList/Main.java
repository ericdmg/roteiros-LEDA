package adt.linkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedListImpl lista1 = new DoubleLinkedListImpl<>();
        DoubleLinkedListImpl lista2 = new DoubleLinkedListImpl<>();
        System.out.println("FIRST INDEX");
        lista1.insert(1);
        lista1.insert(2);
        lista1.insert(3);
        lista1.insert(4);
        System.out.println(lista1.firstIndex(1));
        System.out.println(lista1.lastIndex(4));

        System.out.println("LAST INDEX");
        lista2.insert(1);
        lista2.insert(1);
        lista2.insert(2);
        lista2.insert(2);
        System.out.println(lista2.lastIndex(1));
        System.out.println(lista2.lastIndex(2));

        System.out.println("REMOVE BY INDEX");
        lista1.removeByIndex(1);
        System.out.println(Arrays.toString(lista1.toArray()));

        lista1.reverseList();
        System.out.println(Arrays.toString(lista1.toArray()));
    }
}

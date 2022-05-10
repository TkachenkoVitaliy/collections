package org.customcollections;

import java.sql.SQLOutput;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("ABC");
        list.add("DEF");
        list.add("KLM");
        list.add("XYZ");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        System.out.println(list.remove(2));
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        list.addFirst("AAA");
        list.add("ZZZ", 2);
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        System.out.println("\n");

        for (String text : list) {
            System.out.println(text);
        }
        LinkedList<String> linkedList = new LinkedList<>();
    }
}

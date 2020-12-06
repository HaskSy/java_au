package designpatterns.LRUCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
        myLinkedHashMap.addAtHead("Hi", 1);
        myLinkedHashMap.addAtHead("Hia", 2);
        myLinkedHashMap.addAtHead("Hib", 3);
        myLinkedHashMap.addAtHead("Hic", 124);
        myLinkedHashMap.addAtHead("Hid", 152);


        for (Map.Entry<String, Integer> a: myLinkedHashMap) {
            System.out.println(a);
        }

    }
}
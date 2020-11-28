package LinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Student> listStudents = new MyLinkedList<>();
        listStudents.addAtHead(new Student("Ivanov", 202, 2));
        listStudents.addAtHead(new Student("Petrov", 202, 2));
        listStudents.addAtHead(new Student("Sidorov", 201, 3));
        listStudents.addAtHead(new Student("Guy", 322, 1337));

        for(Student student: listStudents) {
            System.out.println(student);
        }

        System.out.println("\n\n");
        Iterator<Student> studentIterator = listStudents.iterator();
        while (studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }

    }
}

package hello.core.datastructure;

import java.util.ArrayList;

public class ArrayListMainTest {

    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();
        arrayListTest.addLast(10);
        arrayListTest.addLast(20);
        arrayListTest.addLast(30);
        arrayListTest.addLast(40);

//        for (int i = 0; i < arrayListTest.size(); i++) {
//            System.out.println(arrayListTest.get(i));
//        }

        ArrayListTest.ListIterator li = arrayListTest.listIterator();

        while (li.hasNext()) {
            int number = (int) li.next();
            if (number == 30) {
                li.remove();
            }
        }

        System.out.println(arrayListTest);
    }
}

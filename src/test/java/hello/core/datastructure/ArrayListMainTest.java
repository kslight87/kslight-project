package hello.core.datastructure;

public class ArrayListMainTest {

    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();
        arrayListTest.addLast(10);
        arrayListTest.addLast(20);
        arrayListTest.addLast(30);
        arrayListTest.addLast(40);
        arrayListTest.add(1, 15);
        arrayListTest.addFirst(5);
        System.out.println("arrayListTest.toString() = " + arrayListTest);
    }
}

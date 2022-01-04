package hello.core.datastructure;

public class ArrayListMainTest {

    public static void main(String[] args) {
        ArrayList arrayListTest = new ArrayList();
        arrayListTest.addLast(10);
        arrayListTest.addLast(20);
        arrayListTest.addLast(30);
        arrayListTest.addLast(40);

//        for (int i = 0; i < arrayListTest.size(); i++) {
//            System.out.println(arrayListTest.get(i));
//        }

        ArrayList.ListIterator li = arrayListTest.listIterator();

        while (li.hasNext()) {
            int number = (int) li.next();
            if (number == 30) {
                li.remove();
            }
        }

        System.out.println(arrayListTest);
    }
}

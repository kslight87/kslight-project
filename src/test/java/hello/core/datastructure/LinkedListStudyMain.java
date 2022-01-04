package hello.core.datastructure;

public class LinkedListStudyMain {
    public static void main(String[] args) {
        LinkedListStudy list = new LinkedListStudy();
		list.add(10, 0);
		System.out.println(list);
		list.add(20, 1);
		System.out.println(list);
		list.add(30, 2);
		System.out.println(list);
        list.add(25, 2);
        System.out.println(list);
        list.add(0, 0);
        System.out.println(list);

		list.remove(0);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);

        System.out.println(list.contains(10));
        System.out.println(list.contains(20));
        System.out.println(list.contains(30));
    }
}

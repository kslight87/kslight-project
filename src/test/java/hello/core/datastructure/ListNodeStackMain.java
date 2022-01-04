package hello.core.datastructure;

public class ListNodeStackMain {
    public static void main(String[] args) {
        ListNodeStack stack = new ListNodeStack();
        stack.push(10);
        System.out.println("push" + stack);
        stack.push(20);
        System.out.println("push" + stack);
        stack.push(30);
        System.out.println("push" + stack);

        stack.pop();
        System.out.println("popup" + stack);
        stack.pop();
        System.out.println("popup" + stack);
        stack.pop();
        System.out.println("popup" + stack);
        stack.pop();
    }
}

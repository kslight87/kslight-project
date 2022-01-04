package hello.core.datastructure;

public class StackMain {
    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(0);
        System.out.println("push" + stack);
        stack.push(1);
        System.out.println("push" + stack);
        stack.push(2);
        System.out.println("push" + stack);
        stack.push(3);
        System.out.println("push" + stack);
        stack.push(4);

        stack.pop();
        System.out.println("pop" + stack);
        stack.pop();
        System.out.println("pop" + stack);
        stack.pop();
        System.out.println("pop" + stack);
        stack.pop();
        System.out.println("pop" + stack);
        stack.pop();
    }
}

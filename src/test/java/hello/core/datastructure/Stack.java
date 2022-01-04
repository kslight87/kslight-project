package hello.core.datastructure;

public class Stack {
    int[] stackArr;
    int top = -1;
    int size = 0;

    public Stack(int arrSize) {
        System.out.println("Stack sise is " + arrSize);
        size = arrSize;
        stackArr = new int[arrSize];
    }

    public void push(int data){
        if(size-1 == top){
            System.out.println("Stack is Full");
        }else{
            stackArr[++top] = data;
        }
    }

    public int pop(){
        int popData = -1;
        if(top < 0){
            System.out.println("Stack is Empty");
        }else{
            popData = stackArr[top--];
        }
        return popData;
    }

    public String toString(){
        String str = "[ ";
        if(top > -1){
            for(int i=0; i<top; i++){
                str += String.valueOf(stackArr[i]) + " -> ";
            }
            str += String.valueOf(stackArr[top]);
        }

        return str += " ]";
    }
}

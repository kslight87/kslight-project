package hello.core.datastructure;

public class Queue {
    int[] arrQueue;
    int max = 0;
    int size = 0;
    int front = -1;
    int rear = -1;

    public Queue(int size) {
        arrQueue = new int[size];
        this.max = size;
    }

    public void offer(int data) {
        if(max == size){
            System.out.println("Queue is Full");
            return;
        }else{
            if(size == 0){
                arrQueue[size] = data;
                front = size;
                rear = size;
                size++;
            }else{
                arrQueue[++rear] = data;
                size++;
            }

        }
    }

    public int poll(){
        if(size == 0){
            System.out.println("Queue is Empty");
            this.front = -1;
            this.rear = -1;
            this.size = 0;
            return -1;
        }else{
            size--;
            return arrQueue[front++];
        }
    }

    public String toString(){
        String str = "";
        if(size > 0){
            if(size == 1){
                str = String.valueOf(arrQueue[front]);
            }else{
                for(int i = front; i<=rear; i++){
                    if(i == front){
                        str = String.valueOf(arrQueue[i]);
                    }else{
                        str = arrQueue[i] + " -> " + str;
                    }
                }
            }
        }
        return "[ " + str + " ]";
    }

}

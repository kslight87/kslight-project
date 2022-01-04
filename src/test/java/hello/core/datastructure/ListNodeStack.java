package hello.core.datastructure;

public class ListNodeStack {
    ListNode head;
    ListNode top;
    int size = 0;

    class ListNode{
        int data;
        ListNode next;

        public ListNode(int input) {
            this.data = input;
            this.next = null;
        }
    }

    public void push(int data){
        ListNode x = head;
        ListNode newNode = new ListNode(data);

        if(size == 0){
            head = newNode;
        }else{
            while(x.next != null){
                x = x.next;
            }
            x.next = newNode;
        }
        size++;
    }

    public int pop(){
        ListNode x = head;
        int returnPop = -1;
        if(size == 0){
            System.out.println("Stack is Empty");
        }
        else if(size == 1){
            head = null;
            returnPop = 0;
        }else{
            while(x.next.next != null){
                x = x.next;
            }
            returnPop = x.next.data;
            x.next = null;
        }
        size--;
        return returnPop;
    }

    public String toString(){
        ListNode x = head;
        String str = "[ ";
        if(size > 0){
            for(int i = 0; i<size-1; i++){
                str += String.valueOf(x.data) + " -> ";
                x = x.next;
            }
            str += String.valueOf(x.data);
        }

        return str += " ]";
    }
}

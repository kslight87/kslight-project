package hello.core.datastructure;

public class LinkedListStudy {
    ListNode head;
    ListNode tail;
    int size = 0;

    // 정수를 저장하는 ListNode 클래스
    static class ListNode{
        int data;
        ListNode next;

        public ListNode(int input) {
            this.data = input;
            this.next = null;
        }
    }

    public void addFirst(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;

        if(head.next == null){
            tail = head;
        }
        size++;
    }

    public void addLast(int data){
        if(size == 0){
            addFirst(data);
        }else{
            ListNode x = head;
            ListNode newNode = new ListNode(data);

            while(x.next != null){
                x = x.next;
            }

            x.next = newNode;
            tail = newNode;

            size++;
        }

    }

    private ListNode node(int index){
        ListNode x = head;
        for(int i = 0; i<index; i++){
            x = x.next;
        }

        return x;
    }

    public ListNode add(int data, int position){
        ListNode x = head;
        return add(x, data, position);
    }

    private ListNode add(ListNode head, int nodeToAdd, int position){
        ListNode newNode = null;
        if(position == 0){
            addFirst(nodeToAdd);
        }else if(size > 0 && size == position){
            addLast(nodeToAdd);
        }else{
            newNode = new ListNode(nodeToAdd);
            for(int i = 0; i<position-1; i++){
                head = head.next;
            }

            newNode.next = head.next;
            head.next = newNode;
            size++;
        }

        return newNode;
    }

    public void removeFirst(){
        if(size == 1){
            this.head = null;
            size--;
        }
        else if(size > 1){
            ListNode temp = head.next.next;
            head = head.next;
            head.next = temp;

            if(temp == null){
                this.tail = head;
            }
            size--;
        }

    }

    public void removeLast(){
        ListNode x = head;
        if(size > 0){
            if(size == 1){
                removeFirst();
            }
            else if(size > 1){
                while(x.next.next != null){
                    x = x.next;
                }

                x.next = null;
                this.tail = x;
                size--;
            }
        }
    }

    public ListNode remove(int positionToRemove){
        ListNode x = head;
        return remove(x, positionToRemove);
    }

    private ListNode remove(ListNode head, int positionToRemove){
        if(positionToRemove == 0 ){
            removeFirst();
        }
        else if(size > 0 && positionToRemove == size){
            removeLast();
        }
        else{
            for(int i=0; i<positionToRemove-1; i++){
                head = head.next;
            }
            if(head.next.next == null){
                head.next = null;
            }else{
                head.next = head.next.next;
            }
            size--;
        }
        return head;
    }


    public boolean contains(int nodeToCheck) {
        ListNode x = head;
        return contains(x, nodeToCheck);
    }

    private boolean contains(ListNode x, int nodeToCheck){
        boolean nodeChk = false;
        if(size > 0){
            while(x.next != null){
                if(x.data == nodeToCheck){
                    nodeChk = true;
                    return nodeChk;
                }else{
                    x = x.next;
                }
            }
            if(x.data == nodeToCheck){
                nodeChk = true;
                return nodeChk;
            }
        }

        return nodeChk;
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

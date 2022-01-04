package hello.core.datastructure;

public class LinkedList {
    private Node head;  // List의 첫 번째 Node
    private Node tail;  // List의 마지막 Node
    private int size = 0; // List에 포함된 노드의 숫자

    // LinkedList는 객체와 객체(노드와 노드)끼리 연결해서 만든 List이기 때문에 객체를 생성할 Node 클래스 정의
    private class Node {
        // Node 의 속성
        private Object data; // Node가 저장할 데이터
        private Node next;   // Node의 다음 Node 데이터(현재 Node가 가르키는 데이터 역시 Node이기 때문에 당연히 데이터 타입을 Node로 선언한다.)

        // Node의 생성자
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        // 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
        public String toString(){
            return String.valueOf(this.data);
        }

    }

    // List의 첫 번째에 Node 추가
    public void addFirst(Object input) {
        Node newNode = new Node(input); // Node 클래스가 객체화 되고 생성자를 통해 input값이 data 필드에 저장된다.
        newNode.next = head; // 새로운 Node의 Next에 head 값을 저장한다. (첫 번쨰는 null이 들어간다.)
        head = newNode; // 새로운 Node를 head 필드에 저장한다.
        size++; // List에 추가된 Node를 표시하기 위해 size를 증가한다.

        // addFirst()가 처음 실행될 때에만 생성자를 통해 next 필드 값이 null이 들어가기 때문에 첫 번째에만 실행된다.
        if (head.next == null) {
            tail = head;
        }
    }

    // List의 마지막에 Node 추가
    public void addLast(Object input) {
        Node newNode = new Node(input);

        // size가 0인 경우 List에 Node가 하나도 없기 때문에 addFirst로 Node를 생성해도 상관없다.
        if (size == 0) {
            addFirst(input);
        }else{
            // List에 Node가 없는 경우 tail에 데이터가 없기 때문에 size가 0인 경우 addFirst로 Node를 추가한다.
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    // 내부적함수. return 값 자체가 node이기 때문에 사용자가 node 함수에 대해 알아서는 안된다.
    private Node node(int index) {
        Node x = head; // List의 첫 번째를 가져온다.
        // 입력받은 index까지 반복문을 실행한다.
        for (int i = 0; i < index; i++) {
            x = x.next; // List의 첫 번째 Node부터 next 객체를 이용하여 List Node 객체를 이동한다.
        }

        return x; // index 이전의 Node에서 반복문은 종료되고 이전 Node에서 next 객체를 할당받아 찾고자 하는 Node를 return 한다.
    }

    // 중간에 Node 삽입
    public void add(int k, Object input) {
        if (k == 0) {
            addFirst(input);
        }
        else{
            Node temp1 = node(k-1); // node 함수에서 찾은 index k-1의 Node 객체를 조회해서 temp1 객체 변수에 담는다.
            Node temp2 = temp1.next; // temp1의 next 객체. newNode의 next에 대입시킨다.
            Node newNode = new Node(input); // 입력받은 input 값의 Node 객체 생성

            temp1.next = newNode; // 신규 Node의 이전 Node의 next가 신규 Node를 바라보도록 링크를 걸어준다.
            newNode.next = temp2; // 신규 Node 객체의 next가 temp1.next를 바라보도록 링크를 걸어준다.
            if (newNode.next == null) {
                tail = newNode; // 신규 Node 이후 다음 Node가 없다면 tail 객체를 신규 Node로 변경한다.
            }
            size++;

            /*
            Node x = head;
            Node newNode = new Node(input);
            for (int i = 0; i < k; i++) {
                if(i == k-1){
                    newNode.next = x.next;
                    x.next = newNode;
                }else{
                    x = x.next;
                }
            }
            */
        }
    }

    // List 데이터 출력
    public String toString(){
        if (head == null) {
            return "[no data]";
        } else {
            Node temp = head; // List의 첫 번째 Node 불러오기
            StringBuilder str = new StringBuilder("[");
            while (temp.next != null) { // Node의 다음 next가 비어있을 때 까지 반복
                str.append(temp.data + ", ");
                temp = temp.next; // 다음 Node 호출
            }
            str.append(temp.data); // 마지막 Node 데이터를 입력한다.
            return str + "]";
        }
    }

    // List의 첫 번째를 삭제한다. return 값은 삭제한 데이터로 한다.
    public Object removeFirst() {
        Node temp = head; // 삭제할 head 값을 temp 변수에 저장
        head = temp.next; // head는 삭제 예정이므로 head의 다음 Node를 head로 지정한다.
        Object returnData = temp.data; // 삭제 후 반환할 데이터를 임시 변수에 저장함
        temp = null; // 삭제할 객체를 null 처리 해준다.
        size--; // List의 Node 사이즈 감소
        return returnData;
    }

    // List의 중간 Node 삭제
    public Object remove(int k) {
        // 첫 번째 Node 삭제 시 removeFirst() 사용
        if (k == 0) {
            return removeFirst();
        }
        // 그 외 나머지 Node를 삭제하려고 한다면 삭제할 Node의 이전 Node를 알아야 한다.
        // 이전 Node의 next가 삭제할 Node에서 그 다음 Node를 가르키게 된다면 삭제 대상 Node는 링크를 잃어버리기 됨으로써 더이상 List의 멤버가 아니게 된다.
        else{
            Node temp = node(k - 1); // 삭제 하고자 하는 Node의 이전 Node 객체를 가져온다.
            Node todoDeleted = temp.next; // 삭제할 Node
            temp.next = temp.next.next; // 삭제할 Node의 이전 Node의 next 객체를 삭제할 대상 Node의 다음 Node 객체로 링크한다.
            Object returnData = todoDeleted.data; // 삭제 후 return 할 데이터 임시 저장
            if (todoDeleted == tail) { // 삭제할 Node가 마지막 Node라면 삭제 할 Node의 이전 Node를 tail 객체로 지정한다.
                tail = temp;
            }
            todoDeleted = null; // 삭제 Node 초기화 (안해줘도 된다. GC에 의해 자동으로 소멸)
            size--; // Node size 를 -1 감소
            return returnData;
        }
    }

    // List의 마지막 Node 삭제
    public  Object removeLast() {
        return remove(size-1); // 삭제할 대상의 이전 Node의 next값을 지워줘야 하기 때문에 한단계씩 찾아나가면서 마지막 Node를 삭제한다.
    }

    // List의 전체 Node 갯수 가져오기
    public int size() {
        return size;
    }

    // 특정 Node의 값 가져오기
    public Object get(int k) {
        Node temp = node(k);
        return temp.data;
    }

    // 특정한 데이터가 어떤 위치에 존재하는지 조회
    public int indexOf(Object data) {
        Node temp = head; // List의 첫 번쨰 Node 객체
        int result = -1;  // 찾는 결과 값이 없을 경우 -1 return
        int index = 0; // 찾고자 하는 데이터의 위치 index 값

        while (temp.data != data ) { // List의 첫 번째 Node의 data와 찾고자하는 data가 같지 않을 경우 반복문 실행
            temp = temp.next; // Node 객체의 next를 불러오면서 List의 Node 이동
            index++; // 반복할 떄 마다 index를 1씩 증가
            if (temp == null) { // 다음 Node가 null이라면 탐색 대상이 없으므로 -1을 return 한다.
                return result;
            }
        }
        return index; // 반복문으로 Node를 순회하면서 찾고자 하는 data를 찾으면 반복문이 종료되고 index 값 return
    }

    // ListIterator 클래스 객체 생성자 호출
    public ListIterator listIterator() {
        return new ListIterator();
    }

    // List에 저장된 데이터를 반복하여 접근할 때 사용하는 메소드를 모아 놓은 인터페이스 이다.
    class ListIterator {
        private Node next;
        public Node lastReturned;
        private int nextIndex;

        // ListIterator 클래스 객체 생성자
        public ListIterator() {
            this.next = head; // ListIterator 생성자가 호출되서 객체가 생성되면 List head 객체를 ListIterator의 next 객체에 지정한다.
        }

        // List의 Node를 첫 번째부터 이동한다.
        public Object next() {
            lastReturned = next; // 첫 호출 시 head 객체가 들어있다.
            next = next.next; // next Node의 다음 Node로 이동 한다.
            nextIndex++;
            return lastReturned.data;
        }

        // List Node를 선회하기 전 다음 Node에 객체가 존재하는지 체크하고 boolean 타입으로 return 한다.
        public boolean hasNext() {
            return nextIndex < size(); // nextIndex가 List Node의 갯수보다 작다면 더 호출할 Node가 남아있다는 뜻이므로 true를 return 한다.
        }

        // List Node를 next()로 선회하면서 List 중간에 Node를 추가한다.
        public void add(Object input) {
            Node newNode = new Node(input); // 입력받은 새로운 Node 객체

            if (lastReturned == null) { // lastReturned가 null이면 next()가 선언되지 않았다는 뜻이므로 List에 첫 번째로 추가한다.
                head = newNode;
                newNode.next = next;
            }else{ // 그 외
                lastReturned.next = newNode; // 마지막으로 return Node의 next 객체에 새로운 Node를 지정한다.
                newNode.next = next; // 새로운 Node의 next 객체에 next()에서 지정한 next Node의 다음 Node를 지정한다.
            }

            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        // List Node를 next()로 선회하면서 Node를 삭제한다.
        public void remove() {
            if (nextIndex == 0) { // 아무런 Node를 선택하지 않은 상태(next()함수 실행하지 않은 상태)
                throw new IllegalStateException();
            }
            LinkedList.this.remove(nextIndex - 1);
            nextIndex--;
        }
    }



}

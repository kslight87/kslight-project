package hello.core.datastructure;

public class ArrayList {
    private int size = 0;
    private Object[] arrayListData = new Object[100]; // Java의 ArrayList 클래스는 리스트 배열의 크기를 가변적으로 늘리도록 코딩 되어있다.

    public void addFirst(Object data){
        add(0, data);
    }


    // 리스트의 중간에 데이터를 삽입하는 경우 데어탁 삽입된 배열의 끝에서 부터 삽입할 인덱스 자리까지 한 자리씩 데이터를 옮겨 담고
    // 선택한 인덱스에 새로운 데이터를 덮어 씌운다.
    public void add(int index, Object data){
        for(int i = size-1; i>=index;  i--){
            arrayListData[i+1] = arrayListData[i];
        }
        arrayListData[index] = data;
        size++;
    }
    public void addLast(Object data){
        arrayListData[size] = data;
        size++;
    }

    // 매개변수 index 보다 1 큰 수의 인덱스부터 size 보다 1작은(인덱스는 0부터 시작하기 때문) 인덱스까지 반복하여 노드를 이동한다.
    // 매개변수 index를 삭제 후 모든 노드들이 이동 해야 하기 때문에 삭제 속도가 느리다.
    public Object remove(int index) {
        Object removed = arrayListData[index];
        for(int i = index+1; i <=size-1; i++){
            arrayListData[i-1] = arrayListData[i];
        }
        size--;
        arrayListData[size] = null;

        return removed;
    }

    // List의 첫 번째 데이터를 삭제한다.
    public Object removeFirst(){
        return remove(0);
    }

    // List의 마지막 데이터를 삭제한다.
    public Object removeLast(){
        return remove(size-1);
    }

    // 객체를 문자열로 출력하기 위해 출력 메서드에 객체를 넣어 실행 할 때 java는 Object 클래스의 toString() 메서드를 실행하게끔 약속이 되어있다.
    // 테스트 데이터를 쉽게 출력하기위해 toString() 메소드를 오버라이딩하여 재정의하여 arrayList 데이터를 보기 쉽게 출력 한다.
    public String toString(){
        StringBuilder str = new StringBuilder("[");
        for(int i=0; i < size; i++){
            str.append(arrayListData[i]);
            if(i < size-1) str.append(", ");
        }
        return str+"]";
    }

    // ArrayList의 장점은 내부적으로 배열을 사용하기 때문에 특정한 위치에 접근할 때 속도가 매우 빠르다.
    // 배열은 메모리-RAM(RANDOM ACCESS MEMORY)의 특징으로 어느 위치의 데이터를 가져오더라도 아주 빠르게 데이터에 접근이 가능하다.
    public Object get(int index) {
        return arrayListData[index];
    }

    // 배열에 담긴 데이터의 크기를 가져온다.
    public int size() {
        return size;
    }

    // List를 탐색하여 데이터의 index 를 가져온다.
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if(o.equals(arrayListData[i])){
                return i;
            }
        }
        return -1;
    }

    // ListIterator 클래스 객체 생성자
    public ListIterator listIterator() {
        return new ListIterator();
    }

    // List에 저장된 데이터를 반복하여 접근할 때 사용하는 메소드를 모아 놓은 인터페이스 이다.
    class ListIterator{
        private int nextIndex = 0;

        // next()를 실행하기전 다음 인덱스에 데이터가 있는지 체크하여 true/false를 리턴한다.
        // nextIndex는 next()가 실행될 떄마다 1씩 증가하고 size의 크기와 같거나 커지면 그 인덱스는 null이라는 뜻이므로 false가 리턴되게끔 한다.
        public boolean hasNext(){
            // nextIndex가 엘리먼트의 숫자보다 적다면 next를 이용해서 탐색할 엘리먼트가 존재하는 것이기 때문에 true를 리턴합니다.
            return nextIndex < size();
        }

        // index를 증가하여 다음 리스트로 이동
        public Object next(){
            return arrayListData[nextIndex++];
        }

        // 해당 리스트를 역방향으로 순회할 때 previous() 실행하기 전 다음 요소를 가지고 있으면 true를 반환하고, 더 이상 다음 요소를 가지고 있지 않으면 false를 반환함.
        public boolean hasPrevious(){
            // nextIndex가 0보다 크다면 이전 엘리먼트가 존재한다는 의미입니다.
            return nextIndex > 0;
        }

        // index를 감소시키며 다음 리스트로 이동
        public Object previous(){
            return arrayListData[--nextIndex];
        }

        // 선택한 요소 다음에 새로운 데이터를 삽입 한다.
        public void add(Object element) {
            ArrayList.this.add(nextIndex++, element);
        }

        public void remove() {
            ArrayList.this.remove(nextIndex-1);
            nextIndex--;
        }
    }
}
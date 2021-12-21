package hello.core.datastructure;

public class ArrayListTest {
    private int size = 0;
    private Object[] arrayListData = new Object[100]; // Java의 ArrayList 클래스는 리스트 배열의 크기를 가변적으로 늘리도록 코딩 되어있다.

    public void addFirst(Object data){
        add(0, data);
    }
    /*  리스트의 중간에 데이터를 삽입하는 경우 데어탁 삽입된 배열의 끝에서 부터 삽입할 인덱스 자리까지 한 자리씩 데이터를 옮겨 담고
        선택한 인덱스에 새로운 데이터를 덮어 씌운다.
     */
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

    public Object removeFirst(){
        return remove(0);
    }

    public Object removeLast(){
        return remove(size-1);
    }

    /* 객체를 문자열로 출력하기 위해 출력 메서드에 객체를 넣어 실행 할 때 java는 Object 클래스의 toString() 메서드를 실행하게끔 약속이 되어있다.
       테스트 데이터를 쉽게 출력하기위해 toString() 메소드를 오버라이딩하여 재정의하여 arrayList 데이터를 보기 쉽게 출력 한다.
     */
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

    public int size() {
        return size;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if(o.equals(arrayListData[i])){
                return i;
            }
        }
        return -1;
    }

    public ListIterator listIterator() {
        return new ListIterator();
    }

    class ListIterator{
        private int nextIndex = 0;

        // next()를 실행하기전 다음 인덱스에 데이터가 있는지 체크하여 true/false를 리턴한다.
        // nextIndex는 next()가 실행될 떄마다 1씩 증가하고 size의 크기와 같거나 커지면 그 인덱스는 null이라는 뜻이므로 false가 리턴되게끔 한다.
        public boolean hasNext(){
            return nextIndex < size();
        }

        public Object next(){
            return arrayListData[nextIndex++];
        }

        public boolean hasPrevious(){
            return nextIndex > 0;
        }
        public Object previous(){
            return arrayListData[--nextIndex];
        }

        public void add(Object element) {
            ArrayListTest.this.add(nextIndex++, element);
        }

        public void remove() {
            ArrayListTest.this.remove(nextIndex-1);
            nextIndex--;
        }
    }
}

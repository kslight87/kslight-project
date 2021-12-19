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


}

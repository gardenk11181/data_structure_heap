public class TestHeap {
    public static void main(String[] args) {
        MyHeap<Integer> myHeap = new MyHeap<>();
        myHeap.heapInsert(3);
        myHeap.heapInsert(1);
        myHeap.printAll();
//        System.out.println(myHeap.heapDelete());
    }
}

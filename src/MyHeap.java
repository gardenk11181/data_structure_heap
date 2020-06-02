import java.util.ArrayList;

public class MyHeap<T extends Comparable<T>> {
    T[] array;
    T[] sorted;
    final int MAX_SIZE=50;
    int size;

    @SuppressWarnings("unchecked")
    public MyHeap() {
        array = (T[]) new Comparable[MAX_SIZE];
        sorted = (T[]) new Comparable[MAX_SIZE];
    }

    public void heapSort() {
        heapSort(size);
    }

    public void heapSort(int last) {
        for(int i=(last/2); i>=1; i--) {
            percolateDown(i,last);
        }

        for(int size = last; size>=2 ; size--) {
            T tmp = sorted[0];
            sorted[0] = sorted[size-1];
            sorted[size-1] = tmp;
            percolateDown(1,size-1);
        }
    }


    public void printAll() {
        for(int i=0; i<size; i++) {
            sorted[i] = array[i];
        }
        heapSort();
        for(int i=0; i<size; i++) {
            System.out.print(sorted[i]+", ");
        }
    }

    public void heapInsert(T item) {
        array[size++] = item;
        percolateUp(size);
    }

    public void percolateUp(int index) {
        int parent = index/2;
        if(parent>=1 && array[index-1].compareTo(array[parent-1])>0) {
            T tmp = array[index-1];
            array[index-1] = array[parent-1];
            array[parent-1] = tmp;
            percolateUp(parent);
        }
    }

    public T heapDelete() {
        if(size!=0) {
            T max = array[0];
            array[0] = array[size-1];
            size--;
            percolateDown(1,size);
            return max;
        } else {
            System.err.println("heap is empty");
            return null;
        }
    }

    public void percolateDown(int parent, int size) {
        int child= 2*parent;
        int rightChild = 2*parent+1;
        if(child<=size) {
            if(rightChild<=size && array[child-1].compareTo(array[rightChild-1])<0) {
                child = rightChild;
            }
            if(array[parent-1].compareTo(array[child-1])<0) {
                T tmp = array[parent-1];
                array[parent-1] = array[child-1];
                array[child-1] = tmp;
                percolateDown(child,size);
            }
        }
    }


}

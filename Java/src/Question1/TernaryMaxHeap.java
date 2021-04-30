package Question1;

import java.util.Arrays;

public class TernaryMaxHeap {
    // Declare all private data
    private int capacity = 10;
    private int size = 0;
    private int index;
    private int[] items = new int[capacity];

    //Constructors
    public TernaryMaxHeap(){}
    public TernaryMaxHeap(TernaryMaxHeap t){
        items = t.items;
        capacity = t.capacity;
        size = t.size;
        index = t.index;
    }

    // Setters and Getter Methods taken from Hackerrank's video explanation:
    // https://www.youtube.com/watch?v=t0Cq6tVNRBA&ab_channel=HackerRank

    // Index Getters
    private int getLeftChildIndex(int parentIndex){ return 3 * parentIndex + 1; }
    private int getMiddleChildIndex(int parentIndex){ return 3 * parentIndex + 2; }
    private int getRightChildIndex(int parentIndex){ return 3 * parentIndex + 3; }
    private int getParentIndex(int childIndex){ return (childIndex - 1) / 3; }

    // Has nodes
    private boolean hasLeftChild(int index){ return getLeftChildIndex(index) < size; }
    private boolean hasMiddleChild(int index){ return getMiddleChildIndex(index) < size; }
    private boolean hasRightChild(int index){ return getRightChildIndex(index) < size; }
    private boolean hasParent(int index){ return getParentIndex(index) >= 0; }

    // Value Getters
    private int getLeftChild(int index){ return items[getLeftChildIndex(index)]; }
    private int getMiddleChild(int index){ return items[getMiddleChildIndex(index)]; }
    private int getRightChild(int index){ return items[getRightChildIndex(index)]; }
    private int getParent(int index) { return items[getParentIndex(index)]; }

    public int getSize() {
        return size;
    }

    private void ensureExtraCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, (capacity * 3));
            capacity = (capacity * 3);
        }
    }

    private void swap(int a, int b){
        int temp = items[a];
        items[a] = items[b];
        items[b] = temp;
    }

    private void perlocateUp(){
        int index = size - 1;
        while(hasParent(index) && getParent(index) < items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void perlocateDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int newIndex = getLeftChildIndex(index);
            // Find the largest between left, middle, and right children
            if(hasMiddleChild(index) && hasRightChild(index)){
                if(getMiddleChild(index) > getRightChild(index))
                    newIndex = getMiddleChildIndex(index);
            }
            // Find the largest between left and middle children
            else if ( hasMiddleChild(index) && !hasRightChild(index) ){
                if( getMiddleChild(index) > (getLeftChild(index)))
                    newIndex = getMiddleChildIndex(index);
            }

            if(items[index] > items[newIndex])
                break;

            else
                swap(index, newIndex);

            index = newIndex;
        }
    }


    private int binarySearch(int table[], int start, int finish, int searchKey){
        int mid = (start+finish/2);
        if(finish-start+1 > 0){
            if(table[mid] == searchKey){
                return mid;
            }
            else{
                if(searchKey < table[mid])
                    return binarySearch(table, start, mid-1, searchKey);
                else
                    return binarySearch(table, mid+1, finish, searchKey);
            }
        }
        else
            return -1;
    }

    // Class Interface:
    public int poll(){
        if(size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        perlocateDown();
        return item;
    }

    public void clear(){
        items = null;
    }

    public boolean contains(int item){
        if(binarySearch(items, 0, items.length - 1, item) == -1)
            return false;
        else
            return true;
    }

    public int peek(){
        return items[0];
    }

    public int[] toArray(){
        int[] temp = new int[items.length];
        for(int i = 0; i < temp.length; i++){
            temp[i] = items[i];
        }

        return temp;
    }

    public void add(int item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        perlocateUp();
    }

    public void iterator_initialize(){
        index = 0;
    }
    public boolean iterator_hasNext(){
        return index <= size - 1;
    }
    public int iterator_getNext(){
        return items[index++];
    }



}

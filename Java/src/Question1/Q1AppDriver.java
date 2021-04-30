package Question1;

public class Q1AppDriver {

    public static void main(String[] args) {
        TernaryMaxHeap maxHeap = new TernaryMaxHeap();

        System.out.println("This is a program to test the methods of a TernaryMaxHeap.");
        maxHeap.add(12);
        maxHeap.add(14);
        maxHeap.add(4);
        maxHeap.add(18);
        maxHeap.add(21);
        maxHeap.add(6);

        maxHeap.iterator_initialize();
        while(maxHeap.iterator_hasNext()){
            int next = maxHeap.iterator_getNext();
            System.out.print(next + " ");
        }
    }


}

package Question1;

public class Q1AppDriver {

    public static void main(String[] args) {
        TernaryMaxHeap maxHeap = new TernaryMaxHeap();

        System.out.println("This is a program to test the methods of a TernaryMaxHeap.");

        System.out.println("\nTesting it's add() method: ");
        maxHeap.add(12);
        maxHeap.add(15);
        maxHeap.add(13);
        maxHeap.add(4);
        maxHeap.add(8);
        maxHeap.add(9);

        maxHeap.iterator_initialize();
        while(maxHeap.iterator_hasNext()){
            int next = maxHeap.iterator_getNext();
            System.out.print(next + " ");
        }

        System.out.println("\n\nTesting it's peek() method: ");
        System.out.println(maxHeap.peek());

        System.out.println("\nTesting it's poll() method: " );
        System.out.println("Max value in the heap: " + maxHeap.poll());
        System.out.println("Next max value in the heap: " + maxHeap.poll());
        System.out.println("\nTesting it's peek() method again: ");
        System.out.println(maxHeap.peek());

        System.out.println("\nTesting it's contains method: ");
        System.out.println("Contains 8? " + maxHeap.contains(8));
        System.out.println("Contains 53? " + maxHeap.contains((53)));

        System.out.println("\nFinally print out the heap: ");
        maxHeap.iterator_initialize();
        while(maxHeap.iterator_hasNext()){
            int next = maxHeap.iterator_getNext();
            System.out.print(next + " ");
        }


    }


}

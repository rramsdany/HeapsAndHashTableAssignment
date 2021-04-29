package Question3;

import java.io.*;
import java.util.*;

public class AppDriver {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Grab standard input from file:
        // To run, update the location of the file with the text
        File file = new File("C:\\Users\\Daniel\\HeapsAndHashTableAssignment\\input.txt");
        Scanner scanner = new Scanner(file);
        int size = Integer.parseInt(scanner.nextLine());

        // Declare variables and data structures:
        HashMap<String, String[]> food = new HashMap<String, String[]>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        // Build 2 Hashtables, one is a temporary one used to create combinations for finding intersections
        buildHashtable(scanner, food);
        HashMap<String, String[]> tempFood = new HashMap<>(food);

        // Create combinations of entries to find intersections. Place each number of intersections
        // into a max heap. The highest number of intersections plus 1 will equal # of max guesses
        for(Map.Entry<String, String[]> firstEntry : food.entrySet()){
            for(Map.Entry<String, String[]> secondEntry : tempFood.entrySet()){
                if(firstEntry.getKey() != secondEntry.getKey()){
                    maxHeap.add(findIntersections(firstEntry.getValue(), secondEntry.getValue()));
                }
            }
            tempFood.remove(firstEntry.getKey());
        }

        System.out.println("The maximum amount of guesses for this input is : " + (maxHeap.peek()+1) );
    }

    public static void buildHashtable(Scanner scanner, HashMap<String, String[]> table){
        while(scanner.hasNext()){
            // String for the line
            // Create an array of Strings
            // Array of Strings for the characteristics *final array*
            String str = scanner.nextLine();
            String[] temp = str.split(" ");
            String[] characteristics = new String[Integer.parseInt(temp[1])];
            for(int i = 0; i < characteristics.length; i++){
                characteristics[i] = temp[i+2];
            }
            table.put(temp[0], characteristics);

        }
    }

    // Source code for this module came from this video:
    // https://www.youtube.com/watch?v=R-T2XF0Cc2w&ab_channel=ProgrammingTutorials
    public static int findIntersections(String[] arr1, String[] arr2){
        Qsort(arr1, 0, arr1.length - 1);
        Qsort(arr2, 0, arr2.length - 1);

        int i = 0;
        int j = 0;
        int count = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i].compareTo(arr2[j]) == 0){
                i++;
                j++;
                count++;
            } else if(arr1[i].compareTo(arr2[j]) > 0){
                j++;
            } else{
                i++;
            }
        }

        return count;
    }

    public static void Qsort(String[] table, int start, int finish){
        int left = start;
        int right = finish;
        String pivot = table[(start+finish)/2];

        while(left < right){
            while((table[left].compareTo(pivot)) < 0) left++;
            while((table[right].compareTo(pivot)) > 0) right--;
            if(left <= right){
                String temp = table[left];
                table[left] = table[right];
                table[right] = temp;
                left++;
                right--;
            }
        }
        if(start < right) Qsort(table, start, right);
        if(left < finish) Qsort(table, left, finish);

    }




}

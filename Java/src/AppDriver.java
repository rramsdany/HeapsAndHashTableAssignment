import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AppDriver {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\rrams\\IdeaProjects\\HeapsAndHashTableAssignment\\input.txt");
        Scanner scanner = new Scanner(file);
        HashMap<String, String[]> food = new HashMap<String, String[]>();
        int size = Integer.parseInt(scanner.nextLine());

        buildHashtable(scanner, food);

        System.out.println("Testing the is Present method: ");
        System.out.println(isPresent(food, "pizza", "awesome"));



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

    public static boolean isPresent(HashMap<String, String[]> table, String food, String choice){
        String[] options = table.get(food);
        if(Arrays.asList(options).contains(choice)){
            return true;
        }
        else
            return false;

    }

}

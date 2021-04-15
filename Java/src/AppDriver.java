import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AppDriver {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Daniel\\HeapsAndHashTableAssignment\\input.txt");
        Scanner scanner = new Scanner(file);
        HashMap<String, String[]> food = new HashMap<String, String[]>();
        int size = Integer.parseInt(scanner.nextLine());

        buildHashtable(scanner, food);
        System.out.println(maxGuess(food, size));





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

    public static int maxGuess(HashMap<String, String[]> table, int size){
        int count = 0;
        ArrayList<String> viableSet = new ArrayList<String>();
        viableSet.add("cookies");
        viableSet.add("pizza");
        viableSet.add("chips");
        viableSet.add("ramen");

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        Iterator<Map.Entry<String, String[]>> iterator = table.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String[]> entry = iterator.next();
            String food = iterator.next().getKey();
            String[] trait = entry.getValue();
            for(int i = 0; i < trait.length; i++){
                if(!isPresent(table, food, trait[i])){
                    viableSet.remove(food);
                    if(viableSet.size() == 1) break;
                }
                else{
                    // do stuff
                }
            }
        }

        return count;








    }

}

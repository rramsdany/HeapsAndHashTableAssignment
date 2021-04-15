public class HashTable {
    private String[] buckets;
    private int index = 0;



    public HashTable(){ }

    private int hashFunction(int value){
        return (value % 10);
    }
}

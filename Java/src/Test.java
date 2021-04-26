public class Test {
    public static void main(String[] args) {
        String[] pizza = new String[]{"cheesy", "salty", "soft", "awesome", "saucy"};
        String[] chips = new String[]{"salty", "awesome"};
        Qsort(pizza, 0, pizza.length - 1);
        Qsort(chips, 0, chips.length - 1);

        int i = 0;
        int j = 0;
        int count = 0;
        while(i < pizza.length && j < chips.length){
            if(pizza[i].compareTo(chips[j]) == 0){
                i++;
                j++;
                count++;
            } else if(pizza[i].compareTo(chips[j]) > 0){
                j++;
            } else{
                i++;
            }
        }

        System.out.println(count + 1);


    }

    public static void Qsort(String table[],int start,int finish)
    {
        int left=start;
        int right=finish;
        String pivot = table[(start+finish)/2];

        while (left < right) // pass loop
        {
            while (table[left].compareTo(pivot) < 0) left++;
            while (table[right].compareTo(pivot) > 0 ) right--;
            if (left <= right)
            {
                String temp = table[left];
                table[left]= table[right];
                table[right] = temp;
                left++;
                right--;
            }
        }
        if (start < right) Qsort(table,start,right);
        if (left < finish) Qsort(table,left,finish);
    }


}
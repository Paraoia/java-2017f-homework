

public class SortNumber {
        public static void main(String[] args) {
            //array of 10 numbers
            int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
            System.out.println("before sorted:\n");
            for (int i=0;i<numbers.length;i++)
                System.out.print(numbers[i]+ " ");
            for(int i=0;i<numbers.length;i++)
                for(int j=numbers.length-1;j>i;j--)
                    if(numbers[j]<numbers[j-1]) {
                        int temp=numbers[j];
                        numbers[j]=numbers[j-1];
                        numbers[j-1]=temp;
                    }
            System.out.println("\nafter sorted:\n");
            for (int i=0;i<numbers.length;i++)
                System.out.print(numbers[i]+ " ");
        }
}

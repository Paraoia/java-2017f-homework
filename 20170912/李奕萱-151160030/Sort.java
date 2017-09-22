/*
bubble sort
*/
public class Sort {
        public static void main(String[] args) {
                int i,j;
                int numbers[] = new int[]{32,43,53,54,33,65,63,98,44,23};
                //assign first element of an array to largest and smallest
                //int smallest = numbers[0];
                //int largetst = numbers[0];
                for(i=0; i< numbers.length; i++)
                {
                        for(j=0;j<numbers.length-i-1;j++){
                                if(numbers[j]>numbers[j+1]){
                                        int temp=numbers[j];
                                        numbers[j]=numbers[j+1];
                                        numbers[j+1]=temp;
                                }
                        }
                }
                for(i=0;i<numbers.length;i++){
                        System.out.println(numbers[i]);
                }
                //System.out.println("Largest Number is : " + largetst);
                //System.out.println("Smallest Number is : " + smallest);
        }
}


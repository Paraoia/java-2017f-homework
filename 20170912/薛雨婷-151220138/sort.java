public class sort {
        public static void main(String[] args) {
                //array of 10 numbers
                int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
                //assign first element of an array to largest and smallest
                //int smallest = numbers[0];
                //int largetst = numbers[0];
                for(int j=0; j< numbers.length-1; j++)
                {
                    for(int i=0;i<numbers.length-1-j;i++){
                        if(numbers[i] > numbers[i+1]){
                            int temp=numbers[i];
                            numbers[i]=numbers[i+1];
                            numbers[i+1]=temp;
                        }
                    }
                }
                for(int n=0; n< numbers.length; n++)
                    System.out.print(numbers[n]+" ");
                System.out.println();
        }
}

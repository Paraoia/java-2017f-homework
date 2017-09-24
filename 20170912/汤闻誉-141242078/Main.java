public class Main {
    public static void printArray(int [] myArray) {
        for (int i = 0; i < myArray.length - 1; i++) System.out.print(myArray[i] + " ");
        System.out.println(myArray[myArray.length - 1]);
    }

    public static int[] selectSort(int [] myArray){
        for(int i=0;i<myArray.length-1;i++){
            int smallest=myArray[i];
            int smallestIndex=i;
            for(int j=i+1;j< myArray.length;j++) {
                if(myArray[j]<smallest) {
                    smallest = myArray[j];
                    smallestIndex = j;
                }
            }
            if(i!=smallestIndex){
                myArray[smallestIndex]=myArray[i];
                myArray[i]=smallest;
            }
        }
        return myArray;
    }
    public static void main(String[] args) {
       int myArray[] = new int[]{2,8,5,7,1,4,3,6,9};
        printArray(selectSort(myArray));
    }

}

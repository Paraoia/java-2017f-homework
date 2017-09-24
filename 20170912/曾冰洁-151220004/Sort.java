public class Sort {
    // bubble sort
    public static void main(String[] args) {
        int numArray[] = new int[]{17,35,31,11,12,4,9,17,99,67};
        for(int outIndex=0; outIndex<numArray.length-1;outIndex++){
            boolean flag = false;
            for (int inIndex = 0;inIndex<numArray.length-1-outIndex;inIndex++){
                if (numArray[inIndex]>numArray[inIndex+1]){
                    flag = true;
                    int temp = numArray[inIndex];
                    numArray[inIndex]=numArray[inIndex+1];
                    numArray[inIndex+1]=temp;
                }
            }
            if (flag==false){
                break;
            }
        }
        System.out.println(java.util.Arrays.toString(numArray));
    }
}
public class Sort {
    public static void main(String[] args){
        int[] A={32,43,53,54,32,65,63,98,43,23};
        int len = 10;
        System.out.println("Sort the array in an ascending order:");
        int i,j;
        for(i=0; i<len-1; i++)
        {
            for(j=0; j<len-1-i;j++)
            {
                if(A[j]>A[j+1])
                {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        for(i=0; i<10; i++)
            System.out.print(A[i]+" ");
    }
}

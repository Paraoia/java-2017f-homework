public class sort {
    public static void main(String[] args){
        int array[]=new int[]{1,2,3,4,5,6};
        for(int i=0;i<6;i++)
            for(int j=0;j<6-i-1;j++){
                if(array[j]<array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        for(int i=0;i<6;i++)
            System.out.println(array[i]);
    }
}

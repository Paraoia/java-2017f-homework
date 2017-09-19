public class Main {

    public static void main(String[] args) {
        int[] array=new int[]{3,2,5,77,45,24,46,64};
        for(int i=0;i<array.length;i++)
        {for(int j=0;j<array.length-i-1;j++)
                if(array[j]>array[j+1])
                {int temp=array[j];
                array[j]=array[j+1];
                array[j+1]=temp;}}
                for(int k=0;k<array.length;k++)
                 System.out.println(array[k]);
    }
}

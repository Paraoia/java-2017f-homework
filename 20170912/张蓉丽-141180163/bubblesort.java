public class bubblesort {
    public static int[] array={9,8,7,6,5,4,3,2,1};
    public static void main(String args[]){
        int temp;
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++)
            {
                if(array[j]<array[i])
                {
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
      for(int i=0;i<array.length;i++)
      {
          System.out.println(array[i]+"");
      }
    }

        }

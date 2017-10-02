public class Sort
{
    public static void sort()
{
   int [] arrays=new int[]{
           12,14,10,21,44,89,102,5,7,1000,28,36
   };
   int k=arrays.length;
   for(int i=0;i<k;i++)
   {
       int min=i;
       for(int j=i+1;j<k;j++)
       {
           if(arrays[j]<arrays[min])
               min=j;
       }
       int temp=arrays[min];
       arrays[min]=arrays[i];
       arrays[i]=temp;
   }
   for(int i=0;i<k;i++)
       System.out.print(arrays[i]+' ');
}
    public static void main(String[] args)
    {
        sort();
    }
}

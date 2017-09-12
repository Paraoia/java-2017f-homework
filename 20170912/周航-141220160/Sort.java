public class Sort {
    public static void main(String[] args){
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        sort(numbers,0,numbers.length-1);
        for(int i=0;i<numbers.length;i++)
            System.out.println(numbers[i]);
    }

    public static int partition(int []array,int low,int high){
        int key=array[low];
        while(low<high){
            while(array[high]>=key&&high>low){
                high--;
            }
            array[low]=array[high];
            while(array[low]<=key&&high>low){
                low++;
            }
            array[high]=array[low];
        }
        array[high]=key;
        return high;
    }
    
    public static void sort(int[] array,int low ,int high){
        if(low>=high){
            return ;
        }
        int index=partition(array,low,high);
        sort(array,low,index-1);
        sort(array,index+1,high); 
    }

}

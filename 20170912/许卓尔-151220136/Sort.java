public class Sort {
    private static int getPartition(int []numbers,int l,int r){
        int key = numbers[l];
        while(l<r){
            while(l<r && numbers[r]>=key)
                --r;
            numbers[l] = numbers[r];
            while(l<r && numbers[l]<=key)
                ++l;
            numbers[r]=numbers[l];
        }
        numbers[l]=key;
        return l;
    }
    public static void quickSort(int[] numbers,int l,int r){
        if(l<r) {
            int partition=getPartition(numbers,l,r);
            quickSort(numbers,l,partition-1);
            quickSort(numbers,partition+1,r);
        }
    }
    public static void main(String[] args){
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        quickSort(numbers,0,numbers.length-1);
        for(int i=0;i<numbers.length;i++)
            System.out.println(numbers[i]);
    }
}

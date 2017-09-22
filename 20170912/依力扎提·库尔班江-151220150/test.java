public class test {
    public static void main(String [] args){
        int arr[]= new int[]{5,6,10,2,1,7,9};
        for(int i_elzat=0;i_elzat<arr.length-1;i_elzat++) {             //为表明代码为自己写的，变量后接自己名字作区分
            for(int j_elzat=0;j_elzat<arr.length-1-i_elzat;j_elzat++){
                if(arr[j_elzat]>arr[j_elzat+1]){
                    int temp=arr[j_elzat+1];
                    arr[j_elzat+1]=arr[j_elzat];
                    arr[j_elzat]=temp;
                }
            }
        }
        for(int i_elzat=0;i_elzat<arr.length;i_elzat++)
            System.out.println(arr[i_elzat]);
    }
}

public class Sort {
    public static void main(String[] args){
        Brothers hulu = new Brothers();

        hulu.random_posi();
        hulu.All_sounding(0);
        System.out.println("冒泡排序：");
        hulu.BubbleSort();
        hulu.All_sounding(0);

        hulu.random_posi();
        hulu.All_sounding(0);
        System.out.println("二分法排序：");
        hulu.BinarySort(hulu.bros, 0, 6);
        hulu.All_sounding(1);
    }
}

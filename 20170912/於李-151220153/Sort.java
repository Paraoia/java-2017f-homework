/**
 * Created by 151220153-於李 on 2017/9/12.
 */
public class Sort {
    public static void mergeSort(int []num) {
        int len = num.length;
        int gap, start;
        int []res = new int[len];
        for (gap = 1;gap < len * 2; gap += gap) {
            for (start = 0;start < len; start += gap * 2) {
                int mid = start + gap > len? len : start + gap;
                int high = start + 2 * gap > len? len : start + 2*gap;
                int beg = start;
                int start1 = start;
                int start2 = mid;
                while (start1 < mid && start2 < high)
                    res[beg++] = num[start1] < num[start2]? num[start1++] : num[start2++];
                while (start1 < mid)
                    res[beg++] = num[start1++];
                while (start2 < high)
                    res[beg++] = num[start2++];
            }
            int []temp = num;
            num = res;
            res = temp;
        }
    }

    public static void main(String []args) {
        int []num = new int[]{21, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70, 55, 94, 87, 1, 4};
        mergeSort(num);
        for (int i: num) {
            System.out.println(i);
        }
    }
}

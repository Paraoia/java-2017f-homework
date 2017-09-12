package wangyuxin;

import java.util.*;

public class SortTest0
{
    public static void main(String[] args)
    {
        SortTest0 st0 = new SortTest0();
        List<Integer> nums = st0.loadNumbers(args);
        nums.sort(Comparator.naturalOrder());
        System.out.println(nums);
    }

    List<Integer> loadNumbers(String[] args)
    {
        List<Integer> nums = new ArrayList<>();
        Arrays.asList(args).forEach((String str) -> nums.add(new Integer(str)));
        if (nums.isEmpty()) return Arrays.asList(new Integer[]{13, 28, 41, 9, 12, 50, 60});
        else return nums;
    }
}
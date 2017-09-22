package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //define an array of 8 numbers
        int nums[] = new int[]{49, 38, 65, 97, 76, 13, 27, 49};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void quickSort(int[] nums){
        if(nums.length > 0){
            quick(nums, 0, nums.length - 1);
        }
        return;
    }
    public static void quick(int[] nums, int low, int high){
        //递归形式的分治排序算法
        if(low < high){
            int middle = getMiddle(nums, low, high);
            quick(nums,low,middle - 1);
            quick(nums,middle + 1, high);
        }
        return;
    }
    public static int getMiddle(int[] nums, int low, int high){
        int temp = nums[low];
        while(low < high) {
            while (low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
        }
}

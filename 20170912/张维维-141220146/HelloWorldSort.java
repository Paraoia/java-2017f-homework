package com.youseek.demo;

public class HelloWorldSort {
    public static void main(String[] args) {
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        for(int i=0; i<10; i++){
            int smallest_index = i;
            for(int j=i; j<10; j++)
                if(numbers[j]<numbers[smallest_index])
                    smallest_index=j;
            int temp = numbers[i];
            numbers[i]=numbers[smallest_index];
            numbers[smallest_index]=temp;
        }
        for(int i=0; i<10; i++)
            System.out.println(numbers[i]);
    }
}
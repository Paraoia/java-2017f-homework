/*************************************************************************
	> File Name: ArraySort.java
	> Author: Leuckart
	> Mail: XXXX6372@qq.com 
	> Created Time: Tue 12 Sep 2017 05:23:13 PM CST
 ************************************************************************/

import java.util.*;
import java.io.*;

public class ArraySort
{
	public static int[] array={9,8,7,6,5,4,3,2,1,0,10,11,12,13,14,19,18,17,16,15};
	
	public static void main(String args[])
	{
		for(int i=0;i<array.length;i++)
		{
			for(int j=1;j<array.length-i;j++)
			{
				if(array[j]<array[j-1])
				{
					int temp=array[j];
					array[j]=array[j-1];
					array[j-1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
}

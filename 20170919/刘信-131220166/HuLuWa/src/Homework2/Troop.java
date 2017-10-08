package Homework2;

import java.util.*;

public class Troop {
	static Huluwa[] troop;
	
	Troop(){
		troop = new Huluwa[7];
		troop[0] = new Huluwa(0, "老大", "赤");
		troop[1] = new Huluwa(1, "老二", "橙");
		troop[2] = new Huluwa(2, "老三", "黄");
		troop[3] = new Huluwa(3, "老四", "绿");
		troop[4] = new Huluwa(4, "老五", "青");
		troop[5] = new Huluwa(5, "老六", "蓝");
		troop[6] = new Huluwa(6, "老七", "紫");
	}
	
	public void Disorganize(){
		Random r = new Random();
		int a,b,i;
		
		for(i=-10;i<r.nextInt(100);i++){
			a = r.nextInt(7);
			b = r.nextInt(7);
			if(a!=b){
				SwapInit(a,b);
			}
		}
		for(i=0;i<7;i++){
			System.out.println("随机站队后:" + troop[i].name);
		}
	}
	
	public void BubbleSort(){
		int i,j;
		for(i=0;i<7;i++){
			for(j=6;j>i;j--){
				if(troop[j].number<troop[i].number){
					Swap(i,j);
				}
			}
		}
	}
	
	public static int BinarySearch(int start, int end, int k){
		while(start<=end)
		{
			int middle = (start+end)/2;
			int middleData = troop[middle].number;
			if(middleData > k)
			{
				end = middle-1;
			}
			else start = middle+1;
		}
		return start;
	}
	
	public void BinarySort(){
		int i,j;
		int insertIndex;
		Huluwa temp;
		
		for(i=1;i<7;i++){
			if(troop[i].number<troop[i-1].number){
				/*不是面向对象
				temp = troop[i];
				insertIndex = BinarySearch(0,i,troop[i].number);
				
				for(j=i-1;j>=insertIndex;j--){
					troop[j].SayChange(j, j+1);
					troop[j+1] = troop[j];
				}
				temp.SayChange(i, insertIndex);
				troop[insertIndex] = temp;
				*/
				
				insertIndex = BinarySearch(0,i,troop[i].number);
				
				for(j=i;j>insertIndex;j--){
					Swap(j,j-1);
				}
			}
		}
	}
	
	//for Disorganize
	public static void SwapInit(int a, int b){
		Huluwa temp;
		
		temp = troop[a];
		troop[a] = troop[b];
		troop[b] = temp;
	}
	
	//for Organize
	public static void Swap(int a, int b){
		Huluwa temp;
		
		troop[a].SayChange(a, b);
		troop[b].SayChange(b, a);
		
		temp = troop[a];
		troop[a] = troop[b];
		troop[b] = temp;
	}
	
	public void SayColor(){
		int i;
		for(i=0;i<7;i++){
			troop[i].SayColor();
		}
	}
	
	public void SayName(){
		int i;
		for(i=0;i<7;i++){
			troop[i].SayName();
		}
	}
}
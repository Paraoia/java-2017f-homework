/**************************************************
	> File Name:   GourdBoys.java
	> Author:      Leuckart
	> Time:        2017-09-22  21:54
**************************************************/

import java.util.*;

public class GourdBoys
{
	public enum Rank
	{
		ONE("老大","红色"),TWO("老二","橙色"),THREE("老三","黄色"),FOUR("老四","绿色"),FIVE("老五","青色"),SIX("老六","蓝色"),SEVEN("老七","紫色");
		private String name,color;
		private Rank(String name,String color) { this.name=name; this.color=color; }

		public String getName() { return name; }
		public String getColor() { return color; }
		public String toString() { return this.name+"("+this.color+")"; }
	}
	public static Rank[] Brothers={Rank.ONE,Rank.TWO,Rank.THREE,Rank.FOUR,Rank.FIVE,Rank.SIX,Rank.SEVEN};

	public void shuffle()
	{
		List<Rank> bro=Arrays.asList(Brothers);
		Collections.shuffle(bro);
		Brothers=(Rank[])bro.toArray(new Rank[bro.size()]);
	}

	public String toString()
	{
		return Arrays.asList(Brothers).toString();
	}

	private void Swap(int m,int n)
	{
		if(m==n) { return; }
		System.out.println(Brothers[m].getName()+":"+(m+1)+"->"+(n+1)+"  ||  "+Brothers[n].getName()+":"+(n+1)+"->"+(m+1));
		Rank temp=Brothers[m];
		Brothers[m]=Brothers[n];
		Brothers[n]=temp;
	}

	public void BubbleSort()
	{
		int len=Brothers.length;
		for(int i=0;i<len-1;i++)
		{
			for(int j=0;j<len-1-i;j++)
			{
				if(Brothers[j+1].ordinal()<Brothers[j].ordinal()) { Swap(j,j+1); }
			}
		}
	}

	public void QuickSort()
	{
		Qsort(0,Brothers.length-1);
	}

	private void Qsort(int left,int right)
	{
		if(left>=right) { return; }
		if(right-left==1&&Brothers[left].ordinal()>Brothers[right].ordinal()) { Swap(left,right); }

		int i=left-1,j=right;
		Rank median=Brothers[right];

		while(true)
		{
			while(i<Brothers.length-1&&Brothers[++i].ordinal()<median.ordinal());
			while(j>0&&Brothers[--j].ordinal()>median.ordinal());
			
			if(j>i) { Swap(i,j); }
			else { break;}
		}
		Swap(i,right);
		Qsort(left,i-1);
		Qsort(i+1,right);
	}

	public void CountOff(String s)
	{
		Arrays.asList(Brothers).forEach(r->{System.out.print("<"+(s=="name"? r.getName():(s=="color"? r.getColor():"WrongParameter"))+">  ");});
		System.out.println();
	}

	public static void main(String args[])
	{
		GourdBoys gdboys=new GourdBoys();
		System.out.println("初始状态:\n"+gdboys+"\n");

		gdboys.shuffle();
		System.out.println("第一次随机站队:\n"+gdboys+"\n交换动作如下:");
		gdboys.BubbleSort();
		System.out.println("排序结果:");
		gdboys.CountOff("name");

		gdboys.shuffle();
		System.out.println("\n第二次随机站队:\n"+gdboys+"\n交换动作如下:");
		gdboys.QuickSort();
		gdboys.CountOff("color");
	}
}

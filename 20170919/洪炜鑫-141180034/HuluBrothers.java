/**************************************************
	> File Name:  HuluBrothers.java
	> Author:     Leuckart
	> Time:       2017-10-05 22:18
**************************************************/


import java.util.*;

/* PUBLIC METHODS
*** HuluBrothers.getInstance();
*** HuluBrothers.toString();
*** HuluBrothers.shuffle();
*** HuluBrothers.bubbleSort();
*** HuluBrothers.quickSort();
*** HuluBrothers.countOff(String s);
*/

public class HuluBrothers
{
	private static Huluwa[] Brothers={new Huluwa("ONE"),new Huluwa("TWO"),new Huluwa("THREE"),new Huluwa("FOUR"),new Huluwa("FIVE"),new Huluwa("SIX"),new Huluwa("SEVEN")};

	//SINGLETON
	private HuluBrothers() {}
	private static final HuluBrothers instance=new HuluBrothers();
	public static HuluBrothers getInstance() { return instance; }
	
	public String toString()
	{
		return Arrays.asList(Brothers).toString();
	}

	public void shuffle()
	{
		List<Huluwa> bro=Arrays.asList(Brothers);
		Collections.shuffle(bro);
		Brothers=(Huluwa[])bro.toArray(new Huluwa[bro.size()]);
	}

	private void swap(int m,int n)
	{
		if(m==n) { return; }
		System.out.println(Brothers[m].getName()+":"+(m+1)+"->"+(n+1)+"  ||  "+Brothers[n].getName()+":"+(n+1)+"->"+(m+1));
		Huluwa temp=Brothers[m];
		Brothers[m]=Brothers[n];
		Brothers[n]=temp;
	}

	public void bubbleSort()
	{
		int len=Brothers.length;
		for(int i=0;i<len-1;i++)
		{
			for(int j=0;j<len-1-i;j++)
			{
				if(Brothers[j+1].getPos()<Brothers[j].getPos()) { swap(j,j+1); }
			}
		}
	}

	public void quickSort()
	{
		qsort(0,Brothers.length-1);
	}

	private void qsort(int left,int right)
	{
		if(left>=right) { return; }
		if(right-left==1&&Brothers[left].getPos()>Brothers[right].getPos()) { swap(left,right); }

		int i=left-1,j=right;
		Huluwa median=Brothers[right];

		while(true)
		{
			while(i<Brothers.length-1&&Brothers[++i].getPos()<median.getPos());
			while(j>0&&Brothers[--j].getPos()>median.getPos());
			
			if(j>i) { swap(i,j); }
			else { break;}
		}
		swap(i,right);
		qsort(left,i-1);
		qsort(i+1,right);
	}

	public void countOff(String s)
	{
		Arrays.asList(Brothers).forEach(r->{System.out.print("<"+(s=="name"? r.getName():(s=="color"? r.getColor():"WrongParameter"))+">  ");});
		System.out.println();
	}	
}

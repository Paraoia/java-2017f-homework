import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

class hello {
	class Calabash
	 {
		 int rank;
		 String color;
		 String name;
		 Calabash(int i)
		 {
			 rank=i;
			 if(i==1)
			 {
				 color="red";
				 name="one";
			 }
			 else if(i==2)
			 {
				 color="orange";
				 name="two";
			 }
			 else if(i==3)
			 {
				 color="yellow";
				 name="three";
			 }
			 else if(i==4)
			 {
				 color="green";
				 name="four";
			 }
			 else if(i==5)
			 {
				 color="cyan";
				 name="five";
			 }
			 else if(i==6)
			 {
				 color="blue";
				 name="six";
			 }
			 else if(i==7)
			 {
				 color="purple";
				 name="seven";
			 }
		 }
		 
	 }
	class queue
	{
		int length;
		Calabash[] a;
	
	Calabash[] midsort()
	{
		Calabash[] temp = new Calabash[a.length];
		for (int i = 0; i < temp.length; i++) {
		if (i == 0) {
		temp[i] = a[i];
		System.out.println(temp[i].name+": null->1");
		} else {
		for (int j = 0, k = i - 1; j < i && k >= 0;) {
		if (temp[(j + k) / 2].rank >= a[i].rank) {
		if ((j + k) / 2 == 0) {
		for (int iter = i; iter > 0; iter--) {
		temp[iter] = temp[iter - 1];
		System.out.println(temp[iter].name+": "+iter+ "->"+(iter+1));
		}
		temp[0] = a[i];
		System.out.println(temp[0].name+": null->1");
		break;
		} else if (temp[(j + k) / 2 - 1].rank <= a[i].rank) {
		for (int iter = i; iter > (j + k) / 2; iter--) {
		temp[iter] = temp[iter - 1];
		System.out.println(temp[iter].name+": "+iter+ "->"+(iter+1));
		}
		temp[(j + k) / 2] = a[i];
		System.out.println(temp[(j + k) / 2].name+": null->"+((j + k) / 2));
		break;
		} else {
		k = (k + j) / 2-1;
		}
		} else if (temp[(j + k) / 2].rank < a[i].rank) {
		if ((j + k) / 2 == i - 1) {
		temp[i] = a[i];
		System.out.println(temp[i].name+": null->"+(i+1));
		break;
		} else {
		j=(k + j) / 2+1;
		}
		}
		}
		}
		}
		for(int i=0;i<a.length;i++)
		{
			
			System.out.print(temp[i].color+" ");
		}
		System.out.println();
		return temp;
	}
	Calabash[] boublesort()
	{
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=0;j<a.length-1-i ;j++)
			{
				if(a[j].rank>a[j+1].rank)
				{
					System.out.println(a[j].name+": "+j+ "->"+(j+1));
					System.out.println(a[j+1].name+": "+(j+1)+ "->"+(j));
					Calabash temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		for(int i=0;i<a.length;i++)
		{
			
			System.out.print(a[i].name+" ");
		}
		System.out.println();
		return a;
	}
	queue(int length,int[] rank)
	{
		this.length=length;
		a=new Calabash[length];
		for(int i=0;i<length;i++)
		{
			a[i]=new Calabash(rank[i]);
		}
	}
	}
	public static void main(String[] args) {
		int[] rank1={2,3,4,5,6,1,7}; 
		hello x=new hello();
		queue a1=x.new queue(7,rank1);
		a1.midsort();
		int[] rank2={2,3,4,5,6,1,7}; 
		queue a2=x.new queue(7,rank2);
		a1.boublesort();
		 
	 }
	  
        
}

package javaH2;

import java.util.Random;

public class HuluM{
	int population;
	
	Huluwa[] huluwa;
	//ArrayList array;

	public HuluM() {
		this.population = 0;
		huluwa = new Huluwa[8];
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	public void add(Huluwa H)
	{
		if (population>=8)
		{
			System.out.println("建议百度搜索“葫芦娃有几兄弟”");
			return;
		}
		huluwa[population]=H;
		population=population+1;
	}
	
	public void assemble() {
		int []flag=new int[7];
		for (int i = 0; i < population; i++) {
			Random r=new Random();
			int R=r.nextInt(7);
			while(flag[R]!=0)
				R=r.nextInt(7);
			flag[R]=1;
			for (int j = 0; j < population; j++) {
				if(huluwa[j].getID()==R)
				{
					huluwa[i].swap(huluwa[j], huluwa);
				}
			}
		}
	}
	
	public void BubbleSort()
	{
		for (int i = 0; i < population; i++) {
			for (int j = 0; j < population-1; j++) {
				if(huluwa[j].solo(huluwa[j+1])>0)
				{
					huluwa[j].swap(huluwa[j+1], huluwa);
				}
			}
		}
	}
	
	public void BinarySort()
	{
		int i,j;
		int high,low,mid;
		for (i = 0; i < population; i++) {
			low=0;
			high=i-1;
			huluwa[i].go(huluwa, 7);
			while(low<=high)
			{
				mid=(low+high)>>1;
				if(huluwa[mid].solo(huluwa[7])>0)//if(temp.getID()<huluwa[mid].getID())
					high=mid- 1;
				else low=mid+1;
			}
			for (j=i-1;j>=low;j--)
			{
				huluwa[j].swap(huluwa[j+1], huluwa);
			}
			huluwa[7].go(huluwa, low);
		}
		
	}
	
	public void Show()
	{
		for (int i = 0; i < population; i++) {
			System.out.println("第"+(i+1)+"位:"+"我是"+huluwa[i].getName()+"  "+huluwa[i].getcolor());
		}
	}
}

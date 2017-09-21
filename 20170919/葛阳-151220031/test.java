//package pack;
enum Color{
	red("红色"),orange("橙色"),yellow("黄色"),green("绿色"),ching("青色"),blue("蓝色"),purple("紫色");	
	String name;     
    private Color(String name) {  
         this.name = name;        
     }  
}

enum Rank{	
	one("老大"),two("老二"),three("老三"),four("老四"),five("老五"),six("老六"),seven("老七");
	String name;
	private Rank(String name)
	{
		this.name=name;
	}
}

class Hulu{
	Rank num;
	Color col;	
	Hulu(Rank n,Color c)
	{
		num=n;
		col=c;
	}
	//告知移动
	void TellMove(int a,int b) {
		System.out.println(num.name+": "+a+"->"+b);
	}
	//报序号
	void TellNum()
	{
		System.out.print(num.name+" ");
	}
	//报颜色
	void TellCol()
	{
		System.out.print(col.name+" ");
	}

}


class brothers{
	
	Hulu[] bro=new Hulu[7];//七个葫芦娃
	void initialize() {
		bro[0]=new Hulu(Rank.seven,Color.purple);		
		bro[1]=new Hulu(Rank.three,Color.yellow);
		bro[2]=new Hulu(Rank.five,Color.ching);
		bro[3]=new Hulu(Rank.one,Color.red);
		bro[4]=new Hulu(Rank.six,Color.blue);
		bro[5]=new Hulu(Rank.four,Color.green);
		bro[6]=new Hulu(Rank.two,Color.orange);
		
	}//随意站队
	
	//按排行进行冒泡排序
	void SortByNum() {
		for(int i=0; i< 7; i++) {
			int min=i;
			for (int j=i+1;j<7;j++)
			{
				if(bro[j].num.ordinal()<bro[min].num.ordinal())
					min=j;					
			}
			if (min!=i)
			{
				bro[i].TellMove(i, min);
				bro[min].TellMove(min, i);
				Hulu t=bro[i];
				bro[i]=bro[min];
				bro[min]=t;
				
				
			}
			}
	}
	
	//快速排序
	int partition(int low,int high)
	{
		
		Hulu pivot=bro[low];
		while(low<high)
		{
			
			while (low<high&&bro[high].col.ordinal()>=pivot.col.ordinal()) high--;
			if(low<high)
			{
				bro[high].TellMove(high,low);
				bro[low].TellMove(low,high);				
				bro[low]=bro[high];
				bro[high]=pivot;
			}
			while (low<high&&bro[low].col.ordinal()<=pivot.col.ordinal()) low++;
			if (low<high)
			{
				bro[high].TellMove(high,low);
				bro[low].TellMove(low,high);
				bro[high]=bro[low];
				bro[low]=pivot;
			}
		}		
		return low;
	}
	void QuickSort(int low,int high)
	{
		if(low<high)
		{
			int pivot=partition(low,high);
			QuickSort(low,pivot-1);
			QuickSort(pivot+1,high);
		}
		return ;
	}
	void SortByCol() {
		QuickSort(0,6);
	}//按颜色快速排序
	
	//从前往后报排行
	void Number() {
		for (int i=0;i<7;i++)
		{
			bro[i].TellNum();
		}
		System.out.println();
	}
	//从前往后报颜色
	void Color() {
		for (int i=0;i<7;i++)
			bro[i].TellCol();
		System.out.println();
		
	}
	
}
public class test {
	public static void main(String[] args) {
	brothers SevenHulu=new brothers();
	SevenHulu.initialize();
	SevenHulu.SortByNum();
	SevenHulu.Number();
	SevenHulu.initialize();
	SevenHulu.SortByCol();
	SevenHulu.Color();
	
		
	
	}
}

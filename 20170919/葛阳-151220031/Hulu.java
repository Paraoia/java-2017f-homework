//package pack;


public class Hulu {

	
	Rank num;
	Color col;	

	//初始化，根据序号确定颜色和排行
	void setHulu(int i)
	{
		switch (i)
		{
		case 1: num=Rank.one;col=Color.red;break;
		case 2:num=Rank.two;col=Color.orange;break;
		case 3:num=Rank.three;col=Color.yellow;break;
		case 4:num=Rank.four;col=Color.green;break;
		case 5:num=Rank.five;col=Color.ching;break;
		case 6:num=Rank.six;col=Color.blue;break;
		default:num=Rank.seven;col=Color.purple;break;
		
			
		}
	}
	
	//葫芦娃从椅子a坐到椅子b
	void gotoSeat(Seat a,Seat b)
	{
		tellMove(a.index,b.index);
		b.holder=this;
		
	}
	
	//告知移动
	void tellMove(int a,int b) {
			System.out.println(num.name+": "+a+"->"+b);
		
	}
	//报序号
	void tellNum()
	{
		System.out.print(num.name+" ");
	}
	//报颜色
	void tellCol()
	{
		System.out.print(col.name+" ");
	}
	//得到颜色序号
	int getColOrd()//
	{
		return col.ordinal();
	}
	//得到排行序号
	int getRankOrd()
	{
		return num.ordinal();
	}
	
}


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

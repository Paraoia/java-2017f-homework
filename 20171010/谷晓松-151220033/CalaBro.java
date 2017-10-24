package com.gxs;



enum Name
{
	 红娃,橙娃,黄娃,绿娃,青娃,蓝娃,紫娃;
}
enum Color
{
	赤, 橙, 黄, 绿, 青, 蓝, 紫 ;
}
enum Rank
{
	一,二,三,四,五,六,七;
}
public class CalaBro extends Creature
{
	private Color color;
	private Rank rank;
	private Position pos;
	
	private CalaBro(String name,Color color,Rank rank)
	{
		super(name);
		this.color=color;
		this.rank=rank;
	}
	private static CalaBro brothers[]=new CalaBro[7];
	static 
	{
		for(int i=0;i<7;i++)
			brothers[i]=new CalaBro(Name.values()[i].toString(),Color.values()[i],Rank.values()[i]);
	}
	
	public static CalaBro[] getAcess() {return brothers;}
}
class Grandpa extends Creature
{
	private Grandpa(String name)
	{
		super(name);
	}
	private static Grandpa grandpa=new Grandpa("爷爷");
	public static Grandpa getAcess()
	{
		return grandpa;
	}
}
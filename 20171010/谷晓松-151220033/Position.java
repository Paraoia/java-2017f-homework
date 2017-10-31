package com.gxs;



public class Position {
	
	private int x;
	private int y;
	private Creature holder;
	
	Position(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public Creature getHolder()
	{
		return holder;
	}
	public void setHolder(final Creature c)
	{
		holder=c;
	}
	public void freeHolder()
	{
		holder=null;
	}
	public int getX() {return x;}
	public int getY() {return y;}
}

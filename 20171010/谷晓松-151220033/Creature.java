package com.gxs;


public class Creature
{
	private Position pos;
	private Dir dir;
	private String name;
	
	Creature(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	final protected Position getPositon()
	{
		return pos;
	}
	final protected void setPosition(Position pos)
	{
		this.pos=pos;
		pos.setHolder(this);
	}
	final protected void leavePosition()
	{
		this.pos.freeHolder();
		this.pos=null;
	}
	final protected void setDir(Dir dir)
	{
		this.dir=dir;
	}
	final protected Dir getDir()
	{
		return this.dir;
	}
	final protected void report(final Space map)
	{
		String tem=this.name;
		char[][] t=map.getDrawBoard();
		int x=pos.getX(),y=pos.getY();
		t[x][y]=tem.charAt(0);
		switch(dir)
		{
		case UP:	t[x+1][y]=tem.charAt(1);	break;
		case DOWN:	t[x-1][y]=tem.charAt(1);	break;
		case LEFT:	t[x][y+1]=tem.charAt(1);	break;
		case RIGHT:	t[x][y-1]=tem.charAt(1);	break;
		}
	}
}

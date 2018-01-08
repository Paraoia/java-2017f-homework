package com.gxs;



public class Shape
{
	private Position key;
	private Dir dir;
	
	static final Position[] Moon=new Position[] {
			new Position(0,0),new Position(0,-2),new Position(0,2),
			new Position(3,0),new Position(3,-2),new Position(3,2),
			new Position(6,0),new Position(6,-2),new Position(6,2),
			new Position(8,-4),new Position(8,4),new Position(9,-6),
			new Position(9,6),new Position(10,-8),new Position(10,8),
			new Position(11,-10),new Position(11,10),new Position(12,-12),
			new Position(12,12),new Position(13,-14),new Position(13,14)};
	static final Position[] Line=new Position[] {
			new Position(0,0),new Position(2,0),new Position(4,0),
			new Position(6,0),new Position(8,0),new Position(10,0),
			new Position(12,0)};
	static final Position[] Dot=new Position[] {
			new Position(0,0)};
	static final Position[] Wing=new Position[]{
			new Position(0,0),new Position(2,-2),new Position(4,-4),
			new Position(6,-6),new Position(2,2),new Position(4,4),
			new Position(6,6)};
	Shape(Position key,Dir dir)
	{
		this.key=key;
		this.dir=dir;
	}
	Shape()
	{
		this.key=new Position(0,0);
		this.dir=Dir.UP;
	}
	public final void setPos(Position pos) {this.key=pos;}
	public final Position getPos() {return key;}
	public final void setDir(Dir dir) {this.dir=dir;}
	public final Dir getDir() {return dir;}
	public final void makeShape(Creature c[],Position[] pattern)
	{
		int x=key.getX(),y=key.getY();
		c[0].setPosition(key);c[0].setDir(dir);
		for(int i=1;i<pattern.length;i++)
		{
			c[i].setDir(dir);
			switch(dir)
			{
			case UP:	c[i].setPosition(new Position(pattern[i].getX()+x,pattern[i].getY()+y));	break;
			case DOWN:	c[i].setPosition(new Position(-pattern[i].getX()+x,-pattern[i].getY()+y));	break;
			case LEFT:	c[i].setPosition(new Position(-pattern[i].getY()+x,pattern[i].getX()+y));	break;
			case RIGHT:	c[i].setPosition(new Position(pattern[i].getY()+x,-pattern[i].getX()+y));	break;
			}
		}
	}
}


	
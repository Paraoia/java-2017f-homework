package com.gxs;

public class Space
{
	private static final int SIZE=100;
	
	
	private Position[][] spa;
	private char[][] drawboard;
	private Shape shape;
	private Space()
	{
		shape=new Shape();
		spa=new Position[SIZE][SIZE];
		drawboard=new char[SIZE][SIZE];
		for(int i=0;i<SIZE;i++)
			for(int j=0;j<SIZE;j++)
				drawboard[i][j]=' ';
	}
	
	private static Space map=new Space();
	
	public static int getMapSize() {return SIZE;}
	public static Space getMap()
	{
		return map;
	}
	public char[][] getDrawBoard(){return drawboard;}
	
	public void draw()
	{
		for(int i=0;i<SIZE;i++)
		{
			for(int j=0;j<SIZE;j++)
			{
				if(drawboard[i][j]==' ')
					System.out.print("  ");
				else
					System.out.print(drawboard[i][j]);
			}
				
			System.out.println();
		}
	}
	public void wipe()
	{
		for(int i=0;i<SIZE;i++)
			for(int j=0;j<SIZE;j++)
				drawboard[i][j]=' ';
	}
	public void embattle(Creature[]c,Dir dir,Position pos,Position[] pattern)
	{
		shape.setDir(dir);
		shape.setPos(pos);
		shape.makeShape(c,pattern);
		for(int i=0;i<pattern.length;i++)
			c[i].report(this);
	}
	public void setCreature(Creature c,Dir dir,Position pos)
	{
		shape.setDir(dir);
		shape.setPos(pos);
		Creature[] cre=new Creature[1];
		cre[0]=c;
		shape.makeShape(cre,Shape.Dot);
		c.report(this);
	}
}

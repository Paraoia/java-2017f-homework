package com.gxs;

public class Monster extends Creature
{
		
	private String name;
	
	Monster(String name)
	{
		super(name);
	}
}

class Scorpion extends Creature
{
	private String name;
	
	private Scorpion(String name)
	{
		super(name);
	}
	private static Scorpion scorpion=new Scorpion("蝎子");
	
	public static Scorpion getAcess()
	{
		return scorpion;
	}
	
}
class Snake extends Creature
{
	private String name;
	
	private Snake(String name)
	{
		super(name);
	}
	private static Snake snake=new Snake("蛇精");
	public static Snake getAcess()
	{
		return snake;
	}
}
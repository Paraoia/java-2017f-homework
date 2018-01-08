package Huluwa;

public class Xiezijing implements Creature {
	private Position num;
	Xiezijing(Position pos)
	{
		num=pos;
	}
	public void setPosition(Position a)
	{
		this.num=a;
	
	}
	public void getsign()
	{
		System.out.print('Ð«');
	}
	public Position getPosition()
	{
		
		return num;
	}
	
	public void tellname()
	{
		System.out.print("¶þµ±¼Ò");
	}
	public void tellpos()
	{
		num.tellx();
		num.telly();
	}
}
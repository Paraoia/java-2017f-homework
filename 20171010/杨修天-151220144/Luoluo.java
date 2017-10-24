package Huluwa;

public class Luoluo implements Creature {
	private Position num;
	Luoluo(Position pos)
	{
		num=pos;
	}
	public void setPosition(Position a)
	{
		this.num=a;
	
	}
	public void getsign()
	{
		System.out.print('นึ');
	}
	public Position getPosition()
	{
		
		return num;
	}
	
	public void tellname()
	{
		System.out.print("ะกัýนึ");
	}
	public void tellpos()
	{
		num.tellx();
		num.telly();
	}
}

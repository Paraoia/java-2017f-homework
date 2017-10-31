package Huluwa;

public class Grandpa implements Creature {
	private Position num;
	Grandpa(Position pos)
	{
		num=pos;
	}
	public void setPosition(Position a)
	{
		this.num=a;
	
	}
	public void getsign()
	{
		System.out.print('“Ø');
	}
	public Position getPosition()
	{
		
		return num;
	}
	
	public void tellname()
	{
		System.out.print("¿œ“Ø“Ø");
	}
	public void tellpos()
	{
		num.tellx();
		num.telly();
	}
}

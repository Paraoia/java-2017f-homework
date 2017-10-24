package Huluwa;

public class Snake implements Creature {
	private Position num;
	Snake(Position pos)
	{
		num=pos;
	}
	public void setPosition(Position a)
	{
		this.num=a;
	
	}
	public void getsign()
	{
		System.out.print("…ﬂ");
	}
	public Position getPosition()
	{
		
		return num;
	}
	
	public void tellname()
	{
		System.out.print("¿œ¥Û");
	}
	public void tellpos()
	{
		num.tellx();
		num.telly();
	}
}
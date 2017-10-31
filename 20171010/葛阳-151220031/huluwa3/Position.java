package huluwa3;

public class Position {

	private int x,y;
	private Creature holder;
	
	Position (int x1,int y1)
	{
		x=x1;
		y=y1;
		holder=null;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setPosition(int x1,int y1)
	{
		this.x=x1;
		this.y=y1;
	}
	public Creature getHolder()
	{
		return holder;
	}
	
	public void setHolder(Creature holder1)
	{
		holder=holder1;
	}
	
	public void printPosition()
	{
		System.out.print("("+x+","+y+")");
	}
	
	public boolean equal(Position pos)
	{
		if (this.x==pos.x&&this.y==pos.y)
			return true;
		else
			return false;
	}
	
	public void printHolder() 
	{
		if (this.holder==null)
			System.out.print(" ");
		else
			this.holder.printCreature();
	}
	
	public void setNull()
	{
		this.holder=null;
	}
	
}

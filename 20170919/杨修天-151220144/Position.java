package Huluwa;

public class Position {
	private int x;
	private int y;
	private Huluwa people;
	Position(int x)
	{	super();
		this.x=x;
		this.y=0;
	}
	public void setpeople(Huluwa a)
	{
		this.people=a;
		this.people.setPosition(this);
		
	}
	public Huluwa getpeople()
	{
		return people;
	}
	public void reportnum()
	{
		System.out.print(this.x+" ");
	}
	public void reportpeo()
	{	
		this.people.tellname();
		
	}
	public void reportcolor()
	{
		this.people.tellcolor();
	}
	public void tellx()
	{
		System.out.print(x+" ");
		
	}
}

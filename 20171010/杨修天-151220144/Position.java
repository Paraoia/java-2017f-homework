package Huluwa;

public class Position {
	private int x;
	private int y;
	private int judge;
	private Creature people;
	Position(int x,int y,int z)
	{	super();
		this.x=x;
		this.y=y;
		this.judge=z;
	}
	public void rejudge()
	{
		judge=1;
	}
	public void dejudge()
	{
		judge=0;
	}
	public void getsign()
	{
		this.people.getsign();
	}
	public int judgeit()
	{
		return this.judge;
	}
	public void setpeople(Creature a)
	{
		this.people=a;
		this.people.setPosition(this);
		
	}

	public Creature getpeople()
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
	
	public void tellx()
	{
		System.out.print(x+" ");
		
	}
	public void telly()
	{
		System.out.print(y+" ");
		
	}
}

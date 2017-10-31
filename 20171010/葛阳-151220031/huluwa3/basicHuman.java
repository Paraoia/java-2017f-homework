package huluwa3;

public abstract class basicHuman implements Creature{

	Position position;
	@Override
	public Position getPosition()
	{
		return position;
	}
	
	@Override
	public void setPosition(Position positionToSet)
	{
		this.position.setNull();
		this.position=positionToSet;
		this.position.setHolder(this);
	}
	
	@Override
	public void tellMove(Position a,Position b)//¸æÖªÒÆÎ»
	{
		this.report();
		System.out.print(" :");
		a.printPosition();
		System.out.print("->");
		b.printPosition();
		System.out.println();
	}
	@Override
	public boolean smallerThan(Creature creature,int type)
	{
		return false;
	}
	basicHuman()
	{
		position=new Position(0,0);
	}
}

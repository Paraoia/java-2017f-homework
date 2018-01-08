package huluwa3;

public interface Creature {

	public void report();
	public void printCreature();//在站队中打印形象
	public Position getPosition();
	public void setPosition(Position position);
	public boolean smallerThan(Creature creature,int type);
	public void tellMove(Position a,Position b);
	
	
}

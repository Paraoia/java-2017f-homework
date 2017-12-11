package huluwa3;

public class Snake extends basicHuman implements Creature{
	public void printCreature()
	{
		System.out.print("S");
	}

	@Override
	public void report() {
		System.out.print("Snake");
		
	}

}

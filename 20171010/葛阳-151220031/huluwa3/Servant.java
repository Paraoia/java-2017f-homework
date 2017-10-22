package huluwa3;

public class Servant extends basicHuman implements Creature{
	
	public void printCreature()
	{
		System.out.print("z");
	}

	@Override
	public void report() {
		System.out.print("Servant");
		
	}

}

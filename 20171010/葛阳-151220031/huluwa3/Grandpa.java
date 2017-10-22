package huluwa3;

public class Grandpa extends basicHuman implements Creature{
	
	public void printCreature()
	{
		System.out.print("G");
	}

	@Override
	public void report() {
		System.out.print("Grandpa");
		
	}
	

}

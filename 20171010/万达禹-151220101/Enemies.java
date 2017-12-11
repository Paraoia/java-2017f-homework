package HuluTeam;

import java.util.ArrayList;

public class Enemies implements Creatures{
	
	protected ArrayList<Creature> enemies;
	
	public Enemies() {
		enemies = new ArrayList<Creature>();
	}
	
	@Override
	public void add(String n) {
		Creature a = new Creature(n);
		enemies.add(a);
	}
	
	@Override
	public void show() {
		for(int i=0;i<enemies.size();i++)
			enemies.get(i).report();
	}

	@Override
	public int getnumber() {
		return enemies.size();
	}
	
	@Override
	public Creature getCreature(int n) {
		return enemies.get(n);
	}
	
	public void adjusttonum(int num) {
		if(enemies.size()<num) {
			while(enemies.size()<num) {
				Creature a = new Creature("±ø");
				enemies.add(a);
			}
		}
		else if(enemies.size()>num) {
			while(enemies.size()>num) {
				enemies.remove(enemies.size()-1);
			}
		}	
	}
	
}

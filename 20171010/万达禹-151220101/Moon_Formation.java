package HuluTeam;

import java.util.ArrayList;

public class Moon_Formation implements Formation{

	@Override
	public void SetFormation(BattleField a, ArrayList<Creature>b, int x, int y) {
		System.out.println("¶ÔÕ½£¡ÙÈÔÂÕó£º");
		a.setHolder(b.get(0), x, y);
		a.setHolder(b.get(1), x-1, y-1);
		a.setHolder(b.get(2), x+1, y-1);
		a.setHolder(b.get(3), x, y-1);
		a.setHolder(b.get(4), x-1, y);
		a.setHolder(b.get(5), x+1, y);
		a.setHolder(b.get(6), x-1, y+1);
		a.setHolder(b.get(7), x+1, y+1);
		a.setHolder(b.get(8), x, y+1);
		a.setHolder(b.get(9), x+2, y+1);
		a.setHolder(b.get(10), x-2, y+1);
		a.setHolder(b.get(11), x+3, y+2);
		a.setHolder(b.get(12), x-3, y+2);
		a.setHolder(b.get(13), x+2, y+2);
		a.setHolder(b.get(14), x-2, y+2);
		a.setHolder(b.get(15), x+3, y+3);
		a.setHolder(b.get(16), x-3, y+3);
		a.setHolder(b.get(17), x+4, y+4);
		a.setHolder(b.get(18), x-4, y+4);
	}

}

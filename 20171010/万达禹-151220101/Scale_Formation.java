package HuluTeam;

import java.util.ArrayList;

public class Scale_Formation implements Formation{

	@Override
	public void SetFormation(BattleField a, ArrayList<Creature>b, int x, int y) {
		System.out.println("∂‘’Ω£°”„¡€’Û£∫");
		a.setHolder(b.get(0), x, y);
		a.setHolder(b.get(1), x+2, y);
		a.setHolder(b.get(2), x-2, y);
		a.setHolder(b.get(3), x-1, y-1);
		a.setHolder(b.get(4), x, y-2);
		a.setHolder(b.get(5), x+1, y+1);
		a.setHolder(b.get(6), x-1, y+1);
		a.setHolder(b.get(7), x+3, y+1);
		a.setHolder(b.get(8), x-3, y+1);
		a.setHolder(b.get(9), x, y+2);
	}

}

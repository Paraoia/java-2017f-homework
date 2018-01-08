package HuluTeam;

import java.util.ArrayList;

public class Flying_Geese_Formation implements Formation{

	@Override
	public void SetFormation(BattleField a, ArrayList<Creature>b, int x, int y) {
		System.out.println("∂‘’Ω£°—„––’Û£∫");
		a.setHolder(b.get(0), x, y);
		for(int i=1;i<b.size();i++) {
			a.setHolder(b.get(i), x-i, y+i);
		}
	}
	
}
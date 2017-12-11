package HuluTeam;

import java.util.ArrayList;

public class Square_Formation implements Formation{

	@Override
	public void SetFormation(BattleField a, ArrayList<Creature>b, int x, int y) {
		System.out.println("对战！方形阵：");
		a.setHolder(b.get(0), x, y);
		int j=1;
		for(int i=1;i<=b.size()/4;i++) {
			a.setHolder(b.get(j++), x+i, y+i);
			a.setHolder(b.get(j++), x-i, y+i);
		}
		for(int i=b.size()/4-1;i>0;i--) {
			a.setHolder(b.get(j++), x+i, y+b.size()/2-i);
			a.setHolder(b.get(j++), x-i, y+b.size()/2-i);
		}
		a.setHolder(b.get(b.size()-1), x, y+b.size()/2);
		
	}

}

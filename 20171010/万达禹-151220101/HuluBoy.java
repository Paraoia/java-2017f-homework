package HuluTeam;

public class HuluBoy extends Creature{
	
	private int rank;
	
	public HuluBoy(String n){
		super(n);
		switch(n) {
			case "大":rank = 1;break;
			case "二":rank = 2;break;
			case "三":rank = 3;break;
			case "四":rank = 4;break;
			case "五":rank = 5;break;
			case "六":rank = 6;break;
			case "七":rank = 7;break;
			default: rank = -1;break;
		}
	}
	
	public int get_rank() {
		return this.rank;
	}	
	
	public void SetPosition(int x, int y) {
		super.setPosition(x, y);
		position.SetHolder(this);
	}
	
}
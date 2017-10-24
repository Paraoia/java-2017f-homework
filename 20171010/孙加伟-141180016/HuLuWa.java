package huluwa;

public class HuLuWa extends Creature{
	int rank;
	Color color;
	public HuLuWa() {
	}
	
	public HuLuWa(int rank,Color color) {
		setName(color.toString());
		setProperty(true);
		setActivity(State.BATTLER);
		setRank(rank);
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank=rank;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color=color;
	}	
}

enum Color{
	RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE;
}
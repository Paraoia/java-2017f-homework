public class Huluwa extends Creature implements Comparable {
	private int rank;
	private Color color;
	
	public Huluwa(int rank, Color color, String name) {
		this.rank = rank;
		this.color = color;
		this.name = name;
	}
	
	public int getRank() {
		return rank;
	}
 	
	public Color getColor() {
		return color;
	}
	
	@Override
	public boolean isBiggerThan(Comparable another) {
		return (this.rank < ((Huluwa) another).rank);
	}
}

enum Color {
	CHI, CHENG, HONG, LV, QING, LAN, ZI;
}
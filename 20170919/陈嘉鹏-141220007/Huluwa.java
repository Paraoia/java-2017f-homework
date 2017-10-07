
public class Huluwa {
	Rank rank;
	Color color;
	
	public Huluwa(Rank r, Color c) {
		this.rank = r;
		this.color = c;
	}
	
	public boolean greaterRank(Huluwa h) {
		return Rank.greater(this.rank, h.rank);
	}
	
	public boolean greaterColor(Huluwa h) {
		return Color.greater(this.color, h.color);
	}
	
	public Rank getRank() {
		return rank;
	}
	public String getStrRank() {
		return "老" + rank.name;
	}
	public Color getColor() {
		return color;
	}
	public String getStrColor() {
		return color.name;
	}
}

enum Rank{
	/* Huluwa's Rank */
	FIRST("大"),
	SECOND("二"),
	THIRD("三"),
	FOURTH("四"),
	FIFTH("五"),
	SIXTH("六"),
	SEVENTH("七");
	
	String name;
	Rank(String name) {this.name = name;}
	public static boolean greater(Rank r1, Rank r2) {
		return r1.ordinal() < r2.ordinal();
	}
}


enum Color{
	/* Huluwa's Color */
	RED("赤"),
	ORANCE("橙"),
	YELLOW("黄"),
	GREEN("绿"),
	CYAN("青"),
	BLUE("蓝"),
	PURPLE("紫");

	String name;
	Color(String name) {this.name = name;}
	public static boolean greater(Color c1, Color c2) {
		return c1.ordinal() < c2.ordinal();
	}
}
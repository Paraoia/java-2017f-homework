package MyHuluSort;

public class HuluBoy {
	private int rank;
	private String name;
	private String color;
	private int colorweight;
	
	public HuluBoy(int r, String n, String c, int cw) {
		this.rank = r;
		this.name = n;
		this.color = c;
		this.colorweight = cw;
	}
	
	public int get_rank() {
		return this.rank;
	}
	
	public int get_colorweight() {
		return this.colorweight;
	}
	
	public String report_Boy(String ch) {
		switch(ch) {
		case "name": return this.name;
		case "color": return this.color;
		default: return "no this choice";
		}
	}
}

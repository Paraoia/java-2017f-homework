public class GourdBoy extends GoodCharacter implements Comparable {
	private Color color;
	private Seniority seniority;

	GourdBoy(Color color, Seniority seniority) {
		this.color = color;
		this.seniority = seniority;
	}

	public Color getColor(){
		return color;
	}

	public Seniority getSeniority() {
		return seniority;
	}

	@Override
	public boolean biggerThan(Comparable another) {
		if(another instanceof GourdBoy)
			return this.seniority.ordinal()>((GourdBoy) another).seniority.ordinal();
		else
			return false;
	}

	@Override
	public String toString(){
		return seniority.toString().substring(1)+"娃";
	}
}

enum Color{
	红, 橙, 黄, 绿, 青, 蓝, 紫
}

enum Seniority{
	老大, 老二, 老三, 老四, 老五, 老六, 老七
}
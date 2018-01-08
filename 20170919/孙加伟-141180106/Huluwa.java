public class Huluwa {

	private String name; // 名字
	private Color color; // 颜色
	private int rank; // 排行

	Huluwa(String name, Color color, int rank) {
		this.name = name;
		this.color = color;
		this.rank = rank;
	}

	public String getName() {
		return name; // 获取葫芦娃名字
	}

	public void setName(String na) {
		this.name = name; // 设置葫芦娃名字
	}

	public String getColor() {
		return color.getColorName(); // 获取颜色
	}

	public void setColor(Color color) {
		this.color = color; // 设置颜色
	}

	public int getRank() {
		return this.rank; // 获取排行
	}

	public void setRank(int rank) {
		this.rank = rank; // 设置排行
	}

	public void report(Huluwa huluwa, int i, int j) {
		System.out.println("老" + huluwa.getRank() + " : " + i + " -> " + j); // 汇报交换顺序
	}

	public void reportRank(Huluwa huluwa) {
		System.out.println(huluwa.getRank()); // 汇报葫芦娃排行
	}

	public void reportColor(Huluwa hu) {
		System.out.println(hu.getColor()); // 汇报葫芦娃颜色
	}
}
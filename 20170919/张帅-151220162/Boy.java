enum Color{
	RED("红色"), ORANGE("橙色"), YELLOW("黄色"), GREEN("绿色"), CYAN("青色"), BLUE("蓝色"), PURPLE("紫色");

	private String name;

	private Color(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}

public class Boy {
	static String numberStr[] = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
	int number;
	Color color;

	Boy(){
		number = -1;
	}

	Boy(int n){
		number = n;
	}

	Boy(int n, Color color){
		this(n);
		this.color = color;
	}

	public int getNumber() {
		return number;
	}

	public Color getColor(){
		return this.color;
	}

	public void moveTo(int oldLoc, int newLoc) {
		System.out.println(numberStr[number] + "：" + oldLoc + "->" + newLoc);
	}

	public void putNumber(){
		System.out.print(numberStr[number]+" ");
	}

	public void putColor(){
		System.out.print(this.color.toString()+" ");
	}

}

public class Boy {
	static String numberStr[] = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
	static String colorStr[] = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色"};
	int number;

	Boy(){
		number = -1;
	}

	Boy(int n){
		number = n;
	}

	public int getNumber() {
		return number;
	}

	public void moveTo(int oldLoc, int newLoc) {
		System.out.println(numberStr[number] + "：" + oldLoc + "->" + newLoc);
	}

	public void putNumber(){
		System.out.print(numberStr[number]+" ");
	}

	public void putColor(){
		System.out.print(colorStr[number]+" ");
	}

}

package HuLuBro;

public class Test {
	public static void main(String []args){
		HuLuWa huluwa[]=new HuLuWa[7];
		
		
		huluwa[0]=new HuLuWa("老大",Color.RED,1);
		huluwa[1]=new HuLuWa("老二",Color.ORANGE,2);
		huluwa[2]=new HuLuWa("老三",Color.YELLOW,3);
		huluwa[3]=new HuLuWa("老四",Color.GREEN,4);
		huluwa[4]=new HuLuWa("老五",Color.CHING,5);
		huluwa[5]=new HuLuWa("老六",Color.BLUE,6);
		huluwa[6]=new HuLuWa("老七",Color.PURPLE,7);
		
		Home home=new Home(huluwa);
		System.out.println("排序前的顺序:");
		home.outName();
		System.out.println("排序中...");
		home.bubbleSort();
		System.out.println("排序后的顺序:");
		home.outName();
		
		home.messUp();
		
		System.out.println("排序前的顺序:");
		home.outColor();
		System.out.println("排序中...");
		home.divideSort();
		System.out.println("排序后的顺序:");
		home.outColor();

	}
}

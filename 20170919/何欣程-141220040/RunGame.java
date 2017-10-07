
/*======上帝之手========*/
public class RunGame {
	public static void main(String[] args){
		GourdDollGroup game =new GourdDollGroup();
		game.DollsBorn();
		System.out.println("=====冒泡排序之前报排行=======");
		game.SayOrder();	
		System.out.println();	
		System.out.println("=====开始排序=======");
		game.BubbleSort();
		System.out.println("=====冒泡排序之后报排行=======");
		game.SayOrder();
		System.out.println();
		System.out.println();
		game.DollsBorn();
		System.out.println("=====快速排序之前报颜色=======");
		game.SayColor();
		System.out.println();
		System.out.println("=====开始排序=======");
		game.quickSort();
		System.out.println("=====快速排序之后报颜色=======");
		game.SayColor();
		
	}
	
}

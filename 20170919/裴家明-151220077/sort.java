package javaH2;

public class sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuluM God=new HuluM();
		God.add(new Huluwa("老大","赤"));
		God.add(new Huluwa("老二","橙"));
		God.add(new Huluwa("老三","黄"));
		God.add(new Huluwa("老四","绿"));
		God.add(new Huluwa("老五","青"));
		God.add(new Huluwa("老六","蓝"));
		God.add(new Huluwa("老七","紫"));
		
		
		System.out.println("先看下初始情况：");
		God.Show();
		
		System.out.println("集合了，看下他们位置发生了那些变化：");
		God.assemble();
		System.out.println("集合完毕，看下他们怎么站队的：");
		God.Show();
		
		System.out.println("冒泡排序后，队列发生的变化：");
		God.BubbleSort();
		System.out.println("排序完毕，看下他们怎么站队的：");
		God.Show();
		
		//解散
		
		System.out.println("集合了，看下他们位置发生了那些变化：");
		God.assemble();
		System.out.println("集合完毕，看下他们怎么站队的：");
		God.Show();
		
		
		System.out.println("二分法排序后，队列发生的变化：");
		God.BinarySort();
		System.out.println("排序完毕，看下他们怎么站队的：");
		God.Show();

		
	}

}


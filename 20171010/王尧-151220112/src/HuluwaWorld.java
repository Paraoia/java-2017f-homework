public class HuluwaWorld {
	Huluwa []huluwa;
	Yeye yeye;
	
	Shejing shejing;
	Xiezijing xiezijing;
	Xiaolouluo []xiaolouluo;
	
	Space space;
	
	Queue huluwaqueue;
	
	Queue yaojingqueue;
	
	public HuluwaWorld() {
		huluwa = new Huluwa[7];
		huluwa[0] = new Huluwa(1, Color.CHI, "Dawa");
		huluwa[1] = new Huluwa(2, Color.CHENG, "Erwa");
		huluwa[2] = new Huluwa(3, Color.HONG, "Sanwa");
		huluwa[3] = new Huluwa(4, Color.LV, "Siwa");
		huluwa[4] = new Huluwa(5, Color.QING, "Wuwa");
		huluwa[5] = new Huluwa(6, Color.LAN, "Liuwa");
		huluwa[6] = new Huluwa(7, Color.ZI, "Qiwa");
		
		yeye = new Yeye("Yeye");
		
		shejing = new Shejing("Shejing");
		xiezijing = new Xiezijing("Xiezijing");
		
		xiaolouluo = new Xiaolouluo[8];
		xiaolouluo[0] = new Xiaolouluo("Xiaolouluo_1");
		xiaolouluo[1] = new Xiaolouluo("Xiaolouluo_2");
		xiaolouluo[2] = new Xiaolouluo("Xiaolouluo_3");
		xiaolouluo[3] = new Xiaolouluo("Xiaolouluo_4");
		xiaolouluo[4] = new Xiaolouluo("Xiaolouluo_5");
		xiaolouluo[5] = new Xiaolouluo("Xiaolouluo_6");
		xiaolouluo[6] = new Xiaolouluo("Xiaolouluo_7");
		xiaolouluo[7] = new Xiaolouluo("Xiaolouluo_8");
		
		space = new Space(15);
		
		huluwaqueue = new Queue(7);
		
		yaojingqueue = new Queue(9);
	}
	
	private void huluwaEnqueue() {
		for (int i = 6; i >= 0; i--)
			huluwaqueue.enQueue(huluwa[i]);
	}
	
	private void yaojingEnqueue() {
		yaojingqueue.enQueue(xiezijing);
		for (int i = 0; i < 8; i++)
			yaojingqueue.enQueue(xiaolouluo[i]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuluwaWorld huluwaworld = new HuluwaWorld();
		
		//让初始乱序的七个兄弟入队后排序
		huluwaworld.huluwaEnqueue();
		new QuickSort().sort(huluwaworld.huluwaqueue);
		
		//让蝎子精带领小喽啰入队
		huluwaworld.yaojingEnqueue();
		
		//将葫芦娃等按阵型放入二维空间
		huluwaworld.yeye.setPosition(huluwaworld.space.getPosition(12, 6));
		new Changshe().form(huluwaworld.huluwaqueue, new Coordinate(14, 3), huluwaworld.space);
		huluwaworld.shejing.setPosition(huluwaworld.space.getPosition(10, 6));
		new Yanxing().form(huluwaworld.yaojingqueue, new Coordinate(8, 1), huluwaworld.space);
		huluwaworld.space.printSpace();
		
		huluwaworld.space.clearSpace();
		
		//按不同阵型将葫芦娃等放入二维空间
		huluwaworld.yeye.setPosition(huluwaworld.space.getPosition(12, 6));
		new Changshe().form(huluwaworld.huluwaqueue, new Coordinate(14, 3), huluwaworld.space);
		huluwaworld.shejing.setPosition(huluwaworld.space.getPosition(10, 6));
		new Heyi().form(huluwaworld.yaojingqueue, new Coordinate(8, 6), huluwaworld.space);
		huluwaworld.space.printSpace();
	}

}

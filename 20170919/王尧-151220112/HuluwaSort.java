public class HuluwaSort {
	Huluwa []hlw = new Huluwa[7];
	Queue queue = new Queue();
	
	HuluwaSort() {
		for (int i = 0; i < 7; i++)
			hlw[i] = new Huluwa();
		
		hlw[0].setNum(1); hlw[0].setColor(Color.CHI); hlw[0].setName("DaWa");
		hlw[1].setNum(2); hlw[1].setColor(Color.CHENG); hlw[1].setName("ErWa");
		hlw[2].setNum(3); hlw[2].setColor(Color.HONG); hlw[2].setName("SanWa");
		hlw[3].setNum(4); hlw[3].setColor(Color.LV); hlw[3].setName("SiWa");
		hlw[4].setNum(5); hlw[4].setColor(Color.QING); hlw[4].setName("WuWa");
		hlw[5].setNum(6); hlw[5].setColor(Color.LAN); hlw[5].setName("LiuWa");
		hlw[6].setNum(7); hlw[6].setColor(Color.ZI); hlw[6].setName("QiWa");
		
		
	}
	
	void bubbleSort() {
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6 - i; j++)
				if (queue.positions[j].holder.num > queue.positions[j + 1].holder.num)
					hlw[j].move(queue, j);
	}
	
	int partition(int left, int right) {
		int splitPoint = left;
		Position pivot;
		pivot = queue.positions[left];
		for (int i = left + 1; i <= right; i++)
			if (queue.positions[i].holder.color.ordinal() < pivot.holder.color.ordinal())
			{
				splitPoint ++;
				hlw[i].swap(queue, i, splitPoint);
			}
		hlw[left].swap(queue, left, splitPoint);
		return splitPoint;
	}
	
	void quickSort(int left, int right) {
		if (left < right) {
			int mid = partition(left, right);
			quickSort(left, mid - 1);
			quickSort(mid + 1, right);
		}
	}
	
	void printQueue() {
		for (int i = 0; i < 7; i++)
			System.out.print(queue.positions[i].holder.getName() + " ");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuluwaSort HlwSort = new HuluwaSort();
		
		HlwSort.queue.enqueue(HlwSort.hlw);
		System.out.println("随机站队后：");
		HlwSort.printQueue();
		System.out.println("");
		
		HlwSort.bubbleSort();
		System.out.println("冒泡排序后：");
		HlwSort.printQueue();
		System.out.println("");
		
		HlwSort.queue.enqueue(HlwSort.hlw);
		System.out.println("随机站队后：");
		HlwSort.printQueue();
		System.out.println("");
		
		HlwSort.quickSort(0, 6);
		System.out.println("快速排序后：");
		HlwSort.printQueue();
		System.out.println("");
	}

}
import java.util.*;

class Huluwa {
	int num;
	String name = new String();

	
	/*
	 * move方法为每个葫芦娃冒泡排序时的移动
	 * 参数array为葫芦娃的队列，pos为葫芦娃所在的位置
	 */
	void move (Huluwa []array, int pos) {
		if (array[pos].num > array[pos + 1].num) {
			System.out.println(array[pos].name + ": " + (pos + 1) + "->" + (pos + 2));
			System.out.println(array[pos + 1].name + ": " + (pos + 2) + "<-" + (pos + 1));
			Huluwa tmp = array[pos];
			array[pos] = array[pos + 1];
			array[pos + 1] = tmp;
		}
	}
	
	/*
	 * insert方法为每个葫芦娃通过二分插入到新队列的操作
	 * 参数array为葫芦娃原来所在的队列，tmp为插入的新临时队列，pos为葫芦娃原来的位置
	 */
	void insert (Huluwa []array, Huluwa []tmp, int pos) {
		if (pos == 0) {
			tmp[0] = array[0];
			System.out.println(tmp[0].name + " -> " + (pos + 1));
		}
		else {
			int left = 0;
			int right = pos - 1;
			int mid = (left + right) / 2;
			while (left <= right) {
				if (array[pos].num > tmp[mid].num) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
				mid = (left + right) / 2;
			}
			
			if (array[pos].num > tmp[mid].num) {
				for (int i = pos - 1; i > mid; i--) {
					System.out.println(tmp[i].name + ": " + (i + 1) + "->" + (i + 2));
					tmp[i + 1] = tmp[i];
				}
				System.out.println(array[pos].name + " -> " + (mid + 2));
				tmp[mid + 1] = array[pos];
			}
			else {
				for (int i = pos - 1; i >= mid; i--) {
					System.out.println(tmp[i].name + ": " + (i + 1) + "->" + (i + 2));
					tmp[i + 1] = tmp[i];
				}
				System.out.println(array[pos].name + " -> " + (mid + 1));
				tmp[mid] = array[pos];
			}
		}
	}
}

public class HuluwaSort {
	Huluwa []hlw = new Huluwa[7];
	Huluwa []tmp = new Huluwa[7];
	
	HuluwaSort() {
		for (int i = 0; i < 7; i++) {
			hlw[i] = new Huluwa();
			tmp[i] = new Huluwa();
		}
	}
	
	
	/*
	 * initHuluwa方法为对葫芦娃队列的初始化
	 */
	void initHuluwa() {
		hlw[0].name = "老大（红娃）";
		hlw[1].name = "老二（橙娃）";
		hlw[2].name = "老三（黄娃）";
		hlw[3].name = "老四（绿娃）";
		hlw[4].name = "老五(青娃）";
		hlw[5].name = "老六（蓝娃）";
		hlw[6].name = "老七（紫娃）";
		for (int i = 0; i < 7; i++)
			hlw[i].num = i;
	}
	
	/*
	 * ranPos方法为葫芦娃随机站队
	 */
	void ranPos() {
		Random rand = new Random();
		for (int i = 0; i < 7; i++) {	
			int p = rand.nextInt(i + 1);
			Huluwa tmp = hlw[i];
			hlw[i] = hlw[p];
			hlw[p] = tmp;
		}
	}
	
	/*
	 * bubbleSort方法让每个葫芦娃按照冒泡排序的方法移动
	 */
	void bubbleSort() {
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6 - i; j++)
				hlw[j].move(hlw, j);
	}
	
	/*
	 * insertSort方法让每个葫芦娃按照二分插入排序的方法插入新队列
	 */
	void insertSort() {
		for (int i = 0; i < 7; i++)
			hlw[i].insert(hlw, tmp, i);
		for (int i = 0; i < 7; i++)
			hlw[i] = tmp[i];
	}
	
	/*
	 *  printArray方法打印出队列的排序状态
	 */
	void printArray() {
		for (int i = 0; i < 7; i++)
			System.out.print(hlw[i].name + " ");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuluwaSort HlwSort = new HuluwaSort();
		
		HlwSort.initHuluwa();
		System.out.println("初始化为：");
		HlwSort.printArray();
		System.out.println("");
		
		HlwSort.ranPos();
		System.out.println("随机站队后：");
		HlwSort.printArray();
		System.out.println("");
		
		HlwSort.bubbleSort();
		System.out.println("冒泡排序后：");
		HlwSort.printArray();
		System.out.println("");
		
		HlwSort.ranPos();
		System.out.println("随机站队后：");
		HlwSort.printArray();
		System.out.println("");
		
		HlwSort.insertSort();
		System.out.println("二分插入排序后：");
		HlwSort.printArray();
		System.out.println("");
	}

}

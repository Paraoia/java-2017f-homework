import java.util.Random;

public class HuluQueue {
	Huluwa [] queue;
	public HuluQueue(Integer num) {
		queue =  new Huluwa[num];
	}
	
	
	// 在队列中插入葫芦娃
	public void addItem(Integer pos, Rank r, Color c) {
		if (pos < 0 || pos >= queue.length) {
			System.out.println("[ERROR] Out of bounds");
			System.exit(-1);
		}
		queue[pos] = new Huluwa(r, c);
	}
	
	// 将原始队列中的葫芦娃顺序打乱
	public void Shuttle() {
		Huluwa[] OoO = new Huluwa[queue.length];
		Integer Oidx = 0, ilimit = queue.length;
		Random rand = new Random();
		do {
			Integer rposition = rand.nextInt(ilimit--);
			Integer r = queue.length - Oidx;
			OoO[Oidx++] = queue[rposition];
			queue[rposition] = queue[r-1];
			
		} while (Oidx < queue.length);
		queue = OoO;
	}
	
	// 队列里按排名排序
	public void SortByRank() {
		for(int i = 0; i < queue.length; i ++){
			for(int j = 0; j < queue.length - i - 1; j ++){
				if (! queue[j].greaterRank(queue[j + 1])) {
					exchange(j, j+1);
				}
			}
		}
	}
	
	public void sortByColor() {
		int low, mid, high;
		int left = 0, right = queue.length - 1;
		Huluwa tmp;
		for(int i = left+1; i <= right; i++){
			tmp = queue[i];
			low = left;
			high = i - 1;
			while(low <= high){
				mid = (low + high)/2;
				if (!queue[i].greaterColor(queue[mid])) {
					low = mid + 1;
				}
				else {
					high = mid - 1;
				}
			}
			
			for (int j = i-1; j >= low; j--) {
				insert(j+1, j);
			}
			queue[low] = tmp;
			System.out.println(queue[i].getStrRank() + ": " + i + "->" + low);
		}
	}
	
	public void insert(int j, int i) {
		System.out.println(queue[i].getStrRank() + ": " + i + "->" + j);
		queue[j] = queue[i];
	}
	
	// 交换队列中某两顺序
	public void exchange(int i, int j) {
		Huluwa tmp;
		System.out.println(queue[i].getStrRank() + ": " + i + "->" + j);
		tmp = queue[i];
		queue[i] = queue[j];
		queue[j] = tmp;
	}
	
	// 整队列报序
	public void ReportRank() {
		for(int i = 0; i < queue.length; i ++){
			System.out.println(queue[i].getStrRank());
		}
	}
	
	public void ReportColor() {
		for(int i = 0; i < queue.length; i ++){
			System.out.println(queue[i].getStrColor());
		}
	}
	
	
	public static void main(String[] args) {
		HuluQueue queue = new HuluQueue(7);
		
		
		// 入队列
		queue.addItem(0, Rank.FIRST, Color.RED);
		queue.addItem(1, Rank.SECOND, Color.ORANCE);
		queue.addItem(2, Rank.THIRD, Color.YELLOW);
		queue.addItem(3, Rank.FOURTH, Color.GREEN);
		queue.addItem(4, Rank.FIFTH, Color.CYAN);
		queue.addItem(5, Rank.SIXTH, Color.BLUE);
		queue.addItem(6, Rank.SEVENTH, Color.PURPLE);
		
		// 顺序打乱
		queue.Shuttle();
		System.out.println("-------- 打乱后顺序 --------");
		queue.ReportRank();
		
		System.out.println("-------- 开始冒泡排序 --------");
		queue.SortByRank();
		
		System.out.println("-------- 排序后顺序 --------");
		queue.ReportRank();
		
		
		// 顺序打乱
		queue.Shuttle();
		System.out.println("-------- 打乱后顺序 --------");
		queue.ReportRank();
		
		System.out.println("-------- 开始二分排序 --------");
		queue.sortByColor();
		
		System.out.println("-------- 排序后顺序 --------");
		queue.ReportColor();
		
	}
	
}

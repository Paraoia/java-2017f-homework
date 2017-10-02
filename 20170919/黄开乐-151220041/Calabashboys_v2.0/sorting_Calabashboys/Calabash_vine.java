package sorting_Calabashboys;

//葫芦藤的类，用于放置葫芦娃和进行排序操作
public class Calabash_vine extends Calabash_boy {

private
	//一根藤上七个瓜
	Calabash_boy []Vine = new Calabash_boy[7];

	//将藤上的两个葫芦交换
	void Exchange_pos(int i, int j) {
		Calabash_boy temp = new Calabash_boy();
		temp = Vine[i];
		Vine[i] = Vine[j];
		Vine[j] = temp;
	}
	
public	
	//构造函数,将葫芦娃放置到葫芦藤对应的位置上
	Calabash_vine(){	
		Vine[0] = new Calabash_boy(Color.Red, 1);
		Vine[1] = new Calabash_boy(Color.Orange, 2);
		Vine[2] = new Calabash_boy(Color.Yellow, 3);
		Vine[3] = new Calabash_boy(Color.Green, 4);
		Vine[4] = new Calabash_boy(Color.Cyan, 5);
		Vine[5] = new Calabash_boy(Color.Blue, 6);
		Vine[6] = new Calabash_boy(Color.Purple, 7);
	}
	
	
	//排序前，将七个葫芦打乱
	void Before_sorting() {
		Vine[0].Set_color(Color.Cyan);
		Vine[1].Set_color(Color.Purple);	
		Vine[2].Set_color(Color.Orange);	
		Vine[3].Set_color(Color.Blue);	
		Vine[4].Set_color(Color.Red);	
		Vine[5].Set_color(Color.Green);	
		Vine[6].Set_color(Color.Yellow);	
		System.out.print("排序前:");
		Report_color_by_pos();
	}
	
	
	//葫芦藤上从左到右按颜色报数
	void Report_color_by_pos() {
		for(int i = 0;i < 7;i++) {
			System.out.print(Vine[i].Report_color_string());
			if(i < 6)
				System.out.print(", ");
		}
		System.out.println(" ");
	}
	
	
	//按排行冒泡排序
	void Bubble_sort_rank() {
		System.out.println("冒泡排序开始:");
		for(int i = 0;i < Vine.length-2;i++) {
			for(int j = Vine.length-1; j > i;j--) {
				if(Vine[j].Return_rank() < Vine[j-1].Return_rank()) {
					Exchange_pos(j, j-1);
					System.out.print(Vine[j-1].Report_rank_string() + ": " + (j+1) + "->" + j + ", ");
					System.out.print(Vine[j].Report_rank_string() + ": " + j + "->" + (j+1) + "  ;  ");
				}
			}
			System.out.println(" ");
		}
		System.out.println("冒泡排序结束");
	}
	
	
	//按颜色二分排序
	void TwoHalf_Sorting_color() {
		System.out.println("二分排序开始：");
		
		for(int i = 1;i < Vine.length;i++) {
			int first = 0;int last = i-1;
			
			while(first <= last) {
				int mid = (first+last)/2;
				if(Vine[mid].Return_col().ordinal() < Vine[i].Return_col().ordinal())
					first = mid+1;
				else
					last = mid-1;
			}
			//找到位置
			
			Calabash_boy temp = Vine[i];
			for(int j = i - 1;j > last;j--) {
				Vine[j+1] = Vine[j];
				System.out.print(Vine[j+1].Report_rank_string() + ": " + (j+1) + "->" + (j+2) + ", ");
			}
			Vine[last+1] = temp;
			//将其插入相应位置
			
			System.out.println(temp.Report_rank_string() + ": " + (i+1) + "->" + (last+2));
		}
		System.out.println("二分排序结束");
	}
}

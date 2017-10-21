public class Huluwa {
	public final static int NULL =0;
	public final static int Red =1;
	public final static int Orange =2;
	public final static int Yellow =3;
	public final static int Green =4;
	public final static int Cyan =5;
	public final static int Blue =6;
	public final static int Purple=7;
	
	Hulu []Hulu_list = new Hulu[7];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Huluwa Hulu_system = new Huluwa();
		Hulu_system.Before_sorting();
		Hulu_system.Bubble_sort_rank();
		System.out.print("冒泡排序结果:");
		Hulu_system.Report();
		System.out.println(" ");
		Hulu_system.Before_sorting();
		Hulu_system.TwoHalf_Sorting_color();
		System.out.print("二分排序结果:");
		Hulu_system.Report();
		
	}
	
	
	//构造函数
	Huluwa(){	
		Hulu_list[0] = new Hulu(Red, 1);
		Hulu_list[1] = new Hulu(Orange, 2);
		Hulu_list[2] = new Hulu(Yellow, 3);
		Hulu_list[3] = new Hulu(Green, 4);
		Hulu_list[4] = new Hulu(Cyan, 5);
		Hulu_list[5] = new Hulu(Blue, 6);
		Hulu_list[6] = new Hulu(Purple, 7);
	}
	
	
	//排序前打乱队形
	void Before_sorting() {
		Hulu_list[0].Set(Cyan, 5);
		Hulu_list[1].Set(Purple, 7);	
		Hulu_list[2].Set(Orange, 2);	
		Hulu_list[3].Set(Blue, 6);	
		Hulu_list[4].Set(Red, 1);	
		Hulu_list[5].Set(Green, 4);	
		Hulu_list[6].Set(Yellow, 3);	
		System.out.print("排序前:");
		Report();
	}
	
	
	//按颜色报数
	void Report() {
		for(int i = 0;i < 7;i++) {
			System.out.print(Hulu_list[i].Report_color_s());
			if(i < 6)
				System.out.print(", ");
		}
		System.out.println(" ");
	}
	
	
	//按排行冒泡排序
	void Bubble_sort_rank() {
		System.out.println("冒泡排序开始:");
		for(int i = 0;i < Hulu_list.length-2;i++) {
			for(int j = Hulu_list.length-1; j > i;j--) {
				if(Hulu_list[j].Report_rank() < Hulu_list[j-1].Report_rank()) {
					Hulu temp = Hulu_list[j];
					Hulu_list[j] = Hulu_list[j-1];
					Hulu_list[j-1] = temp;
					System.out.print(Hulu_list[j-1].Report_rank_s() + ": " + (j+1) + "->" + j + ", ");
					System.out.print(Hulu_list[j].Report_rank_s() + ": " + j + "->" + (j+1) + "  ;  ");
				}
			}
			System.out.println(" ");
		}
		System.out.println("冒泡排序结束");
	}
	
	
	//按颜色二分排序
	void TwoHalf_Sorting_color() {
		System.out.println("二分排序开始：");
		
		for(int i = 1;i < Hulu_list.length;i++) {
			int first = 0;int last = i-1;
			
			while(first <= last) {
				int mid = (first+last)/2;
				if(Hulu_list[mid].Report_col() < Hulu_list[i].Report_col())
					first = mid+1;
				else
					last = mid-1;
			}
			//找到位置
			
			Hulu temp = Hulu_list[i];
			for(int j = i - 1;j > last;j--) {
				Hulu_list[j+1] = Hulu_list[j];
				System.out.print(Hulu_list[j+1].Report_rank_s() + ": " + (j+1) + "->" + (j+2) + ", ");
			}
			Hulu_list[last+1] = temp;
			//将其插入相应位置
			
			System.out.println(temp.Report_rank_s() + ": " + (i+1) + "->" + (last+2));
		}
		System.out.println("二分排序结束");
	}
}

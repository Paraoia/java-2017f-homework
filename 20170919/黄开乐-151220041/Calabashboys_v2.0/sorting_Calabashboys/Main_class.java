package sorting_Calabashboys;

public class Main_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calabash_vine Calabashboy_sorting_system = new Calabash_vine();

		Calabashboy_sorting_system.Before_sorting();
		Calabashboy_sorting_system.Bubble_sort_rank();
		System.out.print("冒泡排序结果:");
		Calabashboy_sorting_system.Report_color_by_pos();
		System.out.println(" ");
		
		Calabashboy_sorting_system.Before_sorting();
		Calabashboy_sorting_system.TwoHalf_Sorting_color();
		System.out.print("二分排序结果:");
		Calabashboy_sorting_system.Report_color_by_pos();
		
		return;
	}

}

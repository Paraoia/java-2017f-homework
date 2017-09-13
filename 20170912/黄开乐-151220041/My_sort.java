public class My_sort {
	private static void Sel_sort(int []array) {
		for(int i = array.length-1;i >= 0;--i){
			int Max_idx = i, Max = array[i];
			for(int j = 0;j < i;j++){
				if(array[j] > Max){
					Max_idx = j; Max = array[j];
				}
			}
			if(Max_idx != i){
				array[Max_idx] = array[i];
				array[i] = Max;
			}
		}
	}
	public static void main(String[] args) {
		int array[] = {32,43,53,54,32,65,63,98,43,23};
		Sel_sort(array);
		System.out.println("选择排序结果:");
		for(int i : array)
			System.out.println(i);
	}
}

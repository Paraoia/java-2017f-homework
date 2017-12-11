package test;

public class sort{
	private static void Bubblesort(int []number) {
		for(int i = 0;i < number.length;++i) {
			for(int j = i;j < number.length;++j) {
				if(number[i] < number[j]) {
					int temp = number[i];
					number[i] = number[j];
					number[j] = temp;
				}
			}
		}
	}
	public static void main(String [] args)
	{
		int[] A=new int[]{12,11,9,20,33};
		System.out.println("从大到小排序");
		System.out.println("排序前：");
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
		Bubblesort(A);
		System.out.println("排序后：");
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
}

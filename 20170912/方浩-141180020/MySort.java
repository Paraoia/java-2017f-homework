/*
 * This is a bubble sorting algorithm
 * author fanghao
 */
public class MySort {

	public static void bubbleSort(int[] arrays)
	{
		int tmp;
		int len = arrays.length;
		for(int i = 0;i < len - 1;++i)
		{
			for(int j = i + 1;j < len;++j)
			{
				if(arrays[i] < arrays[j])
				{
					tmp = arrays[i];
					arrays[i] = arrays[j];
					arrays[j] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{3,4,7,0,9,2,1,6,5,8};
		bubbleSort(array);
		int len = array.length;
		for(int i = 0;i < len;++i)
		{
			System.out.println(array[i] + " ");
		}
	}

}

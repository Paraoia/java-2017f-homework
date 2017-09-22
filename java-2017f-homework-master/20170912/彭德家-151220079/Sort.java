
public class Sort {
	static int []num = new int[]{32,43,53,54,32,65,63,98,43,23};
	public static void sort_array()
	{
		int length = num.length;
		for(int i = 0;i < length - 1;i++)
		{
			int min = i;
			for(int j = i + 1;j < length;j++)
			{
				if(num[j] < num[min])
					min = j;
			}
			int temp = num[min];
			num[min] = num[i];
			num[i] = temp;
		}
	}
	public static  void main(String[]args)
	{
		sort_array();
		for(int i = 0;i < num.length;i++)
			System.out.println(num[i]);
	}
}


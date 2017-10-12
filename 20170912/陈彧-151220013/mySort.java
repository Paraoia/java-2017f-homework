public class mySort{
	public static void main(String[] args){
		//array of 10 numbers
		int numbers[] = new int[]{9,6,5,4,3,8,7,10,1,2};
		//selectSort
		for(int i = 0;i < numbers.length - 1;i++)
		{
			for(int j = i + 1;j < numbers.length;j++)
			{
				int temp;
				if(numbers[j] < numbers[i])
				{
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
			System.out.println(numbers[i]);
		}
		System.out.println(numbers[numbers.length - 1]);
	}
}

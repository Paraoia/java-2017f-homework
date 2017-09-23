public class Sort {
	public static void main(String[] args) {
		int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9 - i; j++)
				if (numbers[j] > numbers[j + 1]) {
					int tmp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = tmp;
				}
				
		for (int i = 0; i < 10; i++)
			System.out.print(numbers[i] + " ");
		System.out.print('\n');
	}
}
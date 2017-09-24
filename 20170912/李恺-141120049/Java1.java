
public class Java1 {
	public static void main(String[] args) {
		int arr[] = { 6, 3, 8, 5, 2, 4 };

		for (int i = 1; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
}
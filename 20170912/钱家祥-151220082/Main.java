import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] A = { 1,5,-6,4,0,7,11,14,58,100 };
		Arrays.sort(A);
		for (int i : A) {
			System.out.printf("%d ", i);
		}
	}
}
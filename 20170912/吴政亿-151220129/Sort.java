package test;
public class Sort{

	public static void main(String[] args) {
		int array[]=new int[] {7,5,0,6,3,9,8,1,2,4};
		System.out.println("before sort:");
		for(int i=0;i<array.length;i++)
			System.out.print(array[i] + " ");
		//Sort
		int temp = 0;
        for (int i = array.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (array[j + 1] < array[j]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println();
		System.out.println("after sort:");
		for(int i=0;i<array.length;i++)
			System.out.print(array[i] + " ");

	}

}

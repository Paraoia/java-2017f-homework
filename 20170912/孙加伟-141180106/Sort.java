package helloworld;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[]=new int[]{23,34,89,67,38,92,19,27,70};
	    int temp; // 用于交换的临时变量
	    int size = numbers.length; // 数组大小   
	    for (int i = 0; i < size - 1; i++) {   
	        for (int j = i + 1; j < size; j++) {   
	            if (numbers[i] > numbers[j]) { // 交换两数的位置   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	            }   
	        }   
	    }   
	    for(int i = 0;i < size; i++) {
		    System.out.println(numbers[i]);
	    }

	}

}

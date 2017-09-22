public class HelloWorld { 
	public static void main(String[] args) {
		int temp = 0;
		int numbers[] = new int[]{9,15,8,12,3,6,10,2,16,19};
		for (int i=0;i<numbers.length-1;i++){
			for (int j=0;j<numbers.length-1-i;j++){
				if (numbers[j] > numbers[j+1]){
				temp = numbers[j];
				numbers[j] = numbers[j+1];
				numbers[j+1] = temp;
				}

			}
		}
		
		for (int i=0;i<numbers.length;i++){
		System.out.println(numbers[i]+"");
		}
	}

	
    
}
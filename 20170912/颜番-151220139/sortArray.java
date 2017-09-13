public class sortArray{
	public static void main(String[] args) {
		int num[] = new int[]{2,3,1,9,7,4,8,5,6,11};
		
		for(int times = 1; times<num.length-1; times++){
			for(int index = 0; index<num.length-times-1; index++){
				if(num[index]>num[index+1]){
					int temp = num[index];
					num[index] = num[index+1];
					num[index+1] = temp;
				}
			}
		}

		for(int index = 0; index<num.length; index++)
			System.out.println(num[index]+";");

	}
}

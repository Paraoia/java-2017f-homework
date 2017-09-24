public class sort {
	public static void main(String[] args) {
        int numbers[] = new int[]{18,28,38,48,58,68,77,87,97,102};
        //gei ding shu zu
        for(int i=1; i< numbers.length; i++)
        {
        	for(int j=1;j< numbers.length - i; j++) {
                if(numbers[j] > numbers[j+1]) {
                        int temp = numbers[j];
        				numbers[j] = numbers[j+1];
        				numbers[j+1] = temp;
                }
        	}
        }
        for(int i=1; i< numbers.length; i++)
        	System.out.println(numbers[i]);
}

}

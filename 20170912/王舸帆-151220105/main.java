package test0;

public class main {
	/*
	  sort
	*/
	        public static void main(String[] args) {
	                //array of 10 numbers
	                int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
	                int ter=0;
	                for(int i=0; i< numbers.length-1; i++)
	                {
	                	  
	                	for(int j=0;j<numbers.length-i-1;j++){
	                		if(numbers[j] > numbers[j+1]){
	                			
	                                ter=numbers[j];
	                		        numbers[j]=numbers[j+1];
	                		        numbers[j+1]=ter;
	                		}
	                	}
	                }
	                for(int i=0;i<numbers.length;i++){
	                	System.out.println(numbers[i]);
	                }
	        }

}

public class Sort{
	public static void main(String[] args){
		int[] integers = {12,23,1,11,23,34,45};
		for(int i = 0;i < integers.length;i++){
			int loc = i;
			int min = integers[i];
			for(int j = i + 1;j < integers.length;j++)
				if(integers[j]<min){
					loc = j;
					min = integers[j];
				}
			if(loc!=i){
				int temp = integers[i];
				integers[i] = integers[loc];
				integers[loc] = temp;
			}
		}
		for(int i=0;i<integers.length;i++)
			System.out.print(integers[i] + " ");
	}
}

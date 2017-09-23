import java.util.Arrays;
public class SortArray{
	public static void main(String []args){
	int array[] = new int[]{32,43,53,54,32,65,63,98,43,23};
	int largerest = array[0];
	for(int i = 0; i < 9; i++){
		for(int j = i+1; j < 10; j++){
			if(array[j] > largerest)
				largerest = array[j];
		}
		int temp = array[i];
		array[i] = largerest;
		for(int k = i+1; k < 10; k++){
			if(array[k] == largerest)
				array[k] = temp;
		}
		largerest = array[i+1];
	}
	System.out.println(Arrays.toString(array));
}
}

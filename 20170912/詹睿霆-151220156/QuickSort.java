
public class QuickSort {

	public static void main(String []args){
		int[] a = {1,9,5,7,3,2,8,10,6,4};
		int start = 0;
		int end = a.length - 1;
		qsort(a,start,end);
		for(int i = 0; i<a.length; i++)
			System.out.println(a[i]);
    }
    
	public static void qsort(int[] a,int low,int high){
		if(low>=high)
			return;
		int i = low,j = high,pivot = a[low];
		while(i<j){
			while (i < j&&a[j]>=pivot)
				j--;
			a[i] = a[j];
			while (i < j &&a[i]<=pivot)
				i++;
			a[j] = a[i];
		}
		a[i] = pivot;
		qsort(a, low, i - 1);
		qsort(a, i + 1, high);
    }
}

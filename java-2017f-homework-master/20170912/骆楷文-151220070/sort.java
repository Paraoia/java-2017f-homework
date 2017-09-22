package test;

public class sort{
	public static void main(String [] args)
	{
		int[] A=new int[]{12,11,9,20,33};
		for (int i = 0; i < A.length; i++) {
			for (int  j= 0; j < A.length;j ++) {
				if(A[i]>A[j])
				{
					int a=A[i];
					A[i]=A[j];
					A[j]=a;
				}
			}
		}
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
}

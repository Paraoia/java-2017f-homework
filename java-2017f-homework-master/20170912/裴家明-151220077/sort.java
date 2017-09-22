package javaH1;

public class sort {
	public static void main(String [] args)
	{
		int [] A=new int[]{1,12,3,4,11,6,17,8,9};
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[i]<A[j])
				{
					int B=A[i];
					A[i]=A[j];
					A[j]=B;
				}
			}
		}
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i]+" ");
		System.out.println("");
	}
}

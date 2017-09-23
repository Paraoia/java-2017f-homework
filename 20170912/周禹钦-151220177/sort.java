/**
 * Created by qin on 17.9.12.
 */
/**
 * Created by qin on 17.7.19.
 */

import java.util.Scanner;

public class sort {
    public static void main(String[] args) {
        System.out.println("enter the number:");
        Scanner input=new Scanner(System.in);
        int number=input.nextInt();

        while(number!=-1) {
            int[] ARR=new int[number];
            System.out.println("input "+number+" number:");
            for (int i=0;i<number;i++)
                ARR[i]=input.nextInt();
            merge(0,number-1,ARR);
            for (int e:ARR)
                System.out.print(e+" ");
            System.out.println();
            System.out.println("enter the number:");
            number=input.nextInt();
        }
    }

    public static void merge(int start,int end,int[] a) {
        if (end-start<=1)
            sort(start,end,a);
        else {
            int mid=(start+end)/2;
            merge(start,mid,a);
            merge(mid+1,end,a);
            sort(start,mid,end,a);
        }
    }

    public static void sort(int start,int mid,int end,int[] AR) {
        int a=0,b=0,p=start;
        int []A=new int[mid-start+1];
        System.arraycopy(AR,start,A,0,mid-start+1);
        int []B=new int[end-mid];
        System.arraycopy(AR,mid+1,B,0,end-mid);

        while(a<=mid-start&&b<=end-mid-1) {
            if (A[a]<=B[b]) {
                AR[p]=A[a];
                p++;a++;
            }
            else {
                AR[p]=B[b];
                p++;b++;
            }
        }
        while (a<=mid-start) {
            AR[p]=A[a];
            p++;a++;
        }
        while (b<=end-mid-1) {
            AR[p]=B[b];
            p++;b++;
        }

    }

    public static void sort(int start,int end,int[] a) {
        if (a[start]<=a[end])
            return;
        else {
            int temp=a[end];
            a[end]=a[start];
            a[start]=temp;
        }
    }
}

//merge

//  if(e-s)>1
//      merge(s,m)
//      merge(m,e)
//      sort(s,m,e)

//  else

//sort(s,e)
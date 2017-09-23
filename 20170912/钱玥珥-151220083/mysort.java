import java.util.Scanner;
public class mysort {
    public static int partition(int []a,int p,int r) {
        int x = a[r],i=p-1,j=p;
        while(j<r) {
            if(a[j]<=x) {
                i=i+1;
                int m = a[i];
                a[i]=a[j];
                a[j]=m;
            }
            j++;
        }
        int m = a[i+1];
        a[i+1]=a[r];
        a[r]=m;
        return i+1;
    }
    public static void Quicksort(int []a,int p,int r) {
        if(p<r) {
            int q = partition(a,p,r);
            Quicksort(a,p,q-1);
            Quicksort(a,q+1,r);
        }
    }
    public static void main(String []args) {
        Scanner scan = new Scanner(System.in);
        int i=1,j=1;
        int []arr=new int [1024];
        while(scan.hasNextInt()) {
            arr[i]=scan.nextInt();
            i++;
        }
        Quicksort(arr,1,i-1);
        while(j<i) {
            System.out.print(arr[j]);
            System.out.print(' ');
            j++;
        }
        scan.close();
    }
}

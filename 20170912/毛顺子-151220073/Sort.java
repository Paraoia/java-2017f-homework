import java.util.Scanner;
public class Sort {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入整数个数：");
        int num=input.nextInt();
        int[] array=new int[num];
        for(int i=0;i<array.length;i++) {
            array[i]=input.nextInt();
        }
        for(int i=1;i<=array.length-1;i++) {
            for(int j=1;j<=array.length-1;j++) {
                if(array[j]<array[j-1]) {
                    int temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
        System.out.println("从小到大排序如下：");
        for(int i=0;i<array.length;i++) {
            System.out.println(array[i]);
        }
    }
}

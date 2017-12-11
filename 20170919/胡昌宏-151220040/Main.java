
public class Main {
	public static void main(String args[]){
       HuLuHole HuLu = new HuLuHole();
       System.out.println("任意排队：");
       HuLu.Random_Func();
       HuLu.Report_all_Rank();
       System.out.println("冒泡排序过程：");
       HuLu.BubbleSort();
       System.out.println();
       System.out.println("冒泡排序结果：");
       HuLu.Report_all_Rank();
       
       System.out.println("任意排队：");
       HuLu.Random_Func();
       HuLu.Report_all_Color();
       System.out.println("二分排序过程：");
       HuLu.QSort(0, 6);
       System.out.println();
       System.out.println("二分排序结果：");
       HuLu.Report_all_Color();
       return;
	}
}
 	
 	

public class Main
{
    public static void main(String[]args)
    {
        HuluwaBrothers huluwaBrothers = new HuluwaBrothers();
        huluwaBrothers.Initialize();
        /*冒泡排序*/
        System.out.println("第一次任意站队：");
        huluwaBrothers.LineUpRandomly();//任意站队
        System.out.print("\t报数：");
        huluwaBrothers.ReportNumbers(); //报数
        System.out.println("冒泡排序过程：");
        huluwaBrothers.BubbleSort();//冒泡排序
        System.out.println("冒泡排序后：");
        System.out.print("\t报数：");
        huluwaBrothers.ReportNumbers(); //报数
        System.out.println();

        /*快速排序*/
        System.out.println("第二次任意站队：");
        huluwaBrothers.LineUpRandomly();//任意站队
        System.out.print("\t报颜色：");
        huluwaBrothers.ReportColors(); //报颜色
        System.out.println("快速排序过程：");
        huluwaBrothers.QuickSort(0, 6); //快速排序
        System.out.println("快速排序后：");
        System.out.print("\t报颜色：");
        huluwaBrothers.ReportColors(); //报颜色
    }
}
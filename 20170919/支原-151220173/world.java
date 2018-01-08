public class world {
    public static void main(String []args)
    {
        HuluwaLine huluwaline=new HuluwaLine();
        //初始化队列
        huluwaline.initalize();
        //第一次冒泡排序
        huluwaline.randomline(); //随机站队
        huluwaline.bubblesort();//冒泡排序并输出排队过程
        huluwaline.reportName();//排好序后按照名字报数
        //第二次快速排序
        huluwaline.randomline(); //随机站队
        huluwaline.quicksort(0,6);//快速排序并输出排队过程
        huluwaline.reportColor();//排好序后按照颜色报数
    }
}

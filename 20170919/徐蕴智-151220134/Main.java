public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        //按冒泡法依照各自排行（从老大到老七）进行排序
        HuLuWa huluwa1[];
        huluwa1=new HuLuWa[7];
        //按二分法依照各自颜色（赤橙黄绿青蓝紫）进行排序
        HuLuWa huluwa2[];
        huluwa2=new HuLuWa[7];
        //接收数据
        Input get=new Input();
        //输出信息
        Output print=new Output();
        //排序
        Sort bubblesort=new Sort();
        Sort quicksort=new Sort();

        System.out.println("请随机输入排行的顺序:(例如:老二 老四 老六 老七 老五 老三 老大)");
        //接收随意站队的输入
        get.GetLine();
        //生成七个葫芦娃
        for(int i=0;i<7;i++){
            huluwa1[i]=new HuLuWa(get.rank[i]);
        }
        //冒泡
        bubblesort.BubbleSort(huluwa1,7);
        print.Print(huluwa1,7,1);

        System.out.println("请随机输入七种颜色的顺序:(例如:红色 蓝色 黄色 橙色 紫色 青色 绿色)");
        //再次接收随机站队的输入
        get.GetLine();
        //生成七个葫芦娃
        for(int i=0;i<7;i++){
            huluwa2[i]=new HuLuWa(get.rank[i]);
        }
        //快排
        quicksort.QuickSort(huluwa2,0,6);
        print.Print(huluwa2,7,2);
        //输出

    }


}

public class God{
    public static void main(String[] args){
//        HuluBaby x = new HuluBaby(1);
//        System.out.println(x.reportRank());
//        System.out.println(x.reportColor());
//        x.reportExchangePos(1, 2);
        Grandfather x=new Grandfather();
        System.out.println("初始顺序为：");
        x.reportPosRank();
        x.bubbleSort();
        x.resetPos();
        System.out.println("重置顺序为：");
        x.reportPosColor();
        System.out.println("重新变阵！按照颜色排序：");
        x.quickSort(0, 6);
        System.out.println("快速排序变阵结束，顺序为：");
        x.reportPosColor();
    }
}

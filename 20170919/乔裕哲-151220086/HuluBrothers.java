import java.util.ArrayList;
import java.util.Collections;

class HuluBrothers {

    private ArrayList <HuluWa> huluBrothers;//7个葫芦娃组成葫芦兄弟，葫芦兄弟来排序
    private int number;//葫芦娃的个数

    public HuluBrothers() {
        number = 7;
        huluBrothers = new ArrayList<HuluWa>();
        for(int i = 0; i < number; ++i)
            huluBrothers.add(new HuluWa(i));
    }

    //葫芦兄弟有几个
    public int getNumber(){
        return number;
    }

    //报名字
    public void printAllName(){
        for(HuluWa i : huluBrothers)
            System.out.print(i.toNameString() + " ");
        System.out.println();
    }

    //报颜色
    public void printAllColor() {
        for(HuluWa i : huluBrothers)
            System.out.print(i.toColorString() + " ");
        System.out.println();
    }

    //打乱
    public void shuffle () {
        Collections.shuffle(huluBrothers);
    }

    //交换两个葫芦娃
    private void swap(int i, int j) {
        if (i == j)
            return ;
        //报告交换情况
        System.out.println(huluBrothers.get(i).toNameString() + "：" + i + "->" + j + "， " +
        huluBrothers.get(j).toNameString() + "：" + j + "->" + i);
        HuluWa temp = huluBrothers.get(i);
        huluBrothers.set(i, huluBrothers.get(j));
        huluBrothers.set(j, temp);
    }

    //冒泡排序
    public void bubbleSort() {
        for (int i = 0; i < number; ++i)
            for (int j = 0; j < number - i - 1; ++j)
                if (huluBrothers.get(j).tellId() > huluBrothers.get(j + 1).tellId())
                    swap(j, j + 1);
    }

    //快速排序
    public void quickSort(int left, int right){
        if(left >= right)
            return ;
        int pivot = partition(left, right);
        this.quickSort(left, pivot - 1);
        this.quickSort(pivot + 1, right);
    }

    private int partition(int left, int right){
        //选择huluBrothers.get(right)作为pivot，从左开始遍历
        int pos = left - 1;
        for(int i = left; i < right; ++i)
            if(huluBrothers.get(i).tellId() < huluBrothers.get(right).tellId()){
                ++pos;
                swap(i, pos);
            }
        pos++;
        swap(right, pos);
        return pos;
    }
}


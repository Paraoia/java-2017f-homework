package HuluWaSort;

import java.util.ArrayList;

public class HuluWaSorter {

    private ArrayList<HuluWa> huluWaList;
    private HuluWaGeneralSorter sorter;

    public HuluWaSorter() {
        huluWaList = new ArrayList<>();
        //默认使用冒泡排序器
        sorter = new HuluWaBubbleSorter(huluWaList);
    }

    //排序器中增添一只葫芦娃
    public void addHuluWa(HuluWa huluWa){
        huluWaList.add(huluWa);
    }

    public void showHuluWasByOrder(){
        System.out.println("葫芦兄弟报排行：");
        for(HuluWa h : huluWaList){
            h.sayOrderName();
            System.out.print(" ");
        }
        System.out.println();
    }

    public void showHuluWasByColor(){
        System.out.println("葫芦兄弟报颜色：");
        for(HuluWa h : huluWaList){
            h.sayColorName();
            System.out.print(" ");
        }
        System.out.println();
    }

    //接下来的方法有关代理类Sorter

    //葫芦兄弟随意站队
    public void chaos(){
        System.out.println("葫芦兄弟进行随意站队！");
        sorter.chaos();
        System.out.println("葫芦兄弟随意站队完成！");
    }

    enum SorterType {BUBBLESORT, QUICKSORT}

    //设置代理类Sorter类型
    public void setSorter(SorterType sorterType){
        switch (sorterType){
            case BUBBLESORT: sorter = new HuluWaBubbleSorter(huluWaList);break;
            case QUICKSORT: sorter = new HuluWaQuickSorter(huluWaList);break;
            default:break;
        }
    }

    //使用代理类进行排序
    public void sort(){
        if(sorter == null){
            System.out.println("未指定排序器类型！未进行排序！");
            return;
        }
        sorter.sort();
    }
}





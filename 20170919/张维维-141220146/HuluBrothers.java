package com.need.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//葫芦兄弟类
public class HuluBrothers {
    private List<Huluwa> list;

    public HuluBrothers(){ list = new ArrayList<Huluwa>();}

    //葫芦兄弟挨个报名字
    public void AllSayName(HuluBrothers huluBrothers){
        for(int i=0; i<huluBrothers.list.size(); i++)
            huluBrothers.list.get(i).SayName();
        System.out.print("\n");
    }

    //葫芦兄弟挨个报颜色
    public void AllSayColor(HuluBrothers huluBrothers){
        for(int i=0; i<huluBrothers.list.size(); i++)
            huluBrothers.list.get(i).SayColor();
        System.out.print("\n");
    }

    //交换两个葫芦兄弟位置
    public void Swap(int i, int j){
        System.out.print(list.get(i).getName() + ": "
                + list.indexOf(list.get(i)) + "->"
                + list.indexOf(list.get(j)) + "\n");
        Huluwa temp = new Huluwa();
        temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    //葫芦兄弟冒泡排序
    public void BubbleSort(HuluBrothers huluBrothers){
        for(int i=0; i < huluBrothers.list.size(); i++){
            for(int j=0; j < huluBrothers.list.size()-i-1; j++)
                if(huluBrothers.list.get(j).getName().ordinal() > huluBrothers.list.get(j+1).getName().ordinal()){
                    huluBrothers.Swap(j, j+1);
            }
        }
    }

    //葫芦兄弟快速排序
    public void QuickSort(HuluBrothers huluBrothers, int left, int right){
        int i, j;
        if(left > right)
            return;
        i = left;
        j = right;
        while(i!=j){
            while(huluBrothers.list.get(j).getColor().ordinal() >= huluBrothers.list.get(left).getColor().ordinal() && i<j)
                j--;
            while(huluBrothers.list.get(i).getColor().ordinal() <= huluBrothers.list.get(left).getColor().ordinal() && i<j)
                i++;
            if(i<j){
                huluBrothers.Swap(i, j);
            }
        }
        if(left != i)
            huluBrothers.Swap(left, i);

        QuickSort(huluBrothers, left, i-1);
        QuickSort(huluBrothers, i+1, right);
    }

    public static void main(String[] args){
        Huluwa []hlws = new Huluwa[7];
        hlws[0] = new Huluwa(NAME.大娃,COLOR.红);
        hlws[1] = new Huluwa(NAME.二娃,COLOR.橙);
        hlws[2] = new Huluwa(NAME.三娃,COLOR.黄);
        hlws[3] = new Huluwa(NAME.四娃,COLOR.绿);
        hlws[4] = new Huluwa(NAME.五娃,COLOR.青);
        hlws[5] = new Huluwa(NAME.六娃,COLOR.蓝);
        hlws[6] = new Huluwa(NAME.七娃,COLOR.紫);

        HuluBrothers huluBrothers = new HuluBrothers();
        for(int i=0; i<7; i++)
            huluBrothers.list.add(hlws[i]);

        Collections.shuffle(huluBrothers.list);
        System.out.print("冒泡排序前： \n");
        huluBrothers.AllSayName(huluBrothers);
        huluBrothers.BubbleSort(huluBrothers);
        System.out.print("冒泡排序后： \n");
        huluBrothers.AllSayName(huluBrothers);
        Collections.shuffle(huluBrothers.list);
        System.out.print("快速排序前： \n");
        huluBrothers.AllSayName(huluBrothers);
        huluBrothers.QuickSort(huluBrothers, 0, 6);
        System.out.print("快速排序后： \n");
        huluBrothers.AllSayColor(huluBrothers);
    }
}


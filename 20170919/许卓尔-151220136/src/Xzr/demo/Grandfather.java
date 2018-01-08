package Xzr.demo;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.awt.geom.QuadCurve2D;

// 这是爷爷
public class Grandfather {
    public static void main(String args[]){

        // 爷爷拿到了葫芦娃的种子，种下了藤蔓
        Queue myCirrus = new Queue(CalabashDoll.allNum);

        // 爷爷把葫芦娃种了出来
        CalabashDoll[] calabashDolls= new CalabashDoll[CalabashDoll.allNum];
        for(int i=0;i<CalabashDoll.allNum;i++)
            calabashDolls[i] = new CalabashDoll();

        // 葫芦娃随机入队挂在藤上
        myCirrus.enqueue(calabashDolls);
        myCirrus.randomSort();

        // 葫芦娃冒泡排序
        new BubbleSorter().sort(myCirrus, new SeniorityComparable());
        myCirrus.countOff();

        // 葫芦娃随机站好
        myCirrus.randomSort();

        // 葫芦娃二分法排序
        new QuickSorter().sort(myCirrus, new ColorComparable());
        myCirrus.countOff();
    }
}

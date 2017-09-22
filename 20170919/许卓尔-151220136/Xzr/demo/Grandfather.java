package Xzr.demo;

// 这是爷爷
public class Grandfather {
    public static void main(String args[]){
        // 爷爷拿到了葫芦娃的种子，种下了藤蔓
        Cirrus myCirrus = new Cirrus();
        // 藤蔓生长，长出了七个随机排序的葫芦娃
        myCirrus.initialize();
        // 葫芦娃冒泡排序
        myCirrus.bubbleSort();
        // 葫芦娃随机站好
        myCirrus.randomSort();
        // 葫芦娃二分法排序
        myCirrus.quickSort();
    }
}

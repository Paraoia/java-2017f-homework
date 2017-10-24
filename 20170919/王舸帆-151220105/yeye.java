/**
 * Created by macbook on 2017/9/20.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class yeye {
    public static void main(String[] args) {
        List<huluwa> huluxd = new ArrayList<>();//huluxd:葫芦娃的数组
        huluxd.add(new huluwa(1, "老大", "红"));
        huluxd.add(new huluwa(2, "老二", "橙"));
        huluxd.add(new huluwa(3, "老三", "黄"));
        huluxd.add(new huluwa(4, "老四", "绿"));
        huluxd.add(new huluwa(5, "老五", "青"));
        huluxd.add(new huluwa(6, "老六", "蓝"));
        huluxd.add(new huluwa(7, "老七", "紫"));
        Collections.shuffle(huluxd);//随机站队
        //冒泡排序前报告位置
        for (int i = 0; i < huluxd.size(); i++) {
            huluxd.get(i).baogao1();
        }
        System.out.println("==============");
        yeye.b_sort(huluxd);//冒泡排序
        System.out.println("==============");
        //冒泡排序后报告位置
        for (int i = 0; i < huluxd.size(); i++) {
            huluxd.get(i).baogao1();
        }
        System.out.println("==============");
        Collections.shuffle(huluxd);//再次随机站队
        //快速排序前报告位置
        for (int i = 0; i < huluxd.size(); i++) {
            huluxd.get(i).baogao1();
        }
        System.out.println("==============");
        yeye.q_sort(huluxd,0,huluxd.size()-1);//快速排序
        //快速排序后报告位置
        System.out.println("==============");
        for (int i = 0; i < huluxd.size(); i++) {
            huluxd.get(i).baogao2();
        }

    }
    public static void swap(List<huluwa> huluwas, int i, int j) {
        huluwa a,b;
        a=huluwas.get(i);
        b=huluwas.get(j);
        huluwas.set(i,b);
        huluwas.set(j,a);
    }
    public static void b_sort(List<huluwa> huluxd1){
        for (int i = 0; i < huluxd1.size(); i++){
            for (int j = 0; j < huluxd1.size() - 1 - i; j++) {
                if (huluxd1.get(j).rank > huluxd1.get(j + 1).rank) {
                        swap(huluxd1,j,j + 1);
                        System.out.println(huluxd1.get(j+1).paihang + " : " + (j+1) + " -> " + (j+2));
                        System.out.println(huluxd1.get(j).paihang + " : " + (j+2) + " -> " + (j+1));
                }
            }
        }
    }
    public static void q_sort(List<huluwa> huluxd1,int h,int t){
            int i = h,j = t;
            while(i<j) {
                while(j>i && huluxd1.get(j).rank >= huluxd1.get(h).rank) j--;
                if(i<j) {
                    swap(huluxd1, i, j);
                    System.out.println(huluxd1.get(j).paihang + " : " + (j+1) + " -> " + (i+1));
                    System.out.println(huluxd1.get(i).paihang + " : " + (i+1) + " -> " + (j+1));
                    i++;
                }
                while(i<j && huluxd1.get(i).rank <= huluxd1.get(j).rank) i++;
                if(i<j) {
                    swap(huluxd1, i, j);
                    System.out.println(huluxd1.get(j).paihang + " : " + (j+1) + " -> " + (i+1));
                    System.out.println(huluxd1.get(i).paihang + " : " + (i+1) + " -> " + (j+1));
                    j--;
                }
            }
            if(h<i-1) q_sort(huluxd1, h, i-1);
            if(i+1<t) q_sort(huluxd1, i+1, t);
    }
}




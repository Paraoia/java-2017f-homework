package Huluwa;

import com.sun.istack.internal.localization.NullLocalizable;

class huluwa {
    private int number;
    private int color;
    //int place;

    public huluwa(int Number,int Color){
        number = Number;
        color = Color;
    }

    public int Number(){
        return number;
    }
    public int Color(){
        return color;
    }
}

public class Sort {
    public static String Name(int number){
        String name = "0";
        if(number == 1)
            name = "老大";
        if(number == 2)
            name = "老二";
        if(number == 3)
            name = "老三";
        if(number == 4)
            name = "老四";
        if(number == 5)
            name = "老五";
        if(number == 6)
            name = "老六";
        if(number == 7)
            name = "老七";
        return name;
    }
    public static String COLOR(int color){
        String Color = "0";
        if(color == 1)
            Color = "红娃";
        if(color == 2)
            Color = "橙娃";
        if(color == 3)
            Color = "黄娃";
        if(color == 4)
            Color = "绿娃";
        if(color == 5)
            Color = "青娃";
        if(color == 6)
            Color = "蓝娃";
        if(color == 7)
            Color = "紫娃";
        return Color;
    }
    public static void bubblesort(huluwa []Queue){
        System.out.print("冒泡排序：\n");
        for (int i = 1; i < 7; i++) {
            int temp = i;
            for (int j = i+1; j <= 7; j++) {
                if(Queue[temp].Number() > Queue[j].Number())
                    temp = j;
            }
            int color = Queue[temp].Color();
            int number = Queue[temp].Number();
            Queue[temp] = Queue[i];
            Queue[i] = new huluwa(number,color);
            System.out.print(Name(Queue[i].Number())+":" + temp + "->"+ i);
            System.out.print(Name(Queue[temp].Number())+":" + i + "->"+ temp);
            System.out.print("\n");
        }
    }

    public static void BinaryInsertSort(huluwa[] Queue){
        System.out.print("二分排序：\n");
        int left = 1,right = 7;
        int low,middle,high;
        int temp;
        for(int i = left+1;i <= right;i++){
            System.out.print("i = "+ i+"\n");
            temp = Queue[i].Color();
            low = left;
            high = i - 1;
            while(low <= high){
                middle = (low + high)/2;
                if(temp < Queue[middle].Color())
                    high = middle - 1;
                else low = middle + 1;
            }
            int color = Queue[i].Color();
            int number = Queue[i].Number();
            for(int j = i - 1;j >= low;j--){
                //int color = Queue[j].Color();
                //int number = Queue[j].Number();
                Queue[j+1] = Queue[j];
                //Queue[i] = new huluwa(number,color);
                System.out.print(Name(Queue[j+1].Number())+":" + j + "->"+ (j+1)+"\n");
                //System.out.print(Name(Queue[j].Number()) + j + "->"+ i);
            }
            //System.out.print("\n");
            //Queue[low] = Queue[i];
            Queue[low] = new huluwa(number,color);
            System.out.print(Name(Queue[low].Number())+":" + i + "->"+ low+"\n");
        }
    }

    public static int partition(huluwa[] Queue,int low,int high){
        int pivot = Queue[low].Color();
        while(low < high){
            while(low < high && Queue[high].Color() >= pivot) --high;
            Queue[low] = Queue[high];
            if(low != high)
                System.out.print(Name(Queue[low].Number())+":"+high+"->"+low+"\n");
            while(low < high && Queue[low].Color() <= pivot) ++low;
            Queue[high] = Queue[low];
            if(high != low)
                System.out.print(Name(Queue[high].Number())+":"+low+"->"+high+"\n");
        }
        Queue[low] = new huluwa(pivot,pivot);
        return low;
    }
    public static void qsort(huluwa[] Queue,int low,int high){
        if (low < high) {
            int pivot = partition(Queue,low,high);
            qsort(Queue,low,pivot-1);
            qsort(Queue,pivot+1,high);
        }
    }
    public static void quicksort(huluwa[] Queue){
        System.out.print("快速排序：\n");
        qsort(Queue,1,7);
    }
    public static void initalize(huluwa[] Queue){
        int[] flag = new int[]{0,0,0,0,0,0,0,0};
        java.util.Random r = new java.util.Random();
        for(int i = 1;i <= 7;i++){
            int num =  r.nextInt(100) % 7 + 1;
            //if(num < 0) num = (-num) % 7 + 1;
            //System.out.print(num+"\n");
            while(flag[num] == 1) num = (num+1)%7 + 1;
            flag[num] = 1;
            Queue[num] = new huluwa(i,i);
        }
    }

    public static void show1(huluwa[] Queue){
        System.out.print("排序前：");
        for(int i = 1;i <= 7;i++){
            System.out.print(i+Name(Queue[i].Number())+"  ");
        }
        System.out.print("\n");
    }

    public static void show2(huluwa[] Queue){
        System.out.print("排序后：");
        for(int i = 1;i <= 7;i++){
            System.out.print(i+Name(Queue[i].Number())+ COLOR(Queue[i].Color())+"  ");
        }
        System.out.print("\n");
    }
    public static void main(String[] args){
        huluwa[] Queue = new huluwa[8];
        initalize(Queue);
        show1(Queue);
        bubblesort(Queue);
        show2(Queue);
        //System.out.print("\n");
        initalize(Queue);
        show1(Queue);
        BinaryInsertSort(Queue);
        quicksort(Queue);
        show2(Queue);
        initalize(Queue);
        show1(Queue);
        //BinaryInsertSort(Queue);
        quicksort(Queue);
        show2(Queue);
    }
}

//葫芦娃的爷爷：能够命令葫芦娃做事，比如打乱葫芦娃的顺序和让葫芦娃重新排序

import java.util.Random;

public class Grandpa {

    Boy[] ctn = new Boy[7];

    //用于查看当前葫芦娃的排序信息
    void show() {
        System.out.print("\n随机打乱顺序后: ");
        for (int i = 0; i < 7; i++) {
            ctn[i].tellRank();
        }
        System.out.print("\n");
    }

    //初始化
    void init() {
        //Boy ctn[] = new Boy[7];
        ctn[0] = new Boy(7, COLOR.PURPLE, 0, 0);
        ctn[1] = new Boy(6, COLOR.BLUE, 1, 1);
        ctn[2] = new Boy(5, COLOR.CYAN, 2, 2);
        ctn[3] = new Boy(4, COLOR.GREEN, 3, 3);
        ctn[4] = new Boy(3, COLOR.YELLOW, 4, 4);
        ctn[5] = new Boy(2, COLOR.ORANGE, 5, 5);
        ctn[6] = new Boy(1, COLOR.RED, 6, 6);
    }

    //随机打乱葫芦娃序列
    void disturb() {        //打乱
        boolean alhave[] = new boolean[7];
        for (int i = 0; i < 7; i++) {
            alhave[i] = false;
        }
        int count = 0;
        while (count <= 6) {
            Random r = new Random();
            int s = r.nextInt(7);
            //System.out.println(s);
            if (alhave[s] == false) {
                alhave[s] = true;
                ctn[count] = new Boy(s + 1, reduct(s + 1), count, count);
                //System.out.printf("新成员：位置%d，排行%d\n",count,s+1);
                count++;
            }
        }
    }

    //随机打乱序列需要的函数
    COLOR reduct(int num) {
        switch (num){
            case 1:return COLOR.RED;
            case 2:return COLOR.ORANGE;
            case 3:return COLOR.YELLOW;
            case 4:return COLOR.GREEN;
            case 5:return COLOR.CYAN;
            case 6:return COLOR.BLUE;
            case 7:return COLOR.PURPLE;
            default:return COLOR.RED;
        }
    }

    //按排行排序——冒泡排序
    void sortByRank() {
        System.out.print("按排行排序:\n");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6 - i; j++) {
                if (ctn[j].rank > ctn[j + 1].rank) {
                    Boy temp = ctn[j];
                    ctn[j] = ctn[j + 1];
                    ctn[j + 1] = temp;

                    ctn[j].changePos(j);
                    ctn[j + 1].changePos(j + 1);
                }
            }
        }
        for (int k = 0; k < 7; k++) {
            ctn[k].tellRank();
        }
    }

    //按颜色排序——二分排序
    void sortByColor() {
        System.out.print("按颜色排序:\n");
        int low, middle, high;
        Boy temp;
        for (int i = 0 + 1; i <= 6; i++) {
            temp = ctn[i];
            low = 0;
            high = i - 1;
            while (low <= high) {
                middle = (low + high) / 2;
                if (ctn[i].color.crank < ctn[middle].color.crank)
                    high = middle - 1;
                else
                    low = middle + 1;
            }

            for (int j = i - 1; j >= low; j--) {
                ctn[j + 1] = ctn[j];
                ctn[j + 1].changePos(j + 1);
            }
            ctn[low] = temp;
            ctn[low].changePos(low);
        }
        for (int k = 0; k < 7; k++) {
            ctn[k].tellColor();
        }
    }
}

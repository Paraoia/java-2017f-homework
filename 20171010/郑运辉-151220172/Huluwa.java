import java.util.Random;

public class Huluwa extends Soldier{
    //产生随机数
    static int[] Ramdom(int size){
        int len = size;

        if(size <0 || size > 7){
            return null;
        }

        //初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = 0; i < size; i++){
            source[i] = i;
        }

        int[] result = new int[size];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            index = Math.abs(rd.nextInt() % len--);
            result[i] = source[index];
            source[index] = source[len];
        }
        return result;
    }

    //构造函数
    public Huluwa(int row,int col,COLOR c){
        super(row,col);
        color=c;
        mark=MARK.values()[c.ordinal()];
        seiority=SEIORITY.values()[c.ordinal()];
        type=TYPE.葫芦兄弟;
    }

    private COLOR color;    //葫芦娃颜色
    private SEIORITY seiority;//葫芦娃的大小

}

enum COLOR{
    红, 橙, 黄, 绿, 蓝, 青, 紫
}

enum SEIORITY {
    一, 二, 三, 四, 五, 六, 七
}
package calabash;

import java.util.Random;

//基础类，包含颜色的枚举，随机数组生成和主函数
public class foundation {

    //七种颜色枚举
    //==================================================================
    public enum Color
    {
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        CYAN,
        BLUE,
        PURPLE;
    }
    //==================================================================
    //end




    //产生一组[0,bound-1]的无重复，随机排列的数组
    //==================================================================
    public static void randarray(int[] array, int bound) {
        Random a = new Random();
        boolean[] flagarray = new boolean[bound];
        for(int i=0;i<bound;i++)
        {
            flagarray[i]=false;
        }
        for(int i=0;i<bound;i++)
        {
            int r = a.nextInt(bound);
            while(flagarray[r])
            {
                r=a.nextInt(bound);
            }
            flagarray[r] = true;
            array[i] = r;
        }
    }
    //==================================================================
    //end





    //主函数
    //==================================================================
    public static void main(String[] args)
    {
        Vine v = new Vine();
        v.BubbleSort();
        v.tellNames();
        v.randsort();
        v.binarysort(0, 6);
        v.tellColor();
    }
    //==================================================================
    //end
}

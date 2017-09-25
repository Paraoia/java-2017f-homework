import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class GrandPa {

    //装葫芦的瓶子
    private List<HuLu> hulu;

    //构造一个爷爷
    GrandPa()
    {
        hulu = new ArrayList<>();
        for(int i = 0; i<7; i++)
        {
            //把葫芦娃装进去
            hulu.add(new HuLu(i, i));
        }
    }

    //葫芦们报排序
    public void TellRank()
    {
        for(HuLu x : hulu)
        {
            x.tellRank();
            System.out.println();
        }
    }

    //葫芦们报颜色
    public void TellColor()
    {
        for(HuLu x : hulu)
        {
            x.tellColor();
            System.out.println();
        }
    }

    //葫芦们报排序和颜色
    public void TellHuLu()
    {
        for(HuLu x : hulu)
        {
            x.tellRank();
            System.out.print("  ");
            x.tellColor();
            System.out.println();
        }
    }

    //随便排个队
    public void Shuffle()
    {
        System.out.println("Let's shuffle!");
        System.out.println("------------------------------------");
        Collections.shuffle(hulu);
        TellHuLu();        //排好后说出序列来
        System.out.println("------------------------------------");
    }


    //交换两个葫芦娃的位置，在排序中使用
    private void changePos(int i, int j)
    {

        if(i != j)
        {
            //让葫芦们说出来！
            hulu.get(i).tellRank();
            System.out.print(":" + i + "->"+ j);
            System.out.print("    ");
            hulu.get(j).tellRank();
            System.out.println(":" + j + "->"+ i);

            //交换!
            HuLu temp = new HuLu(hulu.get(i));
            hulu.set(i, hulu.get(j));
            hulu.set(j, temp);
        }
    }


    //冒泡排序
    public void BubbleSort()
    {
        System.out.println("Let's do BubbleSort!");
        System.out.println("------------------------------------");

        int length = hulu.size();
        for (int i = 0; i < length; i++)
        {
            for (int j = i; j < length; j++)
            {
                if (hulu.get(i).getRank() > hulu.get(j).getRank())
                {
                    //交换！
                    changePos(i, j);
                }
            }
        }

        //排好了 报个数
        TellRank();
        System.out.println("------------------------------------");
    }

    //快速排序
    public void QuickSort()
    {
        System.out.println("Let's do QuickSort!");
        System.out.println("------------------------------------");
        quickSort(0, hulu.size() -1);
        TellColor();
        System.out.println("------------------------------------");
    }

    private void quickSort(int begin, int end)
    {
        if(begin >= end)
            return;
        int p = partition(begin, end);
        quickSort(begin, p - 1);
        quickSort(p + 1, end);

    }

    private int partition(int begin, int end)
    {
        int first = hulu.get(begin).getColor();
        int i = begin, j = end;
        while (i < j)
        {
            while (hulu.get(i).getColor() <= first && i < end)
            {
                i++;
            }
            while (hulu.get(j).getColor() > first && j >= begin)
            {
                j--;
            }
            if (i < j)
            {
                changePos(i, j);
            }
        }
        if (j != begin)
        {
            changePos(j ,begin);
        }
        return j;
    }


    public static void main(String[] args)
    {
        GrandPa grandpa = new GrandPa();

        grandpa.Shuffle();

        grandpa.BubbleSort();

        grandpa.Shuffle();

        grandpa.QuickSort();

    }

}

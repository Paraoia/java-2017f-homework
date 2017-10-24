import java.util.*;


public class Vine {

    List<Calabash> Brothers;

    Vine()
    {
        Brothers=new ArrayList<Calabash>();

        Brothers.add(new Calabash(new String("老大"),new String("赤"),0,0));
        Brothers.add(new Calabash(new String("老二"),new String("橙"),1,1));
        Brothers.add(new Calabash(new String("老三"),new String("黄"),2,2));
        Brothers.add(new Calabash(new String("老四"),new String("绿"),3,3));
        Brothers.add(new Calabash(new String("老五"),new String("青"),4,4));
        Brothers.add(new Calabash(new String("老六"),new String("蓝"),5,5));
        Brothers.add(new Calabash(new String("老七"),new String("紫"),6,6));
    }


    void OutOfName()
    {
        for (Calabash a : Brothers)
        {
            a.MyName();
        }
        System.out.println();
    }

    void OutOfColor()
    {
        for (Calabash a : Brothers) {
            a.MyColor();
        }
        System.out.println();
    }

    void Disrupt()
    {
        System.out.println("-------out of order-------");
        Collections.shuffle(Brothers);
    }

    void swap(int i,int j)
    {
        Brothers.get(i).ChangePosition(j);
        Brothers.get(j).ChangePosition(i);
        Collections.swap(Brothers,i,j);
    }

    void BubbleSort()
    {
        System.out.println("-------Bubble Sort-------");
        for (int i=0;i<6;i++)
            for (int j=0;j<6-i;j++)
            {
                if (Brothers.get(j).Getrank()>Brothers.get(j+1).Getrank())
                {
                    swap(j,j+1);
                }
            }
    }

    int partion(int begin,int end)
    {
        int pivotIndex=begin;
        int pivot=Brothers.get(pivotIndex).Getrank();
        swap(pivotIndex,end);

        int big=begin-1;
        for (int small=begin;small<end;small++)
        {
            if (Brothers.get(small).Getrank()<pivot)
            {
                big++;
                swap(big,small);
            }
        }
        swap(big+1,end);
        return big+1;
    }

    void quicksort(int begin,int end)
    {
        if (begin<end)
        {
            int p=partion(begin,end);
            quicksort(begin,p-1);
            quicksort(p+1,end);
        }
    }

    void QuickSort()
    {
        System.out.println("-------Quick Sort-------");
        quicksort(0,Brothers.size()-1);
    }
}

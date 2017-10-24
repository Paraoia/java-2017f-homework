package huluwa;

import java.util.Random;

public class sort {

    public position[] positions=new position[7];
    //public new_huluwa[] bros;
    public int[] p=new int[7];
    public void set_random()
    {
        Random r=new Random();
        for(int i=0;i<7;i++)
        {
            int r1=r.nextInt(7)+1;
            int j=0;
            for(j=0;j<i;j++)
            {
                if(p[j]==r1)
                {
                    r1=r.nextInt(7)+1;
                    j=-1;
                }
            }
            p[i]=r1;
        }
    }


    public void init(new_huluwa[] bros)
    {
        for(int i=0;i<7;i++)
        {
            bros[i]=new new_huluwa();
            bros[i].Set_new_huluwa(i);
            positions[i]=new position(i+1);
        }
        for(int i=0;i<7;i++)
        {
            positions[i].holder=bros[p[i]];
        }
    }


    public void printfirst()
    {
        for(int i=0;i<7;i++)
        {
            System.out.println(positions[i].holder.rank);
            System.out.println(positions[i].holder.color);
        }
    }

    //冒泡排序
    public void bubblesort()
    {
        System.out.println("冒泡排序过程：");
        for(int i=1;i<7;i++)
        {
            for(int j=6;j>=i;j--)
            {
                if(positions[j-1].holder.rank>positions[j].holder.rank)
                {
                    new_huluwa temp=positions[j-1].holder;
                    positions[j-1].holder=positions[j].holder;
                    positions[j].holder=temp;
                    cout2(temp.rank,j,j-1);
                    cout2(positions[j].holder.rank,j-1,j);
                }
            }
        }
        System.out.println("冒泡排序结果：");
        //cout();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("------------------");
    }

    //输出排序过程
    public void cout2(int m,int first,int last)
    {
        switch(m)
        {
            case 1:System.out.println("老大"+":"+first+"->"+last);break;
            case 2:System.out.println("老二"+":"+first+"->"+last);break;
            case 3:System.out.println("老三"+":"+first+"->"+last);break;
            case 4:System.out.println("老四"+":"+first+"->"+last);break;
            case 5:System.out.println("老五"+":"+first+"->"+last);break;
            case 6:System.out.println("老六"+":"+first+"->"+last);break;
            case 7:System.out.println("老七"+":"+first+"->"+last);break;
        }
    }

    //快速排序
    public int Partition(int low,int high)
    {
        int pivotpos=low;
        new_huluwa pivot=positions[low].holder;
        for(int i=low+1;i<=high;i++)
        {
            if(positions[i].holder.rank<pivot.rank) {
                pivotpos++;
                if (pivotpos != i) {
                    new_huluwa temp = positions[pivotpos].holder;
                    positions[pivotpos].holder = positions[i].holder;
                    positions[i].holder = temp;
                    cout2(positions[pivotpos].holder.rank, pivotpos, i);
                    cout2(positions[i].holder.rank, i, pivotpos);
                }
            }
        }
        positions[low].holder=positions[pivotpos].holder;
        positions[pivotpos].holder=pivot;
        cout2(positions[low].holder.rank,low,pivotpos);
        cout2(positions[pivotpos].holder.rank,pivotpos,low);
        return pivotpos;
    }
    public void QuickSort(int left,int right)
    {
        if(left<right)
        {
            int pivotpos=Partition(left,right);
            QuickSort(left,pivotpos-1);
            QuickSort(pivotpos+1,right);
        }
    }
}

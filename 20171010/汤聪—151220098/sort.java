package huluwa;

import java.util.Random;

public class sort {

    public position[] positions=new position[7];
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
            bros[i]=new new_huluwa(i);
            positions[i]=new position();
        }
        for(int i=0;i<7;i++)
        {
            positions[i].newholder=bros[p[i]-1];
        }
    }


    public void printfirst()
    {
        for(int i=0;i<7;i++)
        {
            System.out.println(positions[i].newholder.name+positions[i].newholder.rank+positions[i].newholder.color);
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
                if(positions[j-1].newholder.rank>positions[j].newholder.rank)
                {
                    new_huluwa temp=positions[j-1].newholder;
                    positions[j-1].newholder=positions[j].newholder;
                    positions[j].newholder=temp;
                    cout2(temp.rank,j,j-1);
                    cout2(positions[j].newholder.rank,j-1,j);
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
        new_huluwa pivot=positions[low].newholder;
        for(int i=low+1;i<=high;i++)
        {
            if(positions[i].newholder.rank<pivot.rank) {
                pivotpos++;
                if (pivotpos != i) {
                    new_huluwa temp = positions[pivotpos].newholder;
                    positions[pivotpos].newholder = positions[i].newholder;
                    positions[i].newholder = temp;
                    cout2(positions[pivotpos].newholder.rank, pivotpos, i);
                    cout2(positions[i].newholder.rank, i, pivotpos);
                }
            }
        }
        positions[low].newholder=positions[pivotpos].newholder;
        positions[pivotpos].newholder=pivot;
        cout2(positions[low].newholder.rank,low,pivotpos);
        cout2(positions[pivotpos].newholder.rank,pivotpos,low);
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

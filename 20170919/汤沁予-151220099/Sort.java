class Position
{
    public Hulu holder;
    public int index;
}

public class Sort
{
    Position []positions;
    Hulu []huluwas;
    void initialize()
    {
        positions = new Position[7];
        huluwas = new Hulu[7];
        for(int i = 0;i<7;i++)
        {
            positions[i] = new Position();
            positions[i].holder = null;
            positions[i].index = i;
            huluwas[i] = new Hulu(i);
        }
    }
    void HonkByPosition(boolean choice)
    {
        for(int i = 0;i<positions.length;i++)
        {
            if(choice)
                positions[i].holder.HonkColor();
            else
                positions[i].holder.HonkRank();
        }
    }
    void RandomSeque()
    {
        positions[0].holder = huluwas[3];
        positions[1].holder = huluwas[1];
        positions[2].holder = huluwas[4];
        positions[3].holder = huluwas[6];
        positions[4].holder = huluwas[2];
        positions[5].holder = huluwas[5];
        positions[6].holder = huluwas[0];
    }
    void BubbleSort()
    {
        for(int i=positions.length-1; i>=0; i--)
        {
            for(int j=0;j<i;j++)
            {
                Hulu temp;
                if(positions[j].holder.Compare(positions[j+1].holder))
                {
                    temp = positions[j].holder;
                    positions[j].holder.MoveTo(j,j+1);
                    positions[j+1].holder.MoveTo(j+1,j);
                    positions[j].holder = positions[j+1].holder;
                    positions[j+1].holder = temp;
                }
            }
        }

    }
    void QuickSortWrap()
    {
        QuickSort(0, 6);
    }

    void QuickSort(int low, int high)
    {
        int PivotPost;//Pick the first key in the range as the pivot
        if (low<high)
        {
            PivotPost = Part(low, high);
            QuickSort(low, PivotPost-1);
            QuickSort(PivotPost + 1, high);
        }
    }

    int Part(int low, int high)
    {
        int vacant, unknown;
        Hulu pivot = positions[low].holder;
        vacant = low;
        for (unknown = low + 1; unknown <= high; unknown++)
        {
            //if (array[unknown] < pivot)
            if(positions[unknown].holder.Compare(pivot) == false)
            {
                positions[unknown].holder.MoveTo(unknown,vacant);
                positions[vacant].holder = positions[unknown].holder;
                if(unknown != vacant + 1)
                {
                    positions[vacant].holder.MoveTo(vacant + 1, unknown);
                    positions[unknown].holder = positions[vacant + 1].holder;
                }
                vacant++;
            }
        }
        positions[vacant].holder = pivot;
        return vacant;
    }

    public static void main(String[] args)
    {
        Sort sort = new Sort();
        sort.initialize();

        sort.RandomSeque();
        sort.BubbleSort();
        sort.HonkByPosition(false);//按照排行报数

        sort.RandomSeque();
        sort.QuickSortWrap();
        sort.HonkByPosition(true);//按颜色报数

    }
}

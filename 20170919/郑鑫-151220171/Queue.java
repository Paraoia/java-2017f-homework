import javax.print.attribute.standard.PrinterLocation;

enum SORT{
    QUICKSORT,BUBBLESORT;

}

public class Queue {

    private int totalPositionNum;
    private Huluwa[] HuluBrothers;//对于葫芦娃的引用
    private Position []pos;//每个位置也是一个对象,队列管理这些位置


    public Queue(int number, Huluwa[] newHuluBrothers)
    {
        totalPositionNum = number;
        HuluBrothers = new Huluwa[totalPositionNum];
        HuluBrothers = newHuluBrothers;

        pos = new Position[totalPositionNum];

        for(int i = 0 ; i < totalPositionNum; i++)
        {
            pos[i] = new Position(i);
        }

    }


    public void Sort(SORT sortCase,int type)
    {
        switch(sortCase)
        {
            case QUICKSORT:
                            QuickSort(0,totalPositionNum-1,type);
                            break;
            case BUBBLESORT:
                            BubbleSort(type);
                            break;
            default:break;
        }

    }

    void BubbleSort(int type)
    {
        for(int i = 0; i < 7; i++)
            for(int j = 0; j < 6 - i; j++)
            {
                if(pos[j].CompareWithValue(pos[j+1],type)) {
                    pos[j].LetPeopleSwapWithAnotherPos(pos[j+1]);
                }
            }
    }

    void QuickSort(int beginPos,int endPos,int type)
    {
        if(beginPos < endPos)
        {
            int q = Partition(beginPos,endPos,type);
            QuickSort(beginPos,q-1,type);
            QuickSort(q+1,endPos,type);
        }

    }

    int Partition(int beginPos,int endPos,int type)
    {

        int i = beginPos - 1;
        for(int j = beginPos;j < endPos;j++)
        {

            if(!pos[j].CompareWithValue(pos[endPos],type))
            {
                i++;
                if(j != i) {
                    pos[j].LetPeopleSwapWithAnotherPos(pos[i]);
                }
            }
        }

        if(i+1 != endPos)
            pos[i+1].LetPeopleSwapWithAnotherPos(pos[endPos]);

        return i+1;
    }

    public void CountOff(int type)
    {
        System.out.println();

        for(int i = 0;i < totalPositionNum;i++)
            pos[i].LetPeopleCountOff(type);

        System.out.println();

    }

    public void RandomStand()
    {

        for(int i = 0; i < totalPositionNum;i++) {

            int temp = HuluBrothers[i].getRandomNumber(totalPositionNum);

            while(!pos[temp].isEmpty())
            {
                temp = HuluBrothers[i].getRandomNumber(totalPositionNum);
            }
            pos[temp].SetPeople(HuluBrothers[i]);

        }

    }

    public void ClearPos()
    {
        for(int i = 0; i < totalPositionNum; i++)
        {
            pos[i].LetPeopleLeave();
        }
    }

}

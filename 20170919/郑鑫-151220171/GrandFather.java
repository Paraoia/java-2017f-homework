import org.omg.CORBA.INITIALIZE;

public class GrandFather {

    Huluwa[] HuluBrother;
    boolean[] isempty;
    int[] manInPos;

    public GrandFather(){
        initialize();
    }
    void initialize() {
        Huluwa daWa = new Huluwa(1, "老大", "红色",Huluwa.RED);
        Huluwa erWa = new Huluwa(2, "老二", "橙色",Huluwa.ORANGE);
        Huluwa sanWa = new Huluwa(3, "老三", "黄色",Huluwa.YELLOW);
        Huluwa siWa = new Huluwa(4, "老四", "绿色",Huluwa.GREEN);
        Huluwa wuWa = new Huluwa(5, "老五", "青色",Huluwa.QING);
        Huluwa liuWa = new Huluwa(6, "老六", "蓝色",Huluwa.BLUE);
        Huluwa qiWa = new Huluwa(7, "老七", "紫色",Huluwa.PURPLE);

        HuluBrother = new Huluwa[7];
        HuluBrother[0] = daWa;
        HuluBrother[1] = erWa;
        HuluBrother[2] = sanWa;
        HuluBrother[3] = siWa;
        HuluBrother[4] = wuWa;
        HuluBrother[5] = liuWa;
        HuluBrother[6] = qiWa;

        isempty = new boolean[7];
        manInPos = new int[7];
    }

    void ClearPos()
    {
        for(int i = 0; i < 7; i ++) {
            isempty[i] = true;
            manInPos[i] = 0;
        }
    }

    void RandomStand()
    {
        for(int i = 0; i < 7 ;i++) {

            int temp = HuluBrother[i].getRandomNumber();
            while(!isempty[temp])
            {
                temp = HuluBrother[i].getRandomNumber();
            }
            isempty[temp] = false;
            manInPos[temp] = i;
            HuluBrother[i].setPos(temp);
        }

    }


    void swapTwoHuluwa(int firstMan,int SecondMan,int firstPos,int SecondPos)
    {
        HuluBrother[firstMan].swapPos(firstPos,SecondPos);
        HuluBrother[SecondMan].swapPos(SecondPos,firstPos);
        manInPos[firstPos] = SecondMan;
        manInPos[SecondPos] = firstMan;


    }

    void BubbleSortInLevel()
    {
        for(int i = 0; i < 7; i++)
            for(int j = 0; j < 6 - i; j++)
            {
                int firstMan = manInPos[j];
                int SecondMan = manInPos[j + 1];
                if(HuluBrother[firstMan].level > HuluBrother[SecondMan].level)
                    swapTwoHuluwa(firstMan,SecondMan,j,j+1);
            }
    }

    void QuickSortInColor(int beginPos,int endPos)
    {
        if(beginPos < endPos)
        {
            int q = Partition(beginPos,endPos);
            QuickSortInColor(beginPos,q-1);
            QuickSortInColor(q+1,endPos);
        }

    }

    int Partition(int beginPos,int endPos)
    {
        int tempColor = HuluBrother[manInPos[endPos]].colorForSort;
        int i = beginPos - 1;
        for(int j = beginPos;j < endPos;j++)
        {
            if(HuluBrother[manInPos[j]].colorForSort < tempColor)
            {
                i++;
                if(j!=i)
                    swapTwoHuluwa(manInPos[i],manInPos[j],i,j);
            }
        }
        if(i+1 != endPos)
            swapTwoHuluwa(manInPos[i+1],manInPos[endPos],i+1,endPos);
        return i+1;
    }

    void CountOffByLevel()
    {
        System.out.print("\n");

        for(int i = 0; i < 7; i++)
            HuluBrother[manInPos[i]].countOff(Huluwa.NAME);

        System.out.print("\n");

    }

    void CountOffByColor()
    {
        System.out.print("\n");

        for(int i = 0; i < 7; i++)
            HuluBrother[manInPos[i]].countOff(Huluwa.COLOR);

        System.out.print("\n");


    }

    public void carryOut()
    {
        ClearPos();
        RandomStand();
        BubbleSortInLevel();
        CountOffByLevel();


        ClearPos();
        RandomStand();
        QuickSortInColor(0,6);
        CountOffByColor();


    }

}

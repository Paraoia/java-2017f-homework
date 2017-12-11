package calabashDollSort;

/*
* 此文件包含藤蔓类Cirrus
* Cirrus类包含葫芦娃类数组对象，数目为7
* Cirrus类包含位置初始化、冒泡排序、快速排序方法对葫芦娃进行排序
*/

public class Cirrus {
    private CalabashDoll[] Calabashdolls;

    Cirrus(){
        Calabashdolls = new CalabashDoll[7];
    }

    public void RandomSort(){
        Calabashdolls[0] = new CalabashDoll(6);
        Calabashdolls[1] = new CalabashDoll(5);
        Calabashdolls[2] = new CalabashDoll(4);
        Calabashdolls[3] = new CalabashDoll(7);
        Calabashdolls[4] = new CalabashDoll(3);
        Calabashdolls[5] = new CalabashDoll(1);
        Calabashdolls[6] = new CalabashDoll(2);
    }

    public void SayPos(){
        System.out.print("初始位置：");
        for(int i = 0;i < 7;i++)
            Calabashdolls[i].SayNumber();
        System.out.println("");
        System.out.print("初始颜色：");
        for(int i = 0;i < 7;i++)
            Calabashdolls[i].SayColor();
        System.out.println("");
    }

    public void BubbleSort(){
        System.out.println("冒泡排序：");
        for(int i = 0;i < 6;i++){
            for(int j = 0;j < 6;j++){
                if(Calabashdolls[j].getNumber() > Calabashdolls[j+1].getNumber()){
                    Calabashdolls[j].SayPosChange(j+1,j+2);
                    Calabashdolls[j+1].SayPosChange(j+2,j+1);
                    int temp = Calabashdolls[j].getNumber();
                    Calabashdolls[j] = new CalabashDoll(Calabashdolls[j+1].getNumber());
                    Calabashdolls[j+1] = new CalabashDoll(temp);

                }
            }
        }

        for(int i = 0;i < 7;i++)
            Calabashdolls[i].SayNumber();
    }

    private int split(int first,int last)
    {
        int splitpoint;
        splitpoint = first;
        for (int i = first + 1; i <= last; i++)
        {
            if (Calabashdolls[i].getNumber() < Calabashdolls[first].getNumber())
            {
                splitpoint++;
                if(splitpoint != i){
                    Calabashdolls[i].SayPosChange(i+1,splitpoint+1);
                    Calabashdolls[splitpoint].SayPosChange(splitpoint+1,i+1);
                    int temp = Calabashdolls[i].getNumber();
                    Calabashdolls[i] = new CalabashDoll(Calabashdolls[splitpoint].getNumber());
                    Calabashdolls[splitpoint] = new CalabashDoll(temp);
                }
            }
        }
        Calabashdolls[first].SayPosChange(first+1,splitpoint+1);
        Calabashdolls[splitpoint].SayPosChange(splitpoint+1,first+1);
        int temp = Calabashdolls[first].getNumber();
        Calabashdolls[first] = new CalabashDoll(Calabashdolls[splitpoint].getNumber());
        Calabashdolls[splitpoint] = new CalabashDoll(temp);
        return splitpoint;
    }

    public void QuickSort(int first, int last)
    {
        if (first < last)
        {
            int splitpoint;
            splitpoint = split(first, last);
            QuickSort(first, splitpoint - 1);
            QuickSort(splitpoint + 1, last);
        }
    }

    public void SayColor(){
        for(int i = 0;i < 7;i++)
            Calabashdolls[i].SayColor();
    }
}

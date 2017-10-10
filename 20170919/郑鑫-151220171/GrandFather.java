import org.omg.CORBA.INITIALIZE;

public class GrandFather {

    Huluwa[] HuluBrothers;
    Queue queue;

    //爷爷是一个管理员，管理葫芦娃和一个队列

    public GrandFather(){
        initialize();
    }

    void initialize() {

        //初始化葫芦娃
        Huluwa daWa = new Huluwa(1, "老大", "红色",Huluwa.RED);
        Huluwa erWa = new Huluwa(2, "老二", "橙色",Huluwa.ORANGE);
        Huluwa sanWa = new Huluwa(3, "老三", "黄色",Huluwa.YELLOW);
        Huluwa siWa = new Huluwa(4, "老四", "绿色",Huluwa.GREEN);
        Huluwa wuWa = new Huluwa(5, "老五", "青色",Huluwa.QING);
        Huluwa liuWa = new Huluwa(6, "老六", "蓝色",Huluwa.BLUE);
        Huluwa qiWa = new Huluwa(7, "老七", "紫色",Huluwa.PURPLE);

        HuluBrothers = new Huluwa[7];
        HuluBrothers[0] = daWa;
        HuluBrothers[1] = erWa;
        HuluBrothers[2] = sanWa;
        HuluBrothers[3] = siWa;
        HuluBrothers[4] = wuWa;
        HuluBrothers[5] = liuWa;
        HuluBrothers[6] = qiWa;

    }

    public void LineUp()
    {
        //将葫芦娃排队

        //初始化队列
        queue = new Queue(7,HuluBrothers);

        queue.ClearPos();
        queue.RandomStand();
        queue.Sort(SORT.BUBBLESORT,Huluwa.LEVEL);
        queue.CountOff(Huluwa.NAME);

        queue.ClearPos();
        queue.RandomStand();
        queue.Sort(SORT.QUICKSORT,Huluwa.COLOR);
        queue.CountOff(Huluwa.COLOR);
    }

}

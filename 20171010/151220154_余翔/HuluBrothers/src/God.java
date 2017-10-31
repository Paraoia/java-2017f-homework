import creatures.*;
import formations.*;
import maps.*;
import maps.queues.MapQueue;
import sorters.*;

public class God {
    public static void main(String[] args){

        System.out.print("初始化\n");

        Map map = new Map(30);
        MapQueue HuluQueue = new MapQueue();
        MapQueue EvilQueue = new MapQueue();

        GrandPa Yeye = new GrandPa();
        Evil Shejing = new Evil(EVILNAME.蛇精);

        for(int i=0;i<=6;i++){
            HuluQueue.AddToMapQueue(new Huluwa(COLOR.values()[i],SENIORITY.values()[i]),map.getPositions()[i][0]);
        }

        for(int i=0; i<=10; i++){
            if(i==0)
                EvilQueue.AddToMapQueue(new Evil(EVILNAME.蝎子精),map.getPositions()[i][1]);
            else
                EvilQueue.AddToMapQueue(new Evil((EVILNAME.蛤蟆怪)),map.getPositions()[i][1]);
        }

        //打印
        map.paintMap();

        System.out.print("长蛇阵 vs 鱼鲮阵\n");

        //葫芦娃排序
        Sorter sorter = new QuickSorter();
        sorter.sort(HuluQueue);

        //布阵
        Arrange Changshe = new ChangSheFormation(HuluQueue.getCreatures());
        Changshe.setFormation(map,14,0);
        Arrange YuLing = new YuLingFormation(EvilQueue.getCreatures());
        YuLing.setFormation(map, 14, 14);

        //啦啦队
        Yeye.setTwoDimPosition(map.getPositions()[14][10]);
        Shejing.setTwoDimPosition(map.getPositions()[20][10]);

        //打印
        map.paintMap();

        System.out.print("变换阵型\n");
        YuLing.delFormation();
        Arrange Heyi = new HeYiFormation(EvilQueue.getCreatures());
        Heyi.setFormation(map,14,14);

        //打印
        map.paintMap();
    }
}

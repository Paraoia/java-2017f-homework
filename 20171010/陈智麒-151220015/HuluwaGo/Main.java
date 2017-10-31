package HuluwaGo;

public class Main {
    public static void main(String args[]){

        //上帝创建一个15x15的二维空间
        Map map = new Map(15);

        //上帝创建7只葫芦娃
        Creature[] huluwas = new Creature[7];
        for (int i = 0; i < 7; i++) {
            huluwas[i] = new Huluwa(Huluwa.Color.values()[i], Huluwa.Order.values()[i]);
        }

        //这七只葫芦娃按照长蛇队形排列，队头放在坐标（8,1）处
        Queue huluwaQueue = new Queue(huluwas, Queue.QueueType.长蛇, new Position(10,1));
        huluwaQueue.chaos();
        huluwaQueue.setSorter(new QuickSorter());
        huluwaQueue.sort();

        //创建蝎子精和若干小喽啰,总共10人的队伍
        Creature[] enermies = new Creature[10];
        enermies[0] = new Xiezijing();
        for (int i = 1; i < 10; i++) {
            enermies[i] = new Xiaolouluo();
        }

        //按照鱼鳞队形排列，队头放在坐标（10,10）处
        Queue enermyQueue = new Queue(enermies, Queue.QueueType.鱼鳞, new Position(10, 10));

        //将葫芦娃阵营和蝎子精阵营放置于二维空间中
        map.putQueue(huluwaQueue);
        map.putQueue(enermyQueue);

        //创建老爷爷和蛇精，放在(0,1)和(0,10)处，为各自阵营加油
        map.putCreature(new Grandpa(), new Position(0,1));
        map.putCreature(new Shejing(), new Position(0,10));

        map.show();

        System.out.println("蝎子精阵营变化到锋矢队形...");

        //上帝清空了二维空间
        map.dropAllQueue();

        //除了蝎子精阵营，上帝将其他东西按原样放到二维空间上
        map.putQueue(huluwaQueue);
        map.putCreature(new Grandpa(), new Position(0,1));
        map.putCreature(new Shejing(), new Position(0,10));

        //蝎子精阵营变化到锋矢队形，在此之前先征召两只小喽啰
        Creature[] newEnermies = new Creature[enermies.length + 2];
        System.arraycopy(enermies, 0, newEnermies, 0, enermies.length);
        newEnermies[enermies.length] = new Xiaolouluo();
        newEnermies[enermies.length + 1] = new Xiaolouluo();

        //新队形创建
        Queue newEnermyQueue = new Queue(newEnermies, Queue.QueueType.锋矢, new Position(12,10));

        //放入二维空间
        map.putQueue(newEnermyQueue);

        map.show();
    }

}

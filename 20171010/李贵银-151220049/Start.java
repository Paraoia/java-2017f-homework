public class Start {
    public static void main(String[] args){
        Space map=new Space();//生成一个N*N的二维空间
        Queue queue=new Queue();// 创建葫芦娃队伍
        Creature shejing=new Shejing("蛇精");
        Creature xiezijing=new Xiezijing("蝎精");
        Creature yeye=new Yeye("爷爷");
        Creature[] loulu=new Creature[20];
        for(int i=0;i<20;i++)
        {
            loulu[i]=new Loulu("喽啰");
        }
        queue.shuffle();
        System.out.println("乱序的葫芦娃队");
        queue.rollCall();
        System.out.println("排好序的葫芦娃队");
        new InsertionSorter().sort(queue);
        queue.rollCall();
        System.out.println("----------------第一次对峙---------------------------------");
        new Changeshe().Do(2,0,map,queue.getCreatures(),7);
        map.putCreature(xiezijing,5,8);
        new Heyi().Do(8,8,map,loulu,7);
        map.putCreature(yeye,1,0);
        map.putCreature(shejing,3,8);
        map.print();
        System.out.println("----------------第二次对峙---------------------------------");
        map.putCreature(xiezijing,6,8);
        map.putCreature(yeye,5,2);
        map.putCreature(shejing,5,8);
        map.updateCreature(loulu);
        new Henge().Do(7,8,map,loulu,14);
        map.print();
        System.out.println("----------------第三次对峙---------------------------------");
        map.updateCreature(loulu);
        new Fangyuan().Do(7,8,map,loulu,12);
        map.print();
    }
}

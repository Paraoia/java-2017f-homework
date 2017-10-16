public class Main
{
    public static void main(String[]args)
    {
        /*初始化*/
        Space space = new Space();
        HuluwaQueue huluwaqueue = new HuluwaQueue(); //葫芦娃
        ScorpionQueue scorpionqueue = new ScorpionQueue(); //蝎子精和喽啰
        Snake snake = new Snake(); //蛇精
        Oldman oldman = new Oldman(); //老爷爷
        /*葫芦娃先到，随机站队*/
        System.out.println("葫芦娃随机站队：");
        huluwaqueue.FormationChange(new LongSnakeForm(space)); //葫芦娃站成长蛇形
        huluwaqueue.LineUpRandomly();//初始乱序
        space.Output();
        /*葫芦娃排序*/
        new QuickSorter().sort(huluwaqueue);
        /*对峙局面1*/
        System.out.println("(排序后)对峙局面1：");
        scorpionqueue.FormationChange(new MoonForm(space)); //蝎子精和喽啰站成偃月形
        snake.setPosition(space.getPosition(2,6)); //蛇精给蝎子精加油
        oldman.setPosition(space.getPosition(5,1)); //老爷爷给葫芦娃加油
        space.Output();
        System.out.println();
        /*对峙局面2*/
        System.out.println("对峙局面2：");
        snake.leavePosition(); //蛇精让出地方
        oldman.leavePosition(); //老爷爷让出地方
        scorpionqueue.FormationChange(new SwordForm(space)); //蝎子精和喽啰变换队形成锋矢形
        snake.setPosition(space.getPosition(9,5)); //蛇精给蝎子精加油
        oldman.setPosition(space.getPosition(7,0)); //老爷爷给葫芦娃加油
        space.Output();

    }
}
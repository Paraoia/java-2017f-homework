public class God {
    public static void main(String[] args)
    {
        //Part 1
        Battle battle=new Battle();
        GoodCamp HuluwaCamp=new GoodCamp();
        BadCamp ScorptionCamp=new BadCamp();
        Snake snake=new Snake();
        Grandpa grandpa=new Grandpa();

        //part2
        Queue huluwaqueue=new LongSnake(battle);
        Queue scorptionqueue=new Crane(battle);
        HuluwaCamp.shuffle();
        HuluwaCamp.ChooseQueue(huluwaqueue);
        battle.show();
        new BubbleSorter().sort(HuluwaCamp);
        ScorptionCamp.ChooseQueue(scorptionqueue);
        battle.AddGrandpa(grandpa);
        battle.AddSnake(snake);
        battle.show();

        battle.clear();

        //part3
        HuluwaCamp.shuffle();
        HuluwaCamp.ChooseQueue(huluwaqueue);
        new BubbleSorter().sort(HuluwaCamp);
        scorptionqueue=new Arrow(battle);
        ScorptionCamp.ChooseQueue(scorptionqueue);
        battle.AddGrandpa(grandpa);
        battle.AddSnake(snake);
        battle.show();
    }
}

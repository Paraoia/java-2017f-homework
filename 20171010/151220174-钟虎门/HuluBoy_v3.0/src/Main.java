public class Main
{

    public static void main(String[] args)
    {
        World world=new World();
        world.InitWorld();
        //world.ShowWorld();
        Former former=new Former();
        former.SnakeFormer(world,Kind.HULU,1,2);
        //world.ShowWorld();
        former.ArrowFormer(world,Kind.MONSTER,1,7);
        //world.ShowWorld();
        former.CheerSquadFormer(world,Kind.GRANDPA,9,2);
        former.CheerSquadFormer(world,Kind.SNAKE,9,7);
        System.out.println("葫芦娃：蛇形阵；妖怪：锋矢阵");
        world.ShowWorld();
        former.SnakeFormer(world,Kind.MONSTER,1,7);
        former.CheerSquadFormer(world,Kind.GRANDPA,9,2);
        former.CheerSquadFormer(world,Kind.SNAKE,9,7);
        System.out.println("葫芦娃：蛇形阵；妖怪：蛇形阵");
        world.ShowWorld();
    }
}

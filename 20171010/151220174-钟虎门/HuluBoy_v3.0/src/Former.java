public class Former
{
    //将kind类生物在第x行第y列以蛇形阵排列
    void SnakeFormer(World world,Kind kind,int x,int y)
    {
        int row=world.ROW;
        int col=world.COL;
        switch (kind)
        {
            case HULU:
            {
                world.DeleteCreature(Kind.HULU);
                for (int i=x;i<x+7;i++)
                    world.positions[i][y].SetCreature(new HuluBoy(i-x));
            }break;
            case MONSTER:
            {
                world.DeleteCreature(Kind.MONSTER);
                world.positions[x][y].SetCreature(new Scorpion());
                for (int i=x+1;i<x+7;i++)
                    world.positions[i][y].SetCreature(new Bandit());
            }break;
            default:break;
        }
    }

    //将kind类型生物在第x行第y列以锋矢阵排列
    void ArrowFormer(World world,Kind kind,int x,int y)
    {
        int row=world.ROW;
        int col=world.COL;
        switch (kind)
        {
            case MONSTER://包括蝎子精和喽啰
            {
                for (int i=0;i<row;i++)
                {
                    for (int j=0;j<col;j++)
                    {
                        if (world.positions[i][j].GetCreature() instanceof Monster && !(world.positions[i][j].GetCreature() instanceof Snake))
                            world.positions[i][j].SetCreature(new Creature());
                    }
                }
                world.positions[x][y].SetCreature(new Scorpion());
                for (int i=x+1;i<x+7;i++)
                    world.positions[i][y].SetCreature(new Bandit());
                for (int i=1;i<=2;i++)
                {
                    world.positions[x+i][y+i].SetCreature(new Bandit());
                    world.positions[x+i][y-i].SetCreature(new Bandit());
                }
            }break;
        }
    }

    void CheerSquadFormer(World world,Kind kind,int x,int y)
    {
        world.DeleteCreature(kind);
        if (kind==Kind.GRANDPA)
            world.positions[x][y].SetCreature(new Grandpa());
        if (kind==Kind.SNAKE)
            world.positions[x][y].SetCreature(new Snake());
    }
}

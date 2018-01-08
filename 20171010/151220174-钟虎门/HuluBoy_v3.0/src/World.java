public class World
{
    public final int ROW=10;
    public final int COL=10;

    Position [][]positions;

    World()
    {
        positions=new Position[ROW][COL];
        for (int i=0;i<ROW;i++)
        {
            for (int j=0;j<COL;j++)
            {
                positions[i][j]=new Position();
            }
        }
    }

    void InitWorld()
    {
        /*
        for (int i=0;i<7;i++)
        {
            positions[i][COL/2].SetCreature(new HuluBoy(i));
        }
        */
    }

    void ShowWorld()
    {
        System.out.println("----------------------------------------");
        for (int i=0;i<ROW;i++)
        {
            System.out.print("|");
            for (int j=0;j<COL;j++)
            {
                positions[i][j].show();
            }
            System.out.println("|");
        }
        System.out.println("----------------------------------------");
    }

    void DeleteCreature(Kind kind)
    {


        for (int i=0;i<ROW;i++)
        {
            for (int j=0;j<COL;j++)
            {
                if(positions[i][j].GetCreature() instanceof HuluBoy && kind==Kind.HULU)
                    positions[i][j].SetCreature(new Creature());
                else if (positions[i][j].GetCreature() instanceof Monster && kind==Kind.MONSTER)
                    positions[i][j].SetCreature(new Creature());
                else if (positions[i][j].GetCreature() instanceof Grandpa && kind==Kind.GRANDPA)
                    positions[i][j].SetCreature(new Creature());
            }
        }
    }
}

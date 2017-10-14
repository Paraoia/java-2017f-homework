import java.util.ArrayList;
//战场类(2维空间)
public class Battlefield {

    final static int N = 15;


    private Position[][] positions;
    private Huluwa[] huluwas;
    private ScorpionMonster sm;
    private Grandpa yeye;
    private Servant[] servants;


    public Battlefield()
    {
        positions = new Position[N][];
        for(int i = 0; i < N; i++)
        {
            positions[i]=new Position[N];
            for(int j = 0; j < N; j++)
            {
                positions[i][j] = new Position(i,j);
            }
        }
    }

    public void addHuluwa(Huluwa[] huluwas)
    {
        this.huluwas = huluwas;
    }

    public void addBoss(ScorpionMonster boss)
    {
        this.sm = boss;
    }

    public void addGrandpa(Grandpa yeye)
    {
        this.yeye = yeye;
    }

    public void addServant(Servant[] servants)
    {
        this.servants = servants;
    }

    public void setBossAndYeYe()
    {
        sm.setPosition(positions[8][14]);
        yeye.setPosition(positions[8][0]);
    }

    public void setHuluwas()
    {
        Formation.setChangshe(huluwas, positions, 4 , 3);
    }
    public void setservants()
    {
        Formation.setYanxing(servants, positions, 4,8);
    }

    public void changeFormation(FORMATIONS f)
    {
        switch(f)
        {
            case HeYi:Formation.setHeyi(servants,positions,6,8);break;
            case ChongE:Formation.setChonge(servants,positions,4,8);break;
            case YanXing:Formation.setYanxing(servants,positions,4,8);break;
            default:
                System.out.println("阵型错误，没有这种操作");
        }
    }

    public void printBattleField()
    {
        for(int i=0;i < N;i++)
        {
            for(int j=0;j<N;j++)
            {
                creature c = positions[i][j].getHolder();
                if(c!=null)
                {
                    System.out.print(c.getName()+"    ");
                }
                else
                {
                    System.out.print("        ");
                }
            }
            System.out.println();
        }
    }
}

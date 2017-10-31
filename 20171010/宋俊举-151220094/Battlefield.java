import java.util.ArrayList;
//战场类(2维空间)
public class Battlefield {

    final static int N = 15;


    private Position[][] positions;
    private Huluwa[] huluwas;
    private ScorpionMonster sm;
    private Grandpa yeye;
    private Servant[] servants;
    private Snake snake;
    private creature[] arry;

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
    //将葫芦娃加入战场
    public void addHuluwa(Huluwa[] huluwas)
    {
        this.huluwas = huluwas;
    }
    //==============================================================

    public void addBoss(ScorpionMonster boss)
    {
        this.sm = boss;

    }

    //将蝎子精与小喽啰组合为一组
    public void setArry()
    {
        arry = new creature[servants.length + 1];
        for(int i=0;i<servants.length;i++)
        {
            arry[i] = servants[i];
        }
        arry[servants.length] = sm;
    }
    //==========================

    //往战场里加入爷爷
    public void addGrandpa(Grandpa yeye)
    {
        this.yeye = yeye;
    }
    //=======================================================


    //往战场里加入小喽啰
    public void addServant(Servant[] servants)
    {
        this.servants = servants;
    }
    //=======================================================


    //往战场里加入蛇精
    public void addSnake(Snake snake)
    {
        this.snake = snake;
    }
    //======================================================


    //设置蛇精与爷爷的位置
    public void setBossAndYeYe()
    {
        snake.setPosition(positions[8][14]);
        yeye.setPosition(positions[8][0]);
    }
    //====================================================



    //设置葫芦娃位置
    public void setHuluwas()
    {
        Formation.setChangshe(huluwas, positions, 4 , 3);
    }
    //====================================================



    //设置小喽啰和蝎子精的位置
    public void setservants()
    {
        Formation.setYanxing(arry, positions, 4,8);
    }
    //===================================================


    //改变阵型
    public void changeFormation(FORMATIONS f)
    {
        switch(f)
        {
            case HeYi:Formation.setHeyi(arry,positions,6,8);break;
            case ChongE:Formation.setChonge(arry,positions,4,8);break;
            case YanXing:Formation.setYanxing(arry,positions,4,8);break;
            default:
                System.out.println("阵型错误，没有这种操作");
        }
    }
    //===================================================


    //打印战场
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
    //======================================================
}

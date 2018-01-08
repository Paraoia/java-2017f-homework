package huluwa;

public class Space {
    public Position [][]positions;
    private int num;

    public Space(int n)
    {
        num = n;
        positions = new Position[n][];
        for(int i=0;i<n;i++)
        {
            positions[i]=new Position[n];
            for(int j=0;j<n;j++)
            {
                positions[i][j]= new Position();
                positions[i][j].setHolder(new Nothing());
            }
        }

    }
    private void reset()
    {
        for(int i=0;i<num;i++)
        {
            for(int j=0;j<num;j++)
            {
                positions[i][j].setHolder(new Nothing());
            }
        }
    }
    public void heyi()
    {
        HuluwaLineUp();
        GrandfatherStand();
        ScorpionHeyiLineUp();
        SnakeStandHeyi();
        report();
    }
    public void fang()
    {
        HuluwaLineUp();
        GrandfatherStand();
        ScorpionFangLineUp();
        SnakeStandFang();
        report();
    }
    public void function()
    {
        System.out.println("-----------阵型1----------\n");
        heyi();
        reset();
        System.out.println("-----------阵型2----------\n");
        fang();

    }
    public void report()
    {
        for(int i=0;i<num;i++)
        {
            for(int j=0;j<num;j++)
            {

                   positions[i][j].getHolder().print();
            }
            System.out.println();

        }
    }
    public void HuluwaLineUp()
    {
        Queue huluwaqueue = new Queue(7);
        new BubbleSort().sort(huluwaqueue);
      //  for(int i = num/2-3;i<=num/2+3;i++)
        //    positions[0][i] = huluwaqueue.getPositions()[i-(num/2-3)];
        huluwaqueue.sit(positions,num);

    }
    public void ScorpionHeyiLineUp()
    {
        HeYiFormation ht = new HeYiFormation(num,6);
        ht.StandInSpace(positions,4,0);
       // Scorpion st = new Scorpion();
        //st.SitWithXHeyi(positions,num,4,num/2);
    }
    public void ScorpionFangLineUp()
    {
        FangFormation ft = new FangFormation(num,7);
        ft.StandInSpace(positions,4,0);
       // Scorpion st = new Scorpion();
        //st.SitWithXFang(positions,num,3,num/2);
    }
    public void GrandfatherStand()
    {
        GrandFather gt= new GrandFather();
        gt.sit(positions[1][num/2]);
    }
    public void SnakeStandHeyi()
    {
        Snake st = new Snake();
        st.sit(positions[3][num/2]);
    }
    public void SnakeStandFang()
    {
        Snake st = new Snake();
        st.sit(positions[6][num/2]);
    }
}

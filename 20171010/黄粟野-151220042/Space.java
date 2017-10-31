public class Space
{
    final int N = 20;

    public Position [][]space;// = new Position[N][N];

    public Space()
    {
        Position p = new Position(-1,-1);
        space = new Position[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                space[i][j]=new Position(-1,-1);
                //space[i][j].setHolder(p.getHolder());
            }
        }
    }

    public void SetSpace(Huluwa[] brothers, Guys[] guys,Scorpion scorpion,Grangpa gp, Snake sp)
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                space[i][j]=new Position(-1,-1);
            }
        }
        for(int i=0;i< brothers.length;i++) {
            int a=brothers[i].getPosition().getX();
            int b=brothers[i].getPosition().getY();
            space[a][b] = new Position(a,b);
            space[a][b].setHolder(brothers[i].getPosition().getHolder());
        }

        for(int i=0;i< guys.length;i++) {
            int a=guys[i].getPosition().getX();
            int b=guys[i].getPosition().getY();
            space[a][b] = new Position(a,b);
            space[a][b].setHolder(guys[i].getPosition().getHolder());
        }

        space[scorpion.getPosition().getX()][scorpion.getPosition().getY()]=new Position(scorpion.getPosition().getX(),scorpion.getPosition().getY());
        space[scorpion.getPosition().getX()][scorpion.getPosition().getY()].setHolder(scorpion.getPosition().getHolder());

        space[gp.getPosition().getX()][gp.getPosition().getY()]=new Position(gp.getPosition().getX(),gp.getPosition().getY());
        space[gp.getPosition().getX()][gp.getPosition().getY()].setHolder(gp.getPosition().getHolder());

        space[sp.getPosition().getX()][sp.getPosition().getY()]=new Position(sp.getPosition().getX(),sp.getPosition().getY());
        space[sp.getPosition().getX()][sp.getPosition().getY()].setHolder(sp.getPosition().getHolder());


    }

    public void reportspace()
    {

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(space[i][j].getX()!=-1 )
                {
                    space[i][j].getHolder().report();
                }
            }
            System.out.println('\n');
        }
    }

    public static void main(String[] args) {

        //Creature [][]space = new Creature[N][N];

        Huluwa[] brothers = new Huluwa[7];
        Guys[] guys = new Guys[7];
        Scorpion scorpion = new Scorpion(guys);
        Grangpa gp = new Grangpa();
        Snake sp = new Snake();

        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new Huluwa(COLOR.values()[i], SENIORITY.values()[i]);
        }
        //System.out.println(brothers[0]);

        for (int i = 0; i < guys.length; i++) {
            guys[i] = new Guys(SENIORITY.values()[i]);
        }
       // System.out.println(guys.length);
        Queue queue = new Queue(brothers);
        scorpion.queuefirst(guys);
        Queueguys queueguys = new Queueguys(guys);

        Position gpp = new Position(0,9);
        Position spp = new Position(0,1);
        gp.setPosition(gpp);
        sp.setPosition(spp);


        
        Space space = new Space();
        space.SetSpace(brothers,guys,scorpion,gp,sp);
        //当前空间上的个点情况
        space.reportspace();
        System.out.println();

        //以人物为主体，对于其各自位置的报告
        queue.rollCall();
        queueguys.rollCall();
        scorpion.report();
        gp.report();
        sp.report();
        System.out.println();



        queueguys.shuffle(guys);
        space.SetSpace(brothers,guys,scorpion,gp,sp);
        space.reportspace();
        queue.rollCall();
        queueguys.rollCall();
        scorpion.report();
        gp.report();
        sp.report();
        System.out.println();


    }
}

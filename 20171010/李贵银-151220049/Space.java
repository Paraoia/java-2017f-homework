public class Space {
    private Position [][]p;
    private static final int N=30;
    Space()
    {
        p=new Position[N][N];
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
            {
                p[i][j]=new Position(i,j);
            }
    }
    public int getN()
    {
        return N;
    }
    public void print()
    {
        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                if (p[i][j].getHolder() == null)//位置上没有东西
                    System.out.print("     ");
                else
                    p[i][j].getHolder().report();
            }
            System.out.println();
        }
    }
    public void putCreature(Creature c,int x,int y)//将生物放在x,y上
    {
        if(x<0||x>=N||y<0||y>=N)
            return;
        if(c.getPosition()!=null)
            c.freePosition();//首先将生物离开原来的位置
        c.setPosition(p[x][y]);
    }
    public Creature getCreature(int x,int y)//在（x,y）上的生物
    {
        if(x<0||x>=N||y<0||y>=N)
            return null;
        return p[x][y].getHolder();

    }
    public void removeCreature(int x,int y)//将x,y上面的生物移开
    {
        if(x<0||x>=N||y<0||y>=N)
            return;
        if(p[x][y].getHolder()!=null)
            p[x][y].getHolder().freePosition();

    }
    public void updateCreature(Creature ...creatures)
    {
        for(int i=0;i<creatures.length;i++)
        {
           if(creatures[i].getPosition()!=null)
               creatures[i].freePosition();
        }
    }

}

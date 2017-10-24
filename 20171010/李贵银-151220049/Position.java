public class Position{
    private int x,y;
    private Creature holder;
    Position(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
    public void setHolder(Creature c)//位置上放入一个creature
    {
        this.holder=c;
    }
    public void  freeHolder()//从位置上离开原先的creature
    {
        holder=null;
    }
    public Creature getHolder()
    {
        return holder;
    }//获取位置上的东西
}

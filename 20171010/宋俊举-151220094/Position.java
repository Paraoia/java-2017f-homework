public class Position {

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }



    private int x;
    public int getx()
    {
        return x;
    }
    public void setx(int newx)
    {
        x = newx;
    }



    private int y;
    public int gety()
    {
        return y;
    }
    public void sety(int newy)
    {
        y = newy;
    }



    private creature holder;
    public creature getHolder()
    {
        return this.holder;
    }
    public void setHolder(creature newholder)
    {
        this.holder = newholder;
    }


}

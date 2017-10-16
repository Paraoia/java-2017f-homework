public class Position //队列位置类
{
    private int x, y;
    private Creature holder; //位置的占有者
    private boolean empty; //位置是否为空
    public Position(int x, int y)
    {
        super();
        this.x = x;
        this.y = y;
        empty = true;
    }
    public boolean ifEmpty()
    {
        return empty;
    }
    public int getX()
    {
        return x;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public int getY()
    {
        return y;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public void setHolder(Creature holder) //进入位置
    {
        this.holder = holder;
        empty = false;
    }
    public Creature out() //从位置离开
    {
        Creature holder = this.holder;
        this.holder = null;
        empty = true;
        return holder;
    }
    public Creature getHolder() //获得当前角色的引用
    {
        return this.holder;
    }
}
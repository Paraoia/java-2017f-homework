//小喽啰类
public class Servant implements creature{

    private String name;
    @Override
    public String getName()
    {
        return name;
    }

    public Servant(int i)
    {
        name = "小兵" + i;
    }

    private Position position;
    @Override
    public void setPosition(Position position)
    {
        if(this.position!=null)
            this.position.setHolder(null);
        this.position = position;
        position.setHolder(this);
    }

    @Override
    public Position getPosition()
    {
        return position;
    }

}

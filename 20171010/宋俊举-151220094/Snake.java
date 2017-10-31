
//蛇精类
public class Snake implements creature {
    private String name;
    private Position position;

    public Snake()
    {
        this.name = "蛇精";
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Position getPosition()
    {
        return position;
    }

    @Override
    public void setPosition(Position position)
    {
        if(this.position!=null)
            this.position.setHolder(null);
        this.position = position;
        position.setHolder(this);
    }


}

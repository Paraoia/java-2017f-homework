
//爷爷类
public class Grandpa implements creature {
    private String name;

    @Override
    public String getName()
    {
        return name;
    }


    private Position position;

    public Grandpa()
    {
        name = "爷爷";
    }

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

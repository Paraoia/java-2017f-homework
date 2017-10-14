public class ScorpionMonster implements creature {

    private String name;

    public ScorpionMonster()
    {
        name = "蝎子精";
    }
    @Override
    public String getName()
    {
        return name;
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

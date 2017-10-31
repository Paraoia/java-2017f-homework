public class Scorpion implements Creature
{
    private Position position;
    //Queueguys queueguy;

    public Scorpion(Guys[] guys)
    {
        position = new Position(0,0);
        //queueguy = new Queueguys(guys);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }

    @Override
    public void report() {
        System.out.print(this.toString());
        //queueguy.rollCall();
    }

    @Override
    public String toString(){
        return "蝎子精 @" + this.position.getX() + "," + this.position.getY() + ";";
    }

    public void queuefirst(Guys[] guys)
    {
        Position p = new Position(7,7);
        this.setPosition(p);

        //queueguy = new Queueguys(guys);

        //this.report();
        //queueguy.rollCall();
    }

    public void queuesecond(Guys[] guys)
    {
        Position p = new Position(3,3);
        this.setPosition(p);

        //queueguy = new Queueguys(guys,p);
        //queueguy.shuffle(guys,p);

        //this.report();
        //queueguy.rollCall();
    }
}

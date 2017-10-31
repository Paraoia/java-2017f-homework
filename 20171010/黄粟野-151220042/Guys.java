public class Guys implements Creature
{
    private Position position;
    private SENIORITY seniority;

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
    }

    @Override
    public String toString(){
        return "小喽啰" + this.seniority + "@" + this.position.getX() + "," + this.position.getY() + ";";
    }

    Guys(SENIORITY seiority) {
        this.seniority = seiority;
    }
}

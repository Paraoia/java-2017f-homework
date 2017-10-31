public class Yaoguai implements Creature {
    private EPITHET epithet;
    private Position position;

    public EPITHET getEpithet() {
        return epithet;
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

    Yaoguai(EPITHET epithet) {
        this.epithet = epithet;
        position = null;
    }

    @Override
    public void report() {
        System.out.print(this.toString());
    }

    @Override
    public String toString(){
        return this.epithet.toString();
    }
}

enum EPITHET{
    蝎子精, 喽啰
}
public class Monster implements Creature,Comparable {

    private M_RANK rank;
    private Position position;

    public M_RANK getRank() {
        return rank;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public Monster(){
        this.rank = M_RANK.喽;
        this.position = null;
    }

    public Monster(M_RANK rank){
        this.rank = rank;
        this.position = null;
    }

    @Override
    public void setPosition(Position position){
        this.position = position;
    }

    @Override
    public String toString(){
        return this.rank.toString();
    }

    @Override
    public void report(){
        System.out.print(this.toString());
    }

    @Override
    public boolean rank_biggerThan(Comparable another){
        if(another instanceof Monster)
            return this.getRank().ordinal() > ((Monster) another).getRank().ordinal();
        else
            return false;
    }

    @Override
    public void cleanPosition(){
        this.position = null;
    }
}

enum M_RANK{
    蛇, 蝎, 喽
}

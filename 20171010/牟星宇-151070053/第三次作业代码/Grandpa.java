public class Grandpa implements Creature,Comparable {

    private Position position;
    private String name;

    private Grandpa(){
        name = "爷";
    }

    private static final Grandpa grandpa = new Grandpa();

    public static Grandpa getGrandpa(){
        return grandpa;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position){
        this.position = position;
    }

    @Override
    public void report(){
        System.out.print(name);
    }

    @Override
    public boolean rank_biggerThan(Comparable another){
        return true;
    }

    @Override
    public void cleanPosition(){
        this.position = null;
    }
}

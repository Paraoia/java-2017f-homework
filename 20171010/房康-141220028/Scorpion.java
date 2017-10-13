public class Scorpion extends Creature {

    public Scorpion(){
        super();
    }

    @Override
    public String speak() {
        return "scorpion";
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Soldier){
            return 1;
        }else{
            return 0;
        }
    }
}

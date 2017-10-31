public class Soldier extends Creature {

    public Soldier(){
        super();
    }

    @Override
    public String speak() {
        return "soldier";
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Scorpion){
            return -1;
        }
        else{
            return 0;
        }
    }
}

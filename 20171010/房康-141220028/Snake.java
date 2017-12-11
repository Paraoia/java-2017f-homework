public class Snake extends Creature {

    public Snake(){
        super();
    }

    @Override
    public String speak() {
        return "Snake";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

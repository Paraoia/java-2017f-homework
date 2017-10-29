public class Snake extends Creature {
    @Override
    public String toString(){
        return "蛇精";
    }


    @Override
    public void act() {
        System.out.print(toString() + ":葫芦娃是我蛇精哒!   ");
    }
}

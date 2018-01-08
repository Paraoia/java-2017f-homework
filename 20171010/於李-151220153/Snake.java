public class Snake extends Creature {
    @Override
    public String toString(){
        return "\uD83D\uDC0D";
    }


    @Override
    public void act() {
        System.out.print(toString() + ":葫芦娃是我蛇精哒!   ");
    }
}

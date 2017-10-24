public class Snake extends Creature {
    Snake()
    {
        super();
        this.name=Name.SNAKE;
    }

    @Override
    public void report() {
        System.out.print("蛇精");
    }
}

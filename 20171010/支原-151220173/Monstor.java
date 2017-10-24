public class Monstor extends Creature {
    Monstor()
    {
        super();
        this.name=Name.MONSTOR;
    }

    @Override
    public void report() {
        System.out.print("啰啰");
    }
}

public class Minion extends Creature {
    @Override
    public void report() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "喽啰 @" + this.getPosition().toString();
    }
}

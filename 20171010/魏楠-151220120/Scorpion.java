public class Scorpion extends Creature {
    @Override
    public void report() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "蝎子精 @" + this.getPosition().toString();
    }
}

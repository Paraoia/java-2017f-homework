public class Huluwa_queue extends Queue{
    private int begin;
    public Huluwa_queue(Huluwa[] brothers) {
        begin=(N-brothers.length)/2;
        this.positions = new Position[brothers.length];

        this.creatures = brothers;

        for (int i = 0; i < brothers.length; i++) {

            this.positions[i] = new Position(i+begin,N/2+N/4);
            this.creatures[i].setPosition(this.positions[i]);
        }
    }
}

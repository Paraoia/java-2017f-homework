public class BudsAndScor_queue extends Queue{
    private int begin;
    public BudsAndScor_queue(Buddy[] buddies, Scorpion scor) {
        this.positions = new Position[buddies.length+1];
        this.creatures = new Creature[buddies.length+1];
        begin=(N-buddies.length)/2;
        this.creatures[0]=scor;
        for(int i=1;i<buddies.length+1;i++)
            this.creatures[i] = buddies[i-1];
        for (int i = 0; i <creatures.length; i++) {

            this.positions[i] = new Position(i+begin,N/2-i);
            this.creatures[i].setPosition(this.positions[i]);
        }
    }

    public void Heyi()
    {
        int i;
        for (i = 0; i < creatures.length/2+1; i++) {

            this.positions[i] = new Position(i+begin,N/2-i);
            this.creatures[i].setPosition(this.positions[i]);
        }
        for (int j = 0; j+i < creatures.length; j++) {

            this.positions[j+i] = new Position(i-j-2+begin,N/2-i-j);
            this.creatures[j+i].setPosition(this.positions[i+j]);
        }
    }
}

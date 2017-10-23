public class Queueguys {
    final int N = 20;

    private Position[] positions;

    public Position[] getPositions() {
        return positions;
    }

    public Creature[] getCreatures() {
        return creatures;
    }

    private Creature[] creatures;

    public Queueguys(Guys[] guys) {


        this.positions = new Position[guys.length];

        this.creatures = guys;

        for (int i = 0; i < guys.length; i++) {
           // if(i<p.getX()){
            this.positions[i] = new Position(i,i);
            this.creatures[i].setPosition(this.positions[i]);
            //}
        }
    }

    public void shuffle(Guys[] guys) {


        //this.positions = new Position[guys.length];

        //this.creatures = guys;

        for (int i = 0; i < guys.length/2+1; i++) {

            //if(i<=p.getX()) {
            this.positions[i] = new Position(i, i);
            this.creatures[i].setPosition(this.positions[i]);
            //}
        }
        //System.out.println(guys.length/2+1);
        for (int i = guys.length/2+1; i < guys.length; i++) {
            //if(i>=p.getX()) {
            this.positions[i] = new Position(i+1, guys.length - i );
            this.creatures[i].setPosition(this.positions[i]);
           // }
        }
    }

    public void rollCall() {
        for (Creature creature : this.creatures) {
            creature.report();
        }
        System.out.println();
        System.out.flush();

        for (Position position : this.positions) {

            position.getHolder().report();
        }

        System.out.println("\n");
        System.out.flush();
    }

}

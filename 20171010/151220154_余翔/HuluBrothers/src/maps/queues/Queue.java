package maps.queues;

import creatures.Creature;
import positions.Position;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Queue{

    private Position[] positions;

    public Position[] getPositions() {
        return positions;
    }

    public Creature[] getCreatures() {
        return creatures;
    }

    private Creature[] creatures;

    private int length;

    public Queue(){
        this.length = 0;
    }

    public Queue(Creature[] creatures) {

        this.positions = new Position[creatures.length];

        this.creatures = creatures;

        this.length = creatures.length;

        for (int i = 0; i < creatures.length; i++) {

            this.positions[i] = new Position(i);
            this.creatures[i].setPosition(this.positions[i]);
        }
    }

    public void AddToQueue(Creature creature){
        Creature[] ctemp = new Creature[this.length+1];
        Position[] ptemp = new Position[this.length+1];

        for(int i=0;i<=this.length-1;i++){
            ctemp[i] = this.creatures[i];
            ptemp[i] = this.positions[i];
            ctemp[i].setPosition(ptemp[i]);
        }
        ctemp[this.length] = creature;
        ptemp[this.length] = new Position(this.length);
        ctemp[this.length].setPosition(ptemp[this.length]);

        this.positions = new Position[this.length+1];
        this.creatures = new Creature[this.length+1];
        this.creatures = ctemp;
        this.positions = ptemp;

        this.length = this.length + 1;
    }

    public void shuffle() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = creatures.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Position position = creatures[index].getPosition();
            creatures[index].setPosition(creatures[i].getPosition());
            creatures[i].setPosition(position);
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setCreatures(Creature[] creatures) {
        this.creatures = creatures;
    }

    public void setPositions(Position[] positions) {
        this.positions = positions;
    }
}


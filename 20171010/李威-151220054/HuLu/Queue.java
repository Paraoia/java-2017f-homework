package HuLu;

import java.util.*;

public class Queue {
	
	private Creature[] creatures;
    private Position[] positions;
   
  
    public Creature[] getCreatures() {
        return creatures;
    }
    
    public Position[] getPositions() {
        return positions;
    }

    public Queue(Creature[] hulu) {

        this.positions = new Position[hulu.length];
        this.creatures = hulu;

        for (int i = 0; i < hulu.length; i++) {

            this.positions[i] = new Position(i);
            this.creatures[i].setPosition(this.positions[i]);
        }
    }

    
    public void messUp() {
        Random random= new Random();
        for (int i = 0; i < creatures.length; i++) {
        	
        	int j=Math.abs(random.nextInt())%creatures.length;
            Position position = creatures[j].getPosition();
            creatures[j].setPosition(creatures[i].getPosition());
            creatures[i].setPosition(position);
        }
    }

    
    public void queueShow() {
        for (int i=0;i<this.creatures.length;i++) {
            creatures[i].show();
        }
        System.out.println("\n");
    }

   
}
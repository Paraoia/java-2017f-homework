package maps.queues;

import creatures.Creature;
import positions.TwoDimPosition;

import java.util.Random;

public class MapQueue extends Queue{

    public void AddToMapQueue(Creature creature, TwoDimPosition twoDimPosition){
        if(twoDimPosition.isEmpty()!=true)
            throw new RuntimeException("The position is not available");
        this.AddToQueue(creature);
        creature.setTwoDimPosition(twoDimPosition);
    }

    public void shuffle(TwoDimPosition[][] twoDimPositions) {
        Random rnd = new Random();
        int time0 = twoDimPositions.length;
        int time1 = twoDimPositions.length-1;

        for (int i = 0; i <= this.getLength()-1; i++) {
            int index0 = Math.abs(rnd.nextInt(time0));
            int index1 = Math.abs(rnd.nextInt(time1));
            while(twoDimPositions[index0][index1].isEmpty()!=true){
                index0 = Math.abs(rnd.nextInt(time0));
                index1 = Math.abs(rnd.nextInt(time1));
            }
            this.getCreatures()[i].setTwoDimPosition(twoDimPositions[index0][index1]);
        }
    }
}

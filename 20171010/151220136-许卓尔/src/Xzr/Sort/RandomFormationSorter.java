package Xzr.Sort;

import Xzr.Creature.Creature;
import Xzr.Position.Pit;
import Xzr.Position.Position;
import Xzr.demo.Queue;

import java.util.List;
import java.util.Random;

public class RandomFormationSorter implements FormationSorter {

    @Override
    public void formation(Creature[] creatures, Queue queue, List<Position> formations){
        Pit[] pits = queue.getPits();
        Random random = new Random();
        for(int i=0;i<creatures.length;i++){
            int sel = random.nextInt(creatures.length-i);
            Creature creature = creatures[i];
            Position position = creatures[sel].getPosition();
            pits[creature.getPosition().index()].setHolder(creatures[sel]);
            pits[position.index()].setHolder(creature);
        }
    }
}

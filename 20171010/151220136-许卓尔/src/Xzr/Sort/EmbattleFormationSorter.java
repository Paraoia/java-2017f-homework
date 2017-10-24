package Xzr.Sort;

import Xzr.Creature.Creature;
import Xzr.Position.Pit;
import Xzr.Position.Position;
import Xzr.demo.Queue;

import java.util.List;

public class EmbattleFormationSorter implements FormationSorter {
    @Override
    public void formation(Creature[] creatures, Queue queue, List<Position> formations) {
        Pit[] pits = queue.getPits();
        for(int i=0; i<formations.size(); i++){
            if(i>=creatures.length)
                break;
            Position position = formations.get(i);
            Creature creature = creatures[i];
            pits[creature.getPosition().index()].setHolder(pits[position.index()].getHolder());
            pits[position.index()].setHolder(creature);
        }
    }
}

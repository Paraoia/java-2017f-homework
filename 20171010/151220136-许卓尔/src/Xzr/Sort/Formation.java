package Xzr.Sort;

import Xzr.Creature.Creature;
import Xzr.Position.*;
import Xzr.demo.Queue;

import java.util.List;

public class Formation {

    public void embattle(String formationName, Creature[] creatures, Queue queue){
        List<Position> formations = null;
        if((formations = new FormationImage(formationName,queue.getM(), queue.getN()).read()) == null){
            new RandomFormationSorter().formation(creatures, queue, null);
        }
        new EmbattleFormationSorter().formation(creatures, queue, formations);
    }
}

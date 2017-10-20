package Xzr.Sort;

import Xzr.Creature.Creature;
import Xzr.Position.Position;
import Xzr.demo.Queue;

import java.util.List;

public interface FormationSorter {
    public void formation(Creature[] creatures, Queue queue, List<Position> formations);
}

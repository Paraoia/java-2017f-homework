package Camp;
import Obj.Creature.Creature;
import Formation.Formation;
import Obj.CreatureImpl;
import Position.Position;
import Space.Space;
import mEnums.Direction;

import java.util.ArrayList;

public interface Camp {
    public void lineUp();

    public void addCreature(CreatureImpl creature);
    public void deleteCreature(CreatureImpl creature);
}

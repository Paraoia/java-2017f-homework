package Xzr.Field;

import Xzr.Creature.Creature;
import Xzr.Position.Position;

public interface BattleField {
    public void showField();
    public void enterField(Creature[] creatures);
    public void enterField(Creature[] creatures, Position[] positions);
    public void clearField();
}

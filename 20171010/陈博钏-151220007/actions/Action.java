package actions;

import creature.Creature;

import creature.GourdDolls;
import game.Map;

/**
 * Created by cbcwe on 2017/10/16.
 */

public interface Action {
    // start in (start_x, start_y)
    public void doAction(Map map, final int start_x, final int start_y, Creature... creatures);
    public void doAction(Map map, final int start_x, final int start_y, GourdDolls gourdDolls);
}

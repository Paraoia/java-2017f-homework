package actions;

import creature.Creature;
import creature.GourdDolls;
import game.Map;

/**
 * Created by cbcwe on 2017/10/20.
 */
public class Move implements Action{
    public void doAction(Map map, final int start_x, final int start_y, Creature... creatures){
        if( creatures.length != 1)
            return ;

        map.removeCreatureInXY(creatures[0].getX(), creatures[0].getY());
        creatures[0].moveTo(start_x, start_y);
        map.putCreatureInXY(creatures[0], start_x, start_y);
    }
    public void doAction(Map map, final int start_x, final int start_y, GourdDolls gourdDolls){
        // No need to implement
    }
}

package actions;

import creature.Creature;
import creature.GourdDolls;
import game.Map;

/**
 * Created by cbcwe on 2017/10/20.
 */
public class YanXing implements Action {
    public void doAction(Map map, final int start_x, final int start_y, Creature... creatures){
        if( creatures.length + start_x > map.LENGTH
                || creatures.length + start_y > map.LENGTH)
            return ;
        for(int i = 0 ; i < creatures.length ; ++ i){
            map.removeCreatureInXY(creatures[i].getX(),creatures[i].getY());
            creatures[i].moveTo(start_x + creatures.length - i - 1,start_y + i);
            map.putCreatureInXY(creatures[i],start_x + creatures.length - i - 1,start_y+i);
        }
    }

    public void doAction(Map map, final int start_x, final int start_y, GourdDolls gourdDolls){

    }
}

package actions;

import creature.Creature;
import creature.GourdDolls;
import game.Map;

/**
 * Created by cbcwe on 2017/10/20.
 */
public class ChangShe implements Action {
    public void doAction(Map map, final int start_x, final int start_y, Creature... creatures){
        if( creatures.length + start_x > map.LENGTH )
            return ;
        for(int i = 0 ; i < creatures.length ; ++ i){
            map.removeCreatureInXY(creatures[i].getX(),creatures[i].getY());
            creatures[i].moveTo(start_x+i,start_y);
            map.putCreatureInXY(creatures[i],start_x+i,start_y);
        }
    }
    public void doAction(Map map, final int start_x, final int start_y, GourdDolls gourdDolls){
        if( GourdDolls.NUM + start_x > map.LENGTH )
            return ;
        for(int i = 0 ; i < GourdDolls.NUM  ; ++ i){
            map.removeCreatureInXY(gourdDolls.getGourdDollX(i),gourdDolls.getGourdDollY(i));
            gourdDolls.moveTo(i,start_x+i,start_y);
            map.putCreatureInXY(gourdDolls.getGourdDoll(i),start_x+i,start_y);
        }
    }
}

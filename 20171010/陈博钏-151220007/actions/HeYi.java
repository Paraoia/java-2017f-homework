package actions;

import creature.Creature;
import creature.GourdDolls;
import game.Map;

/**
 * Created by cbcwe on 2017/10/20.
 */
public class HeYi implements Action {
    public void doAction(Map map, final int start_x, final int start_y, Creature... creatures){
        if( creatures.length % 2 == 0 ){
            if( creatures.length / 2 + start_x > map.LENGTH
                || creatures.length + start_y > map.LENGTH )
                return ;

            for(int i = 0 ; i < creatures.length ; ++ i){
                if( i < creatures.length / 2 ){
                    map.removeCreatureInXY(creatures[i].getX(),creatures[i].getY());
                    creatures[i].moveTo(start_x+i,start_y+i);
                    map.putCreatureInXY(creatures[i],start_x+i,start_y+i);
                }
                else{
                    map.removeCreatureInXY(creatures[i].getX(),creatures[i].getY());
                    creatures[i].moveTo(start_x+creatures.length - i - 1,start_y+i);
                    map.putCreatureInXY(creatures[i],start_x+creatures.length - i - 1,start_y+i);
                }
            }
        }
        else{
            if( (creatures.length+1) / 2 + start_x > map.LENGTH
                    || creatures.length + start_y > map.LENGTH )
                return ;

            for(int i = 0 ; i < creatures.length ; ++ i){
                if( i < creatures.length / 2 ){
                    map.removeCreatureInXY(creatures[i].getX(),creatures[i].getY());
                    creatures[i].moveTo(start_x+i,start_y+i);
                    map.putCreatureInXY(creatures[i],start_x+i,start_y+i);
                }
                else{
                    map.removeCreatureInXY(creatures[i].getX(),creatures[i].getY());
                    creatures[i].moveTo(start_x+creatures.length - i - 1,start_y+i);
                    map.putCreatureInXY(creatures[i],start_x+creatures.length - i - 1,start_y+i);
                }
            }
        }
    }

    public void doAction(Map map, final int start_x, final int start_y, GourdDolls gourdDolls) {

        if ((GourdDolls.NUM + 1) / 2 + start_x > map.LENGTH
                || GourdDolls.NUM + start_y > map.LENGTH)
            return;

        int i = 0;
        for ( i = 0; i < GourdDolls.NUM / 2; ++i) {
            map.removeCreatureInXY(gourdDolls.getGourdDollX(i), gourdDolls.getGourdDollY(i));
            gourdDolls.moveTo(i, start_x + i, start_y + i);
            map.putCreatureInXY(gourdDolls.getGourdDoll(i), start_x + i, start_y + i);
        }
        for( ; i < GourdDolls.NUM ; ++ i ){
            map.removeCreatureInXY(gourdDolls.getGourdDollX(i), gourdDolls.getGourdDollY(i));
            gourdDolls.moveTo(i,start_x +GourdDolls.NUM - i - 1,start_y+i);
            map.putCreatureInXY(gourdDolls.getGourdDoll(i), start_x + GourdDolls.NUM - i - 1, start_y + i);
        }
    }

}

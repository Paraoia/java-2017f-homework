/**
 * Created by Yuyang Wei on 2017/10/18.
 */
public class SnakeCheer implements Cheer{
    @Override
    public void cheer(Map map, Creature creature){
        System.out.println("");

        map.putMan(5,0,creature);
    }
}

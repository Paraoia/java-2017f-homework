package creature;

/**
 * Created by cbcwe on 2017/10/20.
 */
/* Singleton mode */
public class Snake extends Creature{
    private static Snake single = null;
    public String toString(){
        return "蛇精";
    }
    private Snake(){}
    public static Snake getSnake(){
        if(single == null)
            single = new Snake();
        return single;
    }
}

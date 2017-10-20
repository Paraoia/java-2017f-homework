package creature;

/**
 * Created by cbcwe on 2017/10/20.
 */
/* Singleton mode */
public class Scorpion extends Creature {
    private static Scorpion single = null;
    public String toString(){
        return "蝎精";
    }
    private Scorpion(){}
    public static Scorpion getSorpion(){
        if(single == null)
            single = new Scorpion();
        return single;
    }
}
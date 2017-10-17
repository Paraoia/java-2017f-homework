package creature;

/**
 * Created by cbcwe on 2017/10/16.
 */
public class Gourddoll extends Creature implements Comparable{
    public void reportName() {// report name with color
    }
    public boolean biggerThan(Comparable another){
        if (another instanceof  Gourddoll)
            // TODO
            return true;
        else
            return false;
    }
}

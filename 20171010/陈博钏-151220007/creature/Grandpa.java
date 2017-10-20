package creature;

/**
 * Created by cbcwe on 2017/10/20.
 */

/* Singleton mode */
public class Grandpa extends Creature{
    private Grandpa(){};

    public String toString(){
        return "爷爷";
    }

    private static Grandpa single = null;
    public static Grandpa getGrandpa(){
        if (single == null)
            single = new Grandpa();
        return single;
    }

    // For unit test
    public static void main(String[] args){
        Grandpa grandpa = new Grandpa();

        System.out.println(grandpa.getX());
        grandpa.setX(3);

    }
}

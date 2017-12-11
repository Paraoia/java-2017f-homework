import java.lang.invoke.CallSite;

public class CalabashBoy extends Creature implements Comparable{

    private CBCOLOR color;

    CalabashBoy(NAME givenname, CBCOLOR givencolor) {

        super(givenname);

        color = givencolor;

    }

    public CBCOLOR getcolor() { return color; }

    public boolean biggerthan(Comparable brother){

        if (brother instanceof  CalabashBoy)
            return this.getname().ordinal()> ((CalabashBoy) brother).getname().ordinal();
        else
            return false;
    }
}

enum CBCOLOR {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, PURPLE
}


package character.hero.Huluwas;

import character.hero.Huluwa;
import utils.HLW_COLOR;
import utils.HLW_SENIORITY;
import utils.coordinate._2Coordinate;

public class Sanwa extends Huluwa {
    static boolean DUPLICATED_LOCK = false;

    public Sanwa(_2Coordinate birthplace){
        super(birthplace);
        if(DUPLICATED_LOCK)
            throw null;
        DUPLICATED_LOCK = true;
    }

    @Override
    public String TellMyName() {
        return "三娃";
    }

    @Override
    public HLW_COLOR TellMyColor() {
        return HLW_COLOR.YELLOW;
    }

    @Override
    public HLW_SENIORITY TellMySeniority() {
        return HLW_SENIORITY.THIRD;
    }

    @Override
    protected void AfterMeetingBeings() {throw null;}
}

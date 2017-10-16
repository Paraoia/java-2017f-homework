package character.hero.Huluwas;

import character.hero.Huluwa;
import utils.HLW_COLOR;
import utils.HLW_SENIORITY;
import utils.coordinate._2Coordinate;

public class Wuwa extends Huluwa {
    static boolean DUPLICATED_LOCK = false;

    public Wuwa(_2Coordinate birthplace){
        super(birthplace);
        if(DUPLICATED_LOCK)
            throw null;
        DUPLICATED_LOCK = true;
    }

    @Override
    public String TellMyName() {
        return "五娃";
    }

    @Override
    public HLW_COLOR TellMyColor() {
        return HLW_COLOR.CYAN;
    }

    @Override
    public HLW_SENIORITY TellMySeniority() {
        return HLW_SENIORITY.FIFTH;
    }

    @Override
    protected void AfterMeetingBeings() {throw null;}
}

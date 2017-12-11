package character.hero.Huluwas;

import character.hero.Huluwa;
import utils.HLW_COLOR;
import utils.HLW_SENIORITY;
import utils.coordinate._2Coordinate;

public class Siwa extends Huluwa {
    static boolean DUPLICATED_LOCK = false;

    public Siwa(_2Coordinate birthplace){
        super(birthplace);
        if(DUPLICATED_LOCK)
            throw null;
        DUPLICATED_LOCK = true;
    }

    @Override
    public String TellMyName() {
        return "四娃";
    }

    @Override
    public HLW_COLOR TellMyColor() {
        return HLW_COLOR.GREEN;
    }

    @Override
    public HLW_SENIORITY TellMySeniority() {
        return HLW_SENIORITY.FOURTH;
    }

    @Override
    protected void AfterMeetingBeings() {throw null;}
}

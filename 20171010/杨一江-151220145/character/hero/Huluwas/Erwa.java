package character.hero.Huluwas;

import character.hero.Huluwa;
import utils.HLW_COLOR;
import utils.HLW_SENIORITY;
import utils.coordinate._2Coordinate;

public class Erwa extends Huluwa {
    static boolean DUPLICATED_LOCK = false;

    public Erwa(_2Coordinate birthplace){
        super(birthplace);
        if(DUPLICATED_LOCK)
            throw null;
        DUPLICATED_LOCK = true;
    }

    @Override
    public String TellMyName() {
        return "二娃";
    }

    @Override
    public HLW_COLOR TellMyColor() {
        return HLW_COLOR.ORANGE;
    }

    @Override
    public HLW_SENIORITY TellMySeniority() {
        return HLW_SENIORITY.SECOND;
    }

    @Override
    protected void AfterMeetingBeings() {throw null;}
}

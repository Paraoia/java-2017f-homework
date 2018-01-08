package character.hero.Huluwas;

import character.hero.Huluwa;
import utils.HLW_COLOR;
import utils.HLW_SENIORITY;
import utils.coordinate._2Coordinate;

public class Qiwa extends Huluwa {
    static boolean DUPLICATED_LOCK = false;

    public Qiwa(_2Coordinate birthplace){
        super(birthplace);
        if(DUPLICATED_LOCK)
            throw null;
        DUPLICATED_LOCK = true;
    }

    @Override
    public String TellMyName() {
        return "七娃";
    }

    @Override
    public HLW_COLOR TellMyColor() {
        return HLW_COLOR.VIOLET;
    }

    @Override
    public HLW_SENIORITY TellMySeniority() {
        return HLW_SENIORITY.SEVENTH;
    }

    @Override
    protected void AfterMeetingBeings() {throw null;}
}

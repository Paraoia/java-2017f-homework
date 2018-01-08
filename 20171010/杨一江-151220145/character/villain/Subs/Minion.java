package character.villain.Subs;

import character.Subordinate;
import utils.coordinate._2Coordinate;

public class Minion extends Subordinate {

    public Minion(_2Coordinate birthplace){
        super(birthplace);
    }

    @Override
    public String TellMyName(){
        return "喽啰";
    }

    @Override
    protected void AfterMeetingBeings(){
        throw null;
    }

    @Override
    public boolean isHero(){
        return false;
    }

    static public Minion[] RecruitMinions(int total_num, Minion... veterans){
        Minion[] ret = new Minion[total_num];

        int idx = 0;
        for (Minion veteran:veterans
             ) {
            ret[idx++] = veteran;
        }

        for (; idx < total_num; idx++) {
            ret[idx] = new Minion(null);
        }

        return ret;
    }
}

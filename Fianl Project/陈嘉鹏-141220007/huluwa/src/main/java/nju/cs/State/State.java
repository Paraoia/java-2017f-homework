package nju.cs.State;

import nju.cs.Creatures.Creature;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjiapeng
 * @Description
 * @date 2018-01-07
 */
public class State {
    private static Map<StateType, stateApply> map = new HashMap<StateType, stateApply>();
    StateType stateType;
    Stateinfo stateinfo;
    Creature target;

    static{
        map = new HashMap<>();
        map.put(StateType.减血, (c, s) -> c.setBlood(c.getBlood() - s.getBlood()));
        map.put(StateType.减蓝, (c, s) -> c.setMagic(c.getMagic() - s.getMagic()));
        map.put(StateType.加血, (c, s) -> c.setBlood(c.getBlood() + s.getBlood()));
        map.put(StateType.移动, (c, s) -> c.moveTo(c.getPosition().add(s.getMoveStep())));
        map.put(StateType.死亡, (c, s) -> {});
    }

    public State(StateType stateType, Stateinfo stateinfo, Creature target) {
        this.stateType = stateType;
        this.stateinfo = stateinfo;
        this.target = target;
    }

    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }

    public void setStateinfo(Stateinfo stateinfo) {
        this.stateinfo = stateinfo;
    }

    public void setTarget(Creature target) {
        this.target = target;
    }

    public StateType getStateType() {
        return stateType;
    }

    public Stateinfo getStateinfo() {
        return stateinfo;
    }

    public Creature getTarget() {
        return target;
    }

    public void apply(Creature creature){
        map.get(this.stateType).apply(creature, stateinfo);
    }

    @Override
    public String toString() {
        String s = "";
        s += target.getCreatureName() + ": " + stateType.toString();
        s += stateinfo != null ? stateinfo.toString() : "";
        return s;
    }
}


;

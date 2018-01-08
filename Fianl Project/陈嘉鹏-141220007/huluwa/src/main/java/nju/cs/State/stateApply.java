package nju.cs.State;

import nju.cs.Creatures.Creature;

/**
 * @author chenjiapeng
 * @Description
 * @date 2018-01-08
 */
interface stateApply{
    public void apply(Creature creature, Stateinfo stateinfo);
}

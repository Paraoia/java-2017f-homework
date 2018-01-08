package Xzr.demo;

public class SeniorityComparable implements Comparable {
    @Override
    public boolean compare(Creature lhs, Creature rhs){
        if(!(lhs instanceof CalabashDoll && rhs instanceof CalabashDoll))
            return true;
        return ((CalabashDoll)lhs).getSeniority().ordinal() > ((CalabashDoll)rhs).getSeniority().ordinal();
    }
}

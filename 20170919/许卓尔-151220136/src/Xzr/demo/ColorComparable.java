package Xzr.demo;

public class ColorComparable implements Comparable{
    @Override
    public boolean compare(Creature lhs, Creature rhs){
        if(!(lhs instanceof CalabashDoll && rhs instanceof CalabashDoll))
            return true;
        return ((CalabashDoll)lhs).getColor().ordinal() > ((CalabashDoll)rhs).getColor().ordinal();
    }
}

package Obj;


import Image.Image;
import Obj.Creature.Creature;
import Position.Position;

public class CreatureImpl extends ObjImpl implements Creature, Comparable<CreatureImpl>{
    Integer priority;

    public CreatureImpl(Image image){
        super(image);
    }
    public CreatureImpl(Image image, Integer priority){
        super(image);
        this.priority = priority;
    }
    public CreatureImpl(Position position, Image image, Integer priority) {
        super(position, image);
        this.priority = priority;
    }

    @Override
    public void setPriority(Integer priority){
        this.priority = priority;
    }

    @Override
    public Integer getPriority() {
        return priority;
    }

    @Override
    public Integer compare(Creature creature){
        return priority < creature.getPriority() ? 1 : 0;
    }

    @Override
    public int compareTo(CreatureImpl arg0){
        return this.priority.compareTo(arg0.getPriority());
    }

}

package Camp;

import Formation.Formation;
import Obj.Creature.Creature;
import Obj.CreatureImpl;
import Position.Position;
import Position.Position2D;
import Position.PriorityPosition;
import mEnums.Direction;

import java.util.ArrayList;
import java.util.Arrays;

public class CampImpl implements Camp{
    Formation formation;
    ArrayList<CreatureImpl> creatures = new ArrayList<CreatureImpl>();
    Position leftUpPoint;
    Direction toward;

    public CampImpl(Formation formation){
        this.formation = formation;
    }
    public CampImpl(Formation formation, CreatureImpl[] creatures){
        this(formation);
        this.creatures = new ArrayList<CreatureImpl>(Arrays.asList(creatures));
    }
    public CampImpl(Formation formation, CreatureImpl[] creatures, Position leftUpPoint, Direction toward){
        this(formation, creatures);
        this.leftUpPoint = leftUpPoint;
        this.toward = toward;
    }



    @Override
    public void lineUp(){
        formation.toward(toward);
        ArrayList<PriorityPosition> Dots = formation.getDots();

        for (Integer c = 0, d = 0; c < creatures.size() && d < Dots.size(); c++, d++){
            CreatureImpl creature = creatures.get(c);
            Position p = new Position2D(((Position2D)leftUpPoint).getX(), ((Position2D)leftUpPoint).getY());
            p.add(Dots.get(d).getPosition());
            creature.setPosition(p);
            creatures.set(c, creature);
        }

        if (creatures.size() > Dots.size()){
            Position p = new Position2D(((Position2D)leftUpPoint).getX(), ((Position2D)leftUpPoint).getY());
            p.add(Dots.get(Dots.size()-1).getPosition());
            for (Integer c = Dots.size(); c < creatures.size(); c++ ){
                CreatureImpl creature = creatures.get(c);
                creature.setPosition(p);
                creatures.set(c, creature);
            }
        }

    }

    public Formation getFormation() {
        return formation;
    }

    public CreatureImpl[] getCreatures() {
        CreatureImpl[] p = new CreatureImpl[creatures.size()];
        creatures.toArray(p);
        return p;
    }

    public Position getLeftUpPoint() {
        return leftUpPoint;
    }

    public Direction getToward() {
        return toward;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public void setCreatures(ArrayList<CreatureImpl> creatures) {
        this.creatures = creatures;
    }

    public void setLeftUpPoint(Position leftUpPoint) {
        this.leftUpPoint = leftUpPoint;
    }

    public void setToward(Direction toward) {
        this.toward = toward;
    }

    @Override
    public void addCreature(CreatureImpl creature){
        this.creatures.add(creature);
    }

    @Override
    public void deleteCreature(CreatureImpl creature){
        this.creatures.remove(creature);
    }
}

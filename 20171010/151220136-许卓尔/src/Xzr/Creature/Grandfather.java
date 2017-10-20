package Xzr.Creature;

import Xzr.Position.*;

public class Grandfather implements Creature {
    private Position position;
    private String name;
    public Grandfather(){
        name = "爷爷";
    }

    //MARK: Creature
    @Override
    public void countOff() {
        System.out.print(this.toString());
    }
    @Override
    public void setPosition(Position position){
        this.position = position;
    }
    @Override
    public Position getPosition(){
        return this.position;
    }
    @Override
    public String getName(){ return this.name; }
}

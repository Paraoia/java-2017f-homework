package Obj.Creature.Huluwa;

import Image.Image;
import Obj.CreatureImpl;
import mEnums.*;


public class Huluwa extends CreatureImpl {
    COLOR color;
    SENIORITY seniority;

    public Huluwa(SENIORITY seniority, COLOR color, Image image){
        super(image);
        this.seniority = seniority;
        this.color = color;
        setPriority(seniority.ordinal());
    }
}



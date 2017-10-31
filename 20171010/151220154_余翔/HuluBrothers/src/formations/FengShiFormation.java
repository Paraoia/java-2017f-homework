package formations;

import formations.FORMATIONNAME;
import formations.Formation;
import creatures.*;
import positions.*;
import maps.*;

public class FengShiFormation extends Formation implements Arrange{
    private int Mid;
    private int Top;

    public int getMid() {
        return Mid;
    }

    public int getTop() {
        return Top;
    }

    public FengShiFormation(Creature[] creatures){

        this.setFormationName(FORMATIONNAME.锋矢);
        this.setCreatures(creatures);
        TwoDimPosition[][] twoDimPositions = new TwoDimPosition[creatures.length][creatures.length];
        for(int i = 0; i<=creatures.length-1;i++) {
            for(int j = 0; j<=creatures.length-1;j++){
                twoDimPositions[i][j] = new TwoDimPosition(i,j);
            }
        }
        this.setTwoDimPositions(twoDimPositions);
    }

    public void setFormation(Map map, int left, int down){

    }
}

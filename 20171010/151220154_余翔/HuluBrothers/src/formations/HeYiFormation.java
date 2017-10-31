package formations;

import formations.FORMATIONNAME;
import formations.Formation;
import creatures.*;
import positions.*;
import maps.*;

public class HeYiFormation extends Formation implements Arrange{

    private int Mid;
    private int Top;

    public int getMid() {
        return Mid;
    }

    public int getTop() {
        return Top;
    }

    public HeYiFormation(Creature[] creatures){

        this.setFormationName(FORMATIONNAME.鹤翼);
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

        this.Mid=3;
        this.Top=6;

        for(int i=0;i<=3;i++) {
            if(i==0)
                this.getTwoDimPositions()[this.Mid][i].setHolder(this.getCreatures()[i]);
            else {
                this.getTwoDimPositions()[this.Mid + i][i].setHolder(this.getCreatures()[2*i-1]);
                this.getTwoDimPositions()[this.Mid - i][i].setHolder(this.getCreatures()[2*i]);
            }
        }

        TwoDimPosition[][] twoDimPositions = this.getTwoDimPositions();
        for(int i=0; i<=twoDimPositions.length-1; i++){
            for(int j=0; j<=twoDimPositions[0].length-1; j++){
                if(!twoDimPositions[i][j].isEmpty())
                    twoDimPositions[i][j].getHolder().setTwoDimPosition(map.getPositions()[i+left][j+down]);
            }
        }
    }

}

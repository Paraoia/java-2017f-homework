package formations;

import formations.FORMATIONNAME;
import formations.Formation;
import creatures.*;
import positions.*;
import maps.*;

public class YanXingFormation extends Formation implements Arrange{
    private int Left;
    private int Top;

    public int getLeft() {
        return this.Left;
    }

    public int getTop() {
        return this.Top;
    }

    public YanXingFormation(Creature[] creatures){

        this.setFormationName(FORMATIONNAME.雁行);
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

        this.Left = 0;
        this.Top=7;

        for(int i=0;i<=this.Top;i++) {
            this.getTwoDimPositions()[this.Left+i][i].setHolder(this.getCreatures()[i]);
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

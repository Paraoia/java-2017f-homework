package formations;

import formations.FORMATIONNAME;
import formations.Formation;
import creatures.*;
import positions.*;
import maps.*;

public class YuLingFormation extends Formation implements Arrange{

    private int Mid;
    private int Top;

    public int getMid() {
        return Mid;
    }

    public int getTop() {
        return Top;
    }

    public YuLingFormation(Creature[] creatures){

        this.setFormationName(FORMATIONNAME.鱼鲮);
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

        this.Mid=2;

        this.getTwoDimPositions()[this.Mid+1][0].setHolder(this.getCreatures()[0]);
        this.getTwoDimPositions()[this.Mid+2][1].setHolder(this.getCreatures()[1]);
        this.getTwoDimPositions()[this.Mid-1][2].setHolder(this.getCreatures()[2]);
        this.getTwoDimPositions()[this.Mid][2].setHolder(this.getCreatures()[3]);
        this.getTwoDimPositions()[this.Mid+1][2].setHolder(this.getCreatures()[4]);
        this.getTwoDimPositions()[this.Mid-2][3].setHolder(this.getCreatures()[5]);
        this.getTwoDimPositions()[this.Mid-1][3].setHolder(this.getCreatures()[6]);
        this.getTwoDimPositions()[this.Mid][3].setHolder(this.getCreatures()[7]);
        this.getTwoDimPositions()[this.Mid+1][3].setHolder(this.getCreatures()[8]);
        this.getTwoDimPositions()[this.Mid+2][3].setHolder(this.getCreatures()[9]);
        this.getTwoDimPositions()[this.Mid][4].setHolder(this.getCreatures()[10]);

        this.Top=4;


        TwoDimPosition[][] twoDimPositions = this.getTwoDimPositions();
        for(int i=0; i<=twoDimPositions.length-1; i++){
            for(int j=0; j<=twoDimPositions[0].length-1; j++){
                if(!twoDimPositions[i][j].isEmpty())
                    twoDimPositions[i][j].getHolder().setTwoDimPosition(map.getPositions()[i+left][j+down]);
            }
        }
    }
}

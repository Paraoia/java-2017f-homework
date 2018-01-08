package formations;
import creatures.*;
import positions.*;

public class Formation{

    FORMATIONNAME FormationName;
    private TwoDimPosition[][] twoDimPositions;
    private Creature[] Creatures;

    public Formation(){
    }

    public void setFormationName(FORMATIONNAME formation){
        this.FormationName = formation;
    }

    public TwoDimPosition[][] getTwoDimPositions() {
        return twoDimPositions;
    }

    public Creature[] getCreatures() {
        return Creatures;
    }

    public void setCreatures(Creature[] creatures) {
        Creatures = creatures;
    }

    public void setTwoDimPositions(TwoDimPosition[][] twoDimPositions) {
        this.twoDimPositions = twoDimPositions;
    }

    public void delFormation(){
        for(int i=0;i<=Creatures.length-1;i++){
            if(Creatures[i]!=null)
                Creatures[i].leaveTwoDimPosition();
        }
    }
}

enum FORMATIONNAME{长蛇,方円,鹤翼,雁行,横轭,鱼鲮,偃月,锋矢}
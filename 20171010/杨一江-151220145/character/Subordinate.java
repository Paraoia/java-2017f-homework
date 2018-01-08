package character;

import utils.coordinate._2Coordinate;

abstract public class Subordinate extends Beings{

    private Beings Leader = null;

    public Subordinate(_2Coordinate birthplace){
        super(birthplace);
    }

    final protected void setLeader(Beings Leader){
        if(this.Leader != null && this.Leader != Leader){
            throw null;
        }
        this.Leader = Leader;
    }

    final protected boolean isLeader(Beings Leader){
        if(this.Leader != null){
            return this.Leader == Leader;
        }
        else return false;
    }
}

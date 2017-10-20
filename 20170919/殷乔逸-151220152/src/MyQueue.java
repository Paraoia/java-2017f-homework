import java.util.*;

class Position{
    public HuluBrother holder;
}

public class MyQueue {
    public Position[] position;

    public MyQueue(){
        position=new Position[7];
        for (int i=0;i<position.length;i++){
            position[i]=new Position();
            position[i].holder=null;
        }
    }

    public void allEnQueue(HuluBrother[] hlb){
        if (hlb.length>this.position.length){
            return;
        }

        position[0].holder=hlb[0];
        position[1].holder=hlb[1];
        position[2].holder=hlb[2];
        position[3].holder=hlb[3];
        position[4].holder=hlb[4];
        position[5].holder=hlb[5];
        position[6].holder=hlb[6];
    }

    public void randomStandInLine(){
        List<Position> listhlb=Arrays.asList(this.position);
        Collections.shuffle(listhlb);
    }
}

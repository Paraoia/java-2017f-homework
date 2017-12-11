public class Changeshe implements Formation {
    public void Do(int x,int y,Space s,Creature []creatures,int length){
       if(x+length>s.getN())
           return;//x,y存的是队形第一个(上面)
       // s.updateCreature(creatures);
        for(int i=0;i<length;i++){
            s.removeCreature(x+i,y);
            s.putCreature(creatures[i],x+i,y);
        }
    }
}

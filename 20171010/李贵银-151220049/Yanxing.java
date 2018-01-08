public class Yanxing implements Formation{
    public void Do(int x,int y,Space s,Creature []creatures,int length){
        if(y-length+1<0||x+length-1>=s.getN())//x,y是右上角第一个
              return;
       // s.updateCreature(creatures);
        for(int i=0;i<length;i++)
        {
            s.removeCreature(x+i,y-i);
            s.putCreature(creatures[i],x+i,y-i);
        }
    }
}

public class Heyi implements Formation {
    public void Do(int x,int y,Space s,Creature []creatures,int length){
        int div=length/2;//length是奇数,x,y那个位置放的是队形中间那个
        if(x-div<0||y-div<0||y+div>=s.getN())
            return;//越界
       // s.updateCreature(creatures);
        s.putCreature(creatures[0],x,y);
        for(int i=1;i<div+1;i++){
            s.removeCreature(x-i,y+i);
            s.putCreature(creatures[2*i-1],x-i,y+i);
            s.removeCreature(x-i,y-i);
            s.putCreature(creatures[2*i],x-i,y-i);
        }

    }
}

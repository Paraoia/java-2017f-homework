public class Fengshi implements Formation {
    public void Do(int x,int y,Space s,Creature []creatures,int length){
        //第一个是正中间那个 默认length%4==0;
        if(x+length/2-1>=s.getN()||y-length/4<0||y+length/4>=s.getN())
            return;
        //s.updateCreature(creatures);
        int temp=0;
        for(int i=0;i<length/2;i++)
        { //例如Length=12，i=0,1,2,3,4,5
                s.removeCreature(x+i,y);
                s.putCreature(creatures[i],x+i,y);
                temp=i;
        }
        for(int i=1;i<=length/4;i++)//i=0,1,2
        {
            s.removeCreature(x+i,y-i);
            temp++;
            s.putCreature(creatures[temp],x+i,y-i);
            s.removeCreature(x+i,y+1);
            temp++;
            s.putCreature(creatures[temp],x+i,y+i);
        }
    }
}

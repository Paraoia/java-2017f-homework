public class Fangyuan implements Formation {
    public void Do(int x,int y,Space s,Creature []creatures,int length){
        //最上面的那个是x.y，length%4=0;
        if(x+length/2>=s.getN()||y-length/4<0||y+length/4>=s.getN())
            return;
       // s.updateCreature(creatures);
        s.removeCreature(x,y);
        s.putCreature(creatures[0],x,y);
        s.removeCreature(x+length/2,y);
        s.putCreature(creatures[1],x+length/2,y);
        int temp=1;
        int temp2=0;
        for(int i=1;i<=length/2-1;i++)
        {
            //int temp2=0;
            if(i<=length/4)
                temp2=i;
            else
                temp2--;
            s.removeCreature(x+i,y-temp2);
            temp++;
            s.putCreature(creatures[temp],x+i,y-temp2);
            s.removeCreature(x+i,y+temp2);
            temp++;
            s.putCreature(creatures[temp],x+i,y+temp2);
        }
    }
}

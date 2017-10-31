public class Henge implements Formation {
    public void Do(int x,int y,Space s,Creature []creatures,int length){
        //x，y是队形的右上角
        if(x+length-1>=s.getN()||y-1<0)
            return;
      //  s.updateCreature(creatures);
        for(int i=0;i<length;i++)
        {
            int temp=y-1;
            if(i%2==0)
                temp=y;
            s.removeCreature(x+i,temp);
            s.putCreature(creatures[i],x+i,temp);
        }
    }
}

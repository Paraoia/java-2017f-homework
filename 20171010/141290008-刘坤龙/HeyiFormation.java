public class HeyiFormation implements Formation {
    public void form(Space space,int x,int y, Creature[] creatures) {
        space.expelAt(x,y);
        space.setInSpace(x,y,creatures[0]);

        int len = (creatures.length-1) / 2;

        for(int i=1;i<=len;i++){
            space.expelAt(x-i,y+i);
            space.setInSpace(x-i,y+i,creatures[2*i-1]);

            space.expelAt(x+i,y+i);
            space.setInSpace(x+i,y+i,creatures[2*i]);
        }

        len++;
        if(2*len - 1 < creatures.length){
            space.expelAt(x-len,y+len);
            space.setInSpace(x-len,y+len,creatures[creatures.length-1]);
        }
    }
}

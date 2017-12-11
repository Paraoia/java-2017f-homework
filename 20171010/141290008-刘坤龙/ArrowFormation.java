public class ArrowFormation implements Formation {
    @Override
    public void form(Space space,int x,int y, Creature[] creatures) {
        space.expelAt(x,y);
        space.setInSpace(x,y,creatures[0]);

        int len = (creatures.length-1) / 3;

        for(int i=1;i<=len;i++){
            space.expelAt(x-i,y+i);
            space.setInSpace(x-i,y+i,creatures[3*i-2]);

            space.expelAt(x+i,y+i);
            space.setInSpace(x+i,y+i,creatures[3*i-1]);

            space.expelAt(x,y+i);
            space.setInSpace(x,y+i,creatures[3*i]);
        }

        len++;
        if(3*len - 2 < creatures.length){
            space.expelAt(x-len,y+len);
            space.setInSpace(x-len,y+len,creatures[3*len - 2]);
        }
        if(3*len - 1 < creatures.length){
            space.expelAt(x+len,y+len);
            space.setInSpace(x-len,y+len,creatures[3*len - 1]);
        }
    }
}

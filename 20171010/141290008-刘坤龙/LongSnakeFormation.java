
/* Random order */
public class LongSnakeFormation implements Formation {

    @Override
    public void form(Space space,int x,int y, Creature[] creatures){
        for(int i=0;i<creatures.length;i++){
            /* Ask the creature to fly into the air */
            Creature tmp = space.expelAt(x+i,y);

            space.setInSpace(x+i,y,creatures[i]);
        }
    }
}

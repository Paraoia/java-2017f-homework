public abstract class Creature extends Block{

    protected Position position;

    protected NAME name;

    //Camp camp;

    Creature(NAME givenname) {

        position = new Position3D();

        name = givenname;

        //camp = new Netrul();

    }

    @Override
    boolean isoccupied() { return true; }

    public void setposition(Map map, Position newposition) {

        if (map.islegal(newposition) && !map.isoccupied(newposition)) {

            map.setblock(this, newposition);

            position.moveto(newposition);

        }

    }

    public void clearposition(Map map) { map.clearblock(position); }

    public Position getposition() { return position.getposition(); }

    public boolean moveto(Map map, Position newposition /** type */ ) {
        /**
         *  action allowed and map allowed
         */

        if (map.islegal(newposition) /*&& !map.isoccupied(newposition)*/) {

            map.clearblock(position);
            map.clearblock(newposition);

            map.setblock(this, newposition);

            position.moveto(newposition);

            return true;

        }

        return false;

    }

    @Override
    public void positionreset() { position.clear(); }

    @Override
    public NAME getname() { return name; }

    //abstract void speek(int type);

    //CAMP getcamp() { return camp.getcamp(); }

}


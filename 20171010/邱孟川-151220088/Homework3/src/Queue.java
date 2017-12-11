public interface Queue {

    public Position[] getPositions();

    public Creature[] getCreatures();

    public void rollCall();

    public void shuffle();
}

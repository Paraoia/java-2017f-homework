public interface Map {

    int getMaxX();

    int getMaxY();

    int getMaxZ();

    boolean islegal(Position position);

    boolean isoccupied(Position position);

    void setblock(Block block, Position newposition);

    boolean clearblock(Position position);

    void draw();

}

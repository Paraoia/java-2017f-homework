package HuluwaFighting;

/**
 * 二维平面坐标位置的对外接口
 */
public interface Position {
    public int getX();
    public int getY();
    public boolean isOccupied();
    public Creature getHolder();
    public Boolean isbiggerThan(Position x);

    public void setX(int x);
    public void setY(int y);
    public boolean setHolder(Creature creature);
    public void clearHolder();
}

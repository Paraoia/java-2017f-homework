public class PlainMap implements Map {

    private int mx, my, mz;

    private Block[][][] map;

    PlainMap() {

        mx = 20; my = 20; mz = 20;

        map = new Block[mz][my][mx];
        for( int i = 0; i < mz; i++)
            for (int j = 0; j < my; j++)
                for (int k = 0; k < mx; k++)
                    map[i][j][k] = new RealBlock();

    }

    PlainMap(int x, int y, int z) {

        mx = x; my = y; mz = z;

        map = new Block[mz][my][mx];
        for( int i = 0; i < mz; i++)
            for (int j = 0; j < my; j++)
                for (int k = 0; k < mx; k++)
                    map[i][j][k] = new RealBlock();

    }

    public int getMaxX() { return mx; }

    public int getMaxY() { return my; }

    public int getMaxZ() { return mz; }

    public boolean islegal(Position position) {

        int x = position.getX(), y = position.getY(), z = position.getZ();

        return (x <= mx && x >= 0 && y <= my && y >= 0 && z <= mz && z >= 0);

    }

    public boolean isoccupied(Position position) {

        int x = position.getX(), y = position.getY(), z = position.getZ();

        return map[z][y][x].isoccupied();

    }

    public void setblock(Block block, Position newposition) { map[newposition.getZ()][newposition.getY()][newposition.getX()] = block; }

    public boolean clearblock(Position position) {

        int x = position.getX(), y = position.getY(), z = position.getZ();

        if (x <= mx && x >= 0 && y <= my && y >= 0 && z <= mz && z >= 0) {

            map[z][y][x].positionreset();
            map[z][y][x] = new RealBlock();

            return true;

        }

        return false;

    }

    public void draw() {
        for( int i = 0; i < mz; i++)
            for (int j = 0; j < my; j++) {
                for (int k = 0; k < mx; k++) {

                    if (map[i][j][k].isoccupied())
                        System.out.printf(" %.2s ", map[i][j][k].getname().toString());//(map[i][j][k].getname().toString());
                    else
                        System.out.print(" ---- ");

                }

                System.out.println();

            }
    }

}

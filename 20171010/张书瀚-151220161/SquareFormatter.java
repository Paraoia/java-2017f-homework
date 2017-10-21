public class SquareFormatter implements Formatter, Constants {
    @Override
    public void format(Space space) {
        Creature creatures[][] = space.getCreatures();
        Position positions[][] = space.getPositions();

        for (int m = HALFSPACE; m < MAXSPACE; m++) {
            for (int n = 0; n < MAXSPACE; n++) {
                positions[m][n].clearOccupy();
            }
        }

        positions[12][4].setHolder(creatures[3][0]);
        positions[12][4].setOccupy();
        creatures[3][0].setPos(positions[12][4]);

        int k = 0;
        for (int i = 13, j = 3; i < 16; i++, j--, k++) {
            positions[i][j].setHolder(creatures[4][k]);
            positions[i][j].setOccupy();
            creatures[4][k].setPos(positions[i][j]);
        }
        for (int i = 13, j = 5; i < 16; i++, j++, k++) {
            positions[i][j].setHolder(creatures[4][k]);
            positions[i][j].setOccupy();
            creatures[4][k].setPos(positions[i][j]);
        }
        for (int i = 16, j = 2; i < 19; i++, j++, k++) {
            positions[i][j].setHolder(creatures[4][k]);
            positions[i][j].setOccupy();
            creatures[4][k].setPos(positions[i][j]);
        }
        for (int i = 16, j = 6; i < 18; i++, j--, k++) {
            positions[i][j].setHolder(creatures[4][k]);
            positions[i][j].setOccupy();
            creatures[4][k].setPos(positions[i][j]);
        }
    }
}

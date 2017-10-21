public class LineFormatter implements Formatter, Constants {
    @Override
    public void format(Space space) {
        Creature creatures[][] = space.getCreatures();
        Position positions[][] = space.getPositions();

        for (int m = HALFSPACE; m < MAXSPACE; m++) {
            for (int n = 0; n < MAXSPACE; n++) {
                positions[m][n].clearOccupy();
            }
        }

        positions[10][8].setHolder(creatures[3][0]);
        positions[10][8].setOccupy();
        creatures[3][0].setPos(positions[10][8]);

        int k = 0;
        for (int i = 11, j = 7; i < 19; i++, j--, k++) {
            positions[i][j].setHolder(creatures[4][k]);
            positions[i][j].setOccupy();
            creatures[4][k].setPos(positions[i][j]);
        }
    }
}

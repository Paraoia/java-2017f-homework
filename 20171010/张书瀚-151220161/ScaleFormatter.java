public class ScaleFormatter implements Formatter, Constants {
    @Override
    public void format(Space space) {
        System.out.println("鱼鳞阵：");

        Creature creatures[][] = space.getCreatures();
        Position positions[][] = space.getPositions();

        for (int m = HALFSPACE; m < MAXSPACE; m++) {
            for (int n = 0; n < MAXSPACE; n++) {
                positions[m][n].clearOccupy();
            }
        }

        //蝎子精位置
        positions[12][4].setHolder(creatures[3][0]);
        positions[12][4].setOccupy();
        creatures[3][0].setPos(positions[12][4]);

        //喽啰位置
        int k = 0;
        positions[13][5].setHolder(creatures[4][k]);
        positions[13][5].setOccupy();
        creatures[4][k].setPos(positions[13][5]);
        k++;
        for (int j = 2; j < 7; j = j + 2, k++) {
            positions[14][j].setHolder(creatures[4][k]);
            positions[14][j].setOccupy();
            creatures[4][k].setPos(positions[14][j]);
        }
        for (int j = 1; j < 8; j = j + 2, k++) {
            positions[15][j].setHolder(creatures[4][k]);
            positions[15][j].setOccupy();
            creatures[4][k].setPos(positions[15][j]);
        }
        positions[16][4].setHolder(creatures[4][k]);
        positions[16][4].setOccupy();
        creatures[4][k].setPos(positions[16][4]);
    }
}
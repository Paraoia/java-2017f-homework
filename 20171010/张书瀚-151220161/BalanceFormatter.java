public class BalanceFormatter implements Formatter, Constants {
    @Override
    public void format(Space space) {
        System.out.println("横轭阵：");

        Creature creatures[][] = space.getCreatures();
        Position positions[][] = space.getPositions();

        for (int m = HALFSPACE; m < MAXSPACE; m++) {
            for (int n = 0; n < MAXSPACE; n++) {
                positions[m][n].clearOccupy();
            }
        }

        //蝎子精位置
        positions[10][5].setHolder(creatures[3][0]);
        positions[10][5].setOccupy();
        creatures[3][0].setPos(positions[10][8]);

        //喽啰位置
        int k = 0;
        for (int i = 11; i < 20; i = i + 2, k++) {
            positions[i][3].setHolder(creatures[4][k]);
            positions[i][3].setOccupy();
            creatures[4][k].setPos(positions[i][3]);
        }
        for (int i = 12; i < 20; i = i + 2, k++) {
            positions[i][5].setHolder(creatures[4][k]);
            positions[i][5].setOccupy();
            creatures[4][k].setPos(positions[i][5]);
        }
    }
}

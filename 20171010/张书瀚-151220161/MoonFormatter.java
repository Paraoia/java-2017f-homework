import java.util.ArrayList;

public class MoonFormatter implements Formatter, Constants {

    @Override
    public void format(Space space) {
        System.out.println("偃月阵：");

        ArrayList<Creature> scorpion = space.getCreatures().get(3);
        ArrayList<Creature> goblins = space.getCreatures().get(4);
        Position positions[][] = space.getPositions();

        for (int m = HALFSPACE; m < MAXSPACE; m++)
            for (int n = 0; n < HALFSPACE; n++)
                positions[m][n].clearOccupy();

        //蝎子精位置
        positions[11][5].setHolder(scorpion.get(0));
        positions[11][5].setOccupy();
        scorpion.get(0).setPos(positions[11][5]);

        //喽啰位置
        int k = 0;
        positions[12][4].setHolder(goblins.get(k));
        positions[12][4].setOccupy();
        goblins.get(k).setPos(positions[12][4]);
        k++;
        for (int i = 10, j = 8; i < 13; i++, j--, k++) {
            positions[i][j].setHolder(goblins.get(k));
            positions[i][j].setOccupy();
            goblins.get(k).setPos(positions[i][j]);
        }
        for (int i = 13; i < 16; i++) {
            for (int j = 1; j < 6; j = j + 2, k++) {
                positions[i][j].setHolder(goblins.get(k));
                positions[i][j].setOccupy();
                goblins.get(k).setPos(positions[i][j]);
            }
        }
        for (int i = 16, j = 4; i < 18; i++, j++, k++) {
            positions[i][j].setHolder(goblins.get(k));
            positions[i][j].setOccupy();
            goblins.get(k).setPos(positions[i][j]);
        }
        for (int i = 16, j = 6; i < 19; i++, j++, k++) {
            positions[i][j].setHolder(goblins.get(k));
            positions[i][j].setOccupy();
            goblins.get(k).setPos(positions[i][j]);
        }
    }
}

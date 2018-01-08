import java.util.ArrayList;

public class ScaleFormatter implements Formatter, Constants {
    @Override
    public void format(Space space) {
        System.out.println("鱼鳞阵：");

        ArrayList<Creature> scorpion = space.getCreatures().get(3);
        ArrayList<Creature> goblins = space.getCreatures().get(4);
        Position positions[][] = space.getPositions();

        for (int m = HALFSPACE; m < MAXSPACE; m++) {
            for (int n = 0; n < HALFSPACE; n++) {
                positions[m][n].clearOccupy();
            }
        }

        //蝎子精位置
        positions[12][4].setHolder(scorpion.get(0));
        positions[12][4].setOccupy();
        scorpion.get(0).setPos(positions[12][4]);

        //喽啰位置
        int k = 0;
        positions[13][5].setHolder(goblins.get(k));
        positions[13][5].setOccupy();
        goblins.get(k).setPos(positions[13][5]);
        k++;
        for (int j = 2; j < 7; j = j + 2, k++) {
            positions[14][j].setHolder(goblins.get(k));
            positions[14][j].setOccupy();
            goblins.get(k).setPos(positions[14][j]);
        }
        for (int j = 1; j < 8; j = j + 2, k++) {
            positions[15][j].setHolder(goblins.get(k));
            positions[15][j].setOccupy();
            goblins.get(k).setPos(positions[15][j]);
        }
        positions[16][4].setHolder(goblins.get(k));
        positions[16][4].setOccupy();
        goblins.get(k).setPos(positions[16][4]);
    }
}
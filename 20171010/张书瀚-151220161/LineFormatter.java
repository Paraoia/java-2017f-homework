import java.util.ArrayList;

public class LineFormatter implements Formatter, Constants {
    @Override
    public void format(Space space) {
        System.out.println("雁行阵：");

        ArrayList<Creature> scorpion = space.getCreatures().get(3);
        ArrayList<Creature> goblins = space.getCreatures().get(4);
        Position positions[][] = space.getPositions();

        for (int m = HALFSPACE; m < MAXSPACE; m++) {
            for (int n = 0; n < HALFSPACE; n++) {
                positions[m][n].clearOccupy();
            }
        }

        //蝎子精位置
        positions[10][8].setHolder(scorpion.get(0));
        positions[10][8].setOccupy();
        scorpion.get(0).setPos(positions[10][8]);

        //喽啰位置
        int k = 0;
        for (int i = 11, j = 7; i < 19; i++, j--, k++) {
            positions[i][j].setHolder(goblins.get(k));
            positions[i][j].setOccupy();
            goblins.get(k).setPos(positions[i][j]);
        }
    }
}

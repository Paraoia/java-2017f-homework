import java.util.ArrayList;

public class SnakeFormatter implements Formatter, Constants {
    @Override
    public void format(Space space) {
        //System.out.println("长蛇阵：");

        ArrayList<Creature> creatures = space.getCreatures().get(1);
        Position positions[][] = space.getPositions();

        for (int m = 0; m < MAXSPACE; m++)
            for (int n = 0; n < HALFSPACE; n++)
                positions[m][n].clearOccupy();

        //葫芦娃位置
        for (int i = 1, j = 0; i < 8; i++, j++) {
            positions[4][i].setHolder(creatures.get(j));
            positions[4][i].setOccupy();
            creatures.get(j).setPos(positions[4][i]);
        }
    }
}

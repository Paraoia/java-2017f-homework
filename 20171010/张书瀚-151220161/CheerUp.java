import java.util.ArrayList;

public class CheerUp {
    public void cheer(Space space) {
        Position positions[][] = space.getPositions();
        ArrayList<Creature> grandpa = space.getCreatures().get(0);
        ArrayList<Creature> snake = space.getCreatures().get(2);

        //爷爷位置
        positions[4][9].setHolder(grandpa.get(0));
        positions[4][9].setOccupy();
        grandpa.get(0).setPos(positions[8][1]);

        //蛇精位置
        positions[11][1].setHolder(snake.get(0));
        positions[11][1].setOccupy();
        snake.get(0).setPos(positions[11][1]);

    }
}

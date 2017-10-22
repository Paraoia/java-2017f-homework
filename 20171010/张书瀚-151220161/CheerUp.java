public class CheerUp {
    public void cheer(Space space) {
        Position positions[][] = space.getPositions();
        Creature creatures[][] = space.getCreatures();

        //爷爷位置
        positions[8][1].setHolder(creatures[0][0]);
        positions[8][1].setOccupy();
        creatures[0][0].setPos(positions[8][1]);

        //蛇精位置
        positions[11][1].setHolder(creatures[2][0]);
        positions[11][1].setOccupy();
        creatures[2][0].setPos(positions[11][1]);

    }
}

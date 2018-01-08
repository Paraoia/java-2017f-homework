import org.junit.Test;

import static org.junit.Assert.*;


public class PositionTest {

    @Test
    public void printTest(){
        Position temp = new Position(1,1);
        Boy king = new Boy(1,1,1,new BattleField(),"1.png");
        temp.setOccupy();
        temp.setHolder(king);
        temp.setImageName(king.imageName);
        temp.addDeadBodies("dead1.png");
        temp.addDeadBodies("dead1.png");
        temp.addDeadBodies("dead1.png");

        assertEquals(temp.printStatus(),"1.png dead1.png dead1.png" +
                " dead1.png");
    }


}

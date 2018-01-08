import org.junit.Test;

import static org.junit.Assert.*;

public class CreatureTest {

    @Test
    public void distanceTest() {
        Boy boy = new Boy(1,0,1,new BattleField(),"1.png");
        Scorpion scorpion = new Scorpion(5,5,new BattleField(),"scorpion" +
                ".png");

        assertEquals(9,boy.distanceTo(scorpion));
        assertEquals(9,scorpion.distanceTo(boy));
    }
}

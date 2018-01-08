import org.junit.Test;

import static org.junit.Assert.*;

public class BattleFieldTest {

    BattleField tfield = new BattleField();

    @Test
    public void nearestTest() {
        Boy boy1 = new Boy(1,0,1,tfield,"1.png");
        Boy boy2 = new Boy(2,0,5,tfield,"2.png");
        tfield.boys.add(boy1);
        tfield.boys.add(boy2);
        Goblin goblin = new Goblin(5,1,tfield,"goblin1.png");
        tfield.goblins.add(goblin);
        tfield.scorpion = new Scorpion(5,5,tfield,"scorpion.png");



        assertSame(goblin,boy1.getNearest());
        assertSame(tfield.scorpion,boy2.getNearest());


    }


}

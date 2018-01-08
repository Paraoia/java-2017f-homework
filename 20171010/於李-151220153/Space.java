import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Space {
    private final int row; // size of the space
    private ArrayList<Position<Creature>> pos;
    private ArrayList<Creature> justPower;
    private ArrayList<Creature> evilPower;
    private StrategySelector<Creature> commander;
    private Sorter sorter;

    Space(int inputRow) {
        sorter = new BubbleSorter();
        row = inputRow;
        justPower = new ArrayList<>();
        evilPower = new ArrayList<>();
        pos = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++)
                pos.add(new Position<>(i, j));
        }
        commander = new StrategySelector<>(row, pos);
    }

    public void battle() {
        for (int i = 0; i < 6; i++) {
            clearBattlefield();
            System.out.println("第" + i +"回合");
            if ( i == 5) i++;
            justPower.get(7).act();
            justPower.get(i).act();
            evilPower.get(0).act();
            evilPower.get(1).act();
            switch (i) {
                case 0: commander.yanXing(evilPower); break;
                case 1: commander.hengE(evilPower); break;
                case 2: commander.yuLin(evilPower); break;
                case 3: commander.fangDou(evilPower); break;
                case 4: commander.yanYue(evilPower); break;
                case 6: commander.fengShi(evilPower); break;
                default: break;
            }
            commander.changeShe(justPower);
            displayBattlefield();
        }
    }

    public void enterBattlefield() { //Initialize creatures
        System.out.println("正义力量登场:");
        for (int i = 0; i < 7; i++) {
            justPower.add(new Huluwa(COLOR.values()[i], SENIORITY.values()[i]));
        }
        long seed = System.nanoTime();
        Collections.shuffle(justPower, new Random(seed));
        for (int i = 0; i < 7; i++) {
            justPower.get(i).setPosition(pos.get((row - 7) / 2 + i));
        }
        displayBattlefield();
        justPower.add(new Grandpa());
        justPower.get(7).setPosition(pos.get(row - 1));
        System.out.println("调整队形:");
        sorter.sort(pos, (row - 7) / 2, (row - 7) / 2 + 7);
        for (int i = 0; i < 7; i++) {
            justPower.set(i, pos.get((row - 7) / 2 + i).getHolder());
        }
        displayBattlefield();

        System.out.println("邪恶势力现身:");
        evilPower.add(new Snake());
        evilPower.add(new Xiezi());
        for (int i = 0; i < 20; i++) {
            evilPower.add(new Lowluo());
        }
        commander.heYi(evilPower);
        displayBattlefield();
    }

    public void displayBattlefield() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (pos.get(i * row + j).getHolder() != null) {
                    pos.get(i * row + j).getHolder().report();
                    System.out.print(" ");
                }
                else
                    System.out.print("\uD83C\uDF32 ");
            }
            System.out.println();
        }
    }

    public void clearBattlefield() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (pos.get(i * row + j).getHolder() != null) {
                    pos.get(i * row + j).getHolder().setPosition(null);
                    pos.get(i * row + j).setHolder(null);
                }
            }
        }

    }

    public static void main(String args[]) {
        Space battleField = new Space(12);
        battleField.enterBattlefield();
        battleField.clearBattlefield();
        battleField.battle();
    }
}

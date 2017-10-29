public class Space {
    private final int row; // size of the space
    private Position[][] pos;
    private Creature[] justPower;
    private Creature[] evilPower;
    private StrategySelector commander;
    private Sorter sorter;
    private Shuffler shuffler;

    Space(int inputRow) {
        sorter = new BubbleSorter();
        commander = new StrategySelector();
        shuffler = new Shuffler();
        row = inputRow;
        pos = new Position[row][row];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < row; j++) {
                pos[i][j] = new Position(i, j);
            }
    }

    public void battle() {
        clearBattlefield();
        System.out.println("第一回合");
        justPower[0].act();
        justPower[1].act();
        evilPower[0].act();
        evilPower[1].act();
        commander.yanXing(evilPower, pos);
        commander.changeShe(justPower, pos);
        displayBattlefield();

        clearBattlefield();
        System.out.println("第二回合");
        justPower[0].act();
        justPower[2].act();
        evilPower[0].act();
        evilPower[1].act();
        commander.hengE(evilPower, pos);
        commander.changeShe(justPower, pos);
        displayBattlefield();

        clearBattlefield();
        System.out.println("第三回合");
        justPower[0].act();
        justPower[3].act();
        evilPower[0].act();
        evilPower[1].act();
        commander.yuLin(evilPower, pos);
        commander.changeShe(justPower, pos);
        displayBattlefield();

        clearBattlefield();
        System.out.println("第四回合");
        justPower[0].act();
        justPower[4].act();
        evilPower[0].act();
        evilPower[1].act();
        commander.fangDou(evilPower, pos);
        commander.changeShe(justPower, pos);
        displayBattlefield();

        clearBattlefield();
        System.out.println("第五回合");
        justPower[0].act();
        justPower[5].act();
        evilPower[0].act();
        evilPower[1].act();
        commander.yanYue(evilPower, pos);
        commander.changeShe(justPower, pos);
        displayBattlefield();

        clearBattlefield();
        System.out.println("第六回合");
        justPower[0].act();
        justPower[7].act();
        evilPower[0].act();
        evilPower[1].act();
        commander.fengShi(evilPower, pos);
        commander.changeShe(justPower, pos);
        displayBattlefield();
    }

    public void enterBattlefield() { //Initialize creatures
        System.out.println("正义力量登场:");
        justPower = new Creature[8];
        justPower[0] = new Grandpa();
        justPower[0].setPosition(pos[0][pos.length - 1]);
        int []order = shuffler.shuffledArray(7);
        for (int i = 1; i < 8; i++) {
            justPower[i] = new Huluwa(COLOR.values()[i - 1], SENIORITY.values()[i - 1]);
            justPower[i].setPosition(pos[0][(pos.length - 7) / 2 + order[i - 1]]);
        }
        displayBattlefield();
        System.out.println("调整阵型:");
        sorter.sort(pos[0], (pos.length - 7) / 2, (pos.length - 7) / 2 + 7);
        displayBattlefield();


        System.out.println("邪恶势力现身:");
        evilPower = new Creature[22];
        evilPower[0] = new Snake();
        evilPower[1] = new Xiezi();
        for (int i = 2; i < 22; i++)
            evilPower[i] = new Lowluo();
        commander.heYi(evilPower, pos);
        displayBattlefield();
    }

    public void displayBattlefield() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (pos[i][j].getHolder() != null) {
                    pos[i][j].getHolder().report();
                    System.out.print(" ");
                }
                else
                    System.out.print("【】 ");
            }
            System.out.println();
        }
    }

    public void clearBattlefield() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (pos[i][j].getHolder() != null) {
                    pos[i][j].getHolder().setPosition(null);
                    pos[i][j].setHolder(null);
                }
            }
        }

    }

    public static void main(String args[]) {
        Space battleField = new Space(12);
        battleField.enterBattlefield();
        battleField.battle();
    }
}

public class HuluWorld {
    public static void main(String[] args) {

        /* 坐标信息、怪物数量值定义 */
        final int ROW = 50;
        final int BRO_COL = 33, MON_COL = 55;
        final int GRA_ROW = ROW - 2, GRA_COL = BRO_COL + 3;
        final int SHE_ROW = ROW, SHE_COL = MON_COL + 5;
        final int BRO_LEN = 7, MON_LEN = 20;

        /* 登场人物和战场初始化 */
        Creature[] brothers = new Brother[BRO_LEN];
        for(int i = 0; i < BRO_LEN; i++){
            brothers[i] = new Brother(COLOR.values()[i], RANK.values()[i]);
        }
        Creature[] monster = new Monster[MON_LEN];
        monster[0] = XieZ.getXiez();
        for(int i = 1; i < MON_LEN; i++){
            monster[i] = new Monster();
        }
        Creature Shej = SheJ.getShej();
        Creature grandfa = Grandpa.getGrandpa();
        Space space = new Space();

        /*  葫芦兄弟长蛇阵进场，乱序站队后显示，排序后显示  */
        SpaceController spaceController = new SpaceController();

        spaceController.LongSnake(space, brothers, ROW,BRO_COL);
        space.shuffle_row(ROW, BRO_COL, BRO_LEN);
        space.report_row( ROW, BRO_COL, BRO_LEN);
        BubbleSorter bubbleSorter = new BubbleSorter();
        bubbleSorter.sort(space,ROW, BRO_COL, BRO_LEN);
        space.report_row(ROW, BRO_COL, BRO_LEN);

        /*  蝎子精阵队按（七选一）阵型进场  */
        //SpaceController.Moon(space, monster, ROW, MON_COL);
        //SpaceController.Goose(space, monster,ROW, MON_COL);
        spaceController.FangY(space, monster, ROW, MON_COL);
        //SpaceController.Scale(space, monster, ROW, MON_COL);
        //SpaceController.ChongE(space, monster, ROW, MON_COL);
        //SpaceController.Crane(space, monster, ROW, MON_COL);
        //SpaceController.Arrow(space, monster, ROW, MON_COL);

        /*  蛇精和老爷爷进场  */
        space.EnterCreature(grandfa, GRA_ROW, GRA_COL);
        space.EnterCreature(Shej, SHE_ROW, SHE_COL);

        /*  打印战场  */
        space.report();

        /*  蝎子精阵营重新站队，重新打印输出  */
        System.out.println("---------------------------------新战场-------------------------------");
        space.reset();
        spaceController.LongSnake(space, brothers, ROW,BRO_COL);
        bubbleSorter.sort(space,ROW, BRO_COL, BRO_LEN);
        spaceController.Scale(space, monster, ROW, MON_COL);
        space.EnterCreature(grandfa, GRA_ROW, GRA_COL);
        space.EnterCreature(Shej, SHE_ROW, SHE_COL);
        space.report();
    }
}

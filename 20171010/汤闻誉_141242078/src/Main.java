public class Main {

    public static void main(String[] args) {
        //初始化所有生物
        Creature[] brothers = new Huluwa[7];
        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new Huluwa(SENIORITY.values()[i]);
        }
        Creature[] monsters=new Monster[12];
        monsters[0]=new Monster(MONSTERLEVEL.蝎子精);
        for (int i = 1; i < monsters.length; i++) {
            monsters[i] = new Monster(MONSTERLEVEL.小喽啰);
        }
        Grandpa grandpa=new Grandpa();
        Snake snake=new Snake();
        //将葫芦兄弟排成长蛇阵
        Formation brothersFormation=new Formation(brothers);
        brothers=brothersFormation.长蛇阵();
        //将妖怪排成雁形阵
        Formation monstersFormation=new Formation(monsters);
        monsters=monstersFormation.雁行阵();
        //将葫芦兄弟的长蛇阵营和蝎子精小喽啰阵营放置于二位空间中，形成对峙局面；
        Battlefield battlefield=new Battlefield();
        battlefield.formationIn(brothers,2,2);
        battlefield.formationIn(monsters,13,1);
        //将老爷爷和蛇精放置于空间中，为各自一方加油助威；
        battlefield.creatureIn(grandpa,0,8);
        battlefield.creatureIn(snake,14,8);
        //打印
        battlefield.print();
        //重复
        monsters=monstersFormation.冲轭阵();
        battlefield=new Battlefield();
        battlefield.formationIn(brothers,2,2);
        battlefield.formationIn(monsters,10,1);
        battlefield.creatureIn(grandpa,0,8);
        battlefield.creatureIn(snake,14,8);
        battlefield.print();
    }
}

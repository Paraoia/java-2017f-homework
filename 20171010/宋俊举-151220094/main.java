public class main {



    public static void main(String[] args)
    {
        Battlefield theWorld = new Battlefield();
        Huluwa[] huluwas = new Huluwa[7];
        for(int i=0;i<7;i++)
        {
            huluwas[i] = new Huluwa(COLOR.values()[i],SENIORITY.values()[i]);
        }

        Grandpa yeye= new Grandpa();

        ScorpionMonster boss = new ScorpionMonster();

        Servant[] servants = new Servant[7];
        for(int i=0;i<7;i++)
        {
            servants[i] = new Servant(i);
        }

        theWorld.addHuluwa(huluwas);
        theWorld.addServant(servants);
        theWorld.addBoss(boss);
        theWorld.addGrandpa(yeye);
        theWorld.setHuluwas();
        theWorld.setBossAndYeYe();
        theWorld.setservants();
        theWorld.printBattleField();

        theWorld.changeFormation(FORMATIONS.ChongE);

        theWorld.printBattleField();
    }

}

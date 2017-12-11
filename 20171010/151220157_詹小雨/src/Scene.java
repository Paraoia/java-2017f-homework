public class Scene {

    private Map map;

    private Creature[] goodcreatures;

    //private Creature[] netrulcreatures;

    private Creature[] evilcreatures;

    Scene() {

        map = new PlainMap(20, 20, 1);

        GCinit();
        ECinit();

    }

    void GCinit() {

        CalabashBoy[] boys = new CalabashBoy[7];
        for (int i = 0; i < boys.length; i++) {
            boys[i] = new CalabashBoy(NAME.values()[i + 1], CBCOLOR.values()[i]);
        }

        Grandpa grandpa = new Grandpa();

        goodcreatures = new Creature[8];

        int j;
        for (j = 0; j < boys.length; j++)
            goodcreatures[j] = boys[j];
        goodcreatures[j] = grandpa;

        // set position
        for (int i = 0; i < 8; i++) {
            Position position = new Position3D(12, i + 2, 0);
            goodcreatures[i].setposition(map, position);
        }



    }

    void ECinit() {

        Monster[] monsters = new Monster[14];
        monsters[0] = new Monster(NAME.蛇精);
        monsters[1] = new Monster(NAME.蝎子精);
        for (int i = 2; i < monsters.length; i++)
            monsters[i] = new Monster(NAME.蛤蟆怪);

        // set position
        for (int i = 0; i < monsters.length; i++) {
            Position position = new Position3D(4, i + 2, 0);
            monsters[i].setposition(map, position);
        }

        evilcreatures = monsters;

    }

    public void mapdraw() { map.draw(); }

    public void test() {

        Creature[] templine = new Creature[7];
        for (int i = 0; i < templine.length; i++)
            templine[i] = goodcreatures[i];
        new EmbattleSort().sort(templine, map);

        templine = new Creature[13];
        for (int i = 0; i < templine.length; i++)
            templine[i] = evilcreatures[i + 1];

        new EmbattleSort().sort(templine, map, 1);

        System.out.println("First:");
        map.draw();

        new EmbattleSort().sort(templine, map, 2);

        System.out.println("Second:");
        map.draw();

    }

    public static void main(String[] args){

        Scene scene = new Scene();

        scene.test();

    }

}

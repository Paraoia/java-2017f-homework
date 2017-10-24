

import java.util.Random;


public class Ground {
    private Position[][] positions;

    private Creature[] monsterArmy;
    private Creature Boss;
    private Creature[] heroes;
    private Creature Grandpa;

    Ground(int width) {
        this.positions = new Position[width][width];

        for (int i=0;i < width; i++)
            for (int j=0; j < width; j++)
                this.positions[i][j] = new Position(i, j);
    }

    public void placeCreatures(Creature[] creatures, Formation form) {
        this.monsterArmy = creatures;
        Position pos;
        for (Creature creature: creatures) {
            if(creature.getPosition() != null){
                creature.getPosition().setHolder(null);
               // mstr.setPosition(null);
            }
            pos = form.nextPos();
            if(pos.legal() && pos.getX() < positions.length && pos.getY() < positions.length) {
                this.positions[pos.getX()][pos.getY()].setHolder(creature);
                creature.setPosition(this.positions[pos.getX()][pos.getY()]);
            }
        }
    }

    public void placeCreature(Creature creature, Position pos) {
        if(creature.getPosition() != null){
            creature.getPosition().setHolder(null);
            // mstr.setPosition(null);
        }
        if(pos.legal() && pos.getX() < positions.length && pos.getY() < positions.length) {
            this.positions[pos.getX()][pos.getY()].setHolder(creature);
            creature.setPosition(this.positions[pos.getX()][pos.getY()]);
        }
    }


    public void report() {
        for (int i=0; i < positions.length; i++) {
            for (int j = 0; j < positions[i].length; j++) {
                if (positions[i][j].getHolder() != null)
                    positions[i][j].getHolder().report();
                else
                    System.out.print("口 ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String []args) {
        Grandpa grandpa = new Grandpa();
        Huluwa[] brothers = new Huluwa[7];
        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new Huluwa(COLOR.values()[i], SENIORITY.values()[i]);
        }

        Boss boss = new Boss();
        Monster []mstrArmy = new Monster[7];
        mstrArmy[0] = new EliteMonster();
        for (int i=1; i < mstrArmy.length; i++) {
            mstrArmy[i] = new Monster();
        }

        Ground ground = new Ground(15);

        Queue queue = new Queue(brothers);
        queue.shuffle();
        //queue.rollCall();
        Sorter sort = new BubbleSorter();
        sort.sort(queue);

        ground.placeCreatures(
                brothers,
                //长蛇
                new ChangShe(new Position(7, 6), DIRECTION.RIGHT)
        );
        ground.placeCreatures(
                mstrArmy,
                //冲轭
                new ChongE(new Position(7, 8), DIRECTION.LEFT)
        );
        ground.placeCreature(
                grandpa,
                new Position(8, 3)
        );
        ground.placeCreature(
                boss,
                new Position(8, 11)
        );
        ground.report();

        ground.placeCreatures(
                mstrArmy,
                //雁行
                new HeYi(new Position(7, 11), DIRECTION.LEFT)
        );
        ground.placeCreature(
                boss,
                new Position(8, 11)
        );
        ground.report();
    }
}

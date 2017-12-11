public class theBattleField {
    private Planar planar;

    private Huluwa[] bros;
    private Minions[] minions;
    private Scorpion scorpion;
    private Snake shejing;

    public theBattleField(){
        planar= new Planar(15);

        bros=new Huluwa[7];
        for (int i=0;i<bros.length;i++){
            bros[i] = new Huluwa(Huluwa.COLOUR.values()[i], Huluwa.SENIORITY.values()[i]);
        }

        shejing=new Snake(Snake.NAME.金蛇精, Villain.LEVEL.Boss);
        scorpion=new Scorpion(Villain.LEVEL.Captain,1);

        minions=new Minions[9];
        for (int i=0;i<minions.length;i++){
            minions[i]=new Minions(i, Villain.LEVEL.Minions);
        }
    }

    public static void main(String[] args) {
        theBattleField field = new theBattleField();

        //葫芦娃入队
        Queue huluQueue =new Queue(field.bros.length);
        for(int i=0;i<field.bros.length;i++){
            huluQueue.enQueue(field.bros[i]);
        }
        new HuluShuffle().arrRandom(field.bros);
        new Sorter().bubbleSort(huluQueue);
        //蝎子精带队
        Queue villainQueue = new Queue(field.minions.length+1);
        villainQueue.enQueue(field.scorpion);
        for (int i=0;i<field.minions.length;i++){
            huluQueue.enQueue(field.minions[i]);
        }

        LineFormat lineFormator = new LineFormat();
        VshapeFormat vshapeFormator = new VshapeFormat();
        ArrowFormat arrowFormator =new ArrowFormat();
        GeeseFormat geeseFormat =new GeeseFormat();

        lineFormator.format(huluQueue,new Coordinate(4,3),field.planar);

        field.shejing.setGrid(field.planar.getGridOF(14,7));
        vshapeFormator.format(villainQueue,new Coordinate(11,10),field.planar);

        field.planar.printPlanar();
        arrowFormator.format(huluQueue,new Coordinate(4,5),field.planar);


        field.planar.cleanPlanar();




    }


}

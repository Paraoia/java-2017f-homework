public class BubbleSorter implements Sorter {
    public void sort(Camp camp) {
        Creature creature;
        Position[] positions = camp.positions;

        //System.out.print(camp.sum);
        //  positions[0].getHolder().report();
       /* for(int i=0;i<7;i++)
        {
            positions[i].getHolder().report();
        }
        */
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                if (((Comparable) (positions[i].getHolder())).biggerThan((Comparable) (positions[j].getHolder()))) {

                    creature = positions[i].getHolder();
                    Creature creature2 = positions[j ].getHolder();
                    positions[j ].setHolder(creature);
                    positions[i].setHolder(creature2);
                    creature2.setPos(positions[i]);
                    creature.setPos(positions[j ]);



                }
            }
        }
    }
}

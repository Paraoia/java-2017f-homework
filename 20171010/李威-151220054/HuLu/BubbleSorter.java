package HuLu;

public class BubbleSorter implements Sorter {
    @Override
    public void sort(Queue queue) {
    	Creature creature = null;
        Position[] positions = queue.getPositions();
       
        for (int i = 1; i < positions.length; i++) {
            for (int j = 0; j < positions.length-i; j++) {
                if (((Comparable) (positions[j].getHolder())).isBiggerThan((Comparable) (positions[j+1].getHolder()))) {
                    creature = positions[j+1].getHolder();
                    positions[j ].getHolder().setPosition(positions[j+1]);
                    creature.setPosition(positions[j]);
                }
            }
        }
    }
}

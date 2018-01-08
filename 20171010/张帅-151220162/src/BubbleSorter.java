public class BubbleSorter implements Sorter {
	public void sort(Queue queue){
		Position[] positions = queue.getQueuePositions();
		for(int i=0;i<positions.length-1;i++)
			for(int j=0;j<positions.length-i-1;j++)
				if(((Comparable)(positions[j].getHolder())).biggerThan((Comparable) (positions[j+1].getHolder()))){
					Creature creature = positions[j].getHolder();
					positions[j+1].getHolder().setQueuePosition(positions[j]);
					creature.setQueuePosition(positions[j+1]);
				}
	}
}

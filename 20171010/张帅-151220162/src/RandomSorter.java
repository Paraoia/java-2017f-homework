import java.util.Random;

public class RandomSorter implements Sorter {
	@Override
	public void sort(Queue queue) {
		Random rand = new Random();
		Position[] queuePositions = queue.getQueuePositions();
		for(int i=0;i<queuePositions.length;i++){
			int tmp = rand.nextInt(queuePositions.length);
			Creature creature = queuePositions[i].getHolder();
			queuePositions[tmp].getHolder().setQueuePosition(queuePositions[i]);
			creature.setQueuePosition(queuePositions[tmp]);
		}
	}
}

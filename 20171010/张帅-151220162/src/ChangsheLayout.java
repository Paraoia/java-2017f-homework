public class ChangsheLayout implements Layout {
	@Override
	public void place(Queue queue) {
		Position[] queuePositions = queue.getQueuePositions();
		for(int i=0;i<queuePositions.length;i++)
			queuePositions[i].setPosition(i, 0);
	}
}

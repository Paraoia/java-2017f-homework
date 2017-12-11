public class HeyiLayout implements Layout {
	@Override
	public void place(Queue queue) {
		Position[] queuePositions = queue.getQueuePositions();
		for(int i=0;i<queuePositions.length;i++) {
			if(i%2==0)
				queuePositions[i].setPosition(i/2, i/2);
			else
				queuePositions[i].setPosition(i/2, queuePositions.length-1-i/2);
		}
	}
}

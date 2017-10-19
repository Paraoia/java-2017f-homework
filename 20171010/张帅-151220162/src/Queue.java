public class Queue {
	private Position[] queuePositions; //阵型中的相对位置

	public Queue(Creature[] creatures){
		queuePositions = new Position[creatures.length];
		for(int i=0;i<creatures.length;i++) {
			queuePositions[i] = new Position(0, i);
			creatures[i].setQueuePosition(queuePositions[i]);
		}
	}

	public Position[] getQueuePositions(){
		return queuePositions;
	}
}

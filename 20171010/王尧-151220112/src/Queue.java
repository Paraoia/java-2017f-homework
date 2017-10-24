public class Queue {
	private Position []position;
	private int length;
	private int cur = 0;
	
	public Queue(int length) {
		this.length = length;
		position = new Position[length];
		for (int i = 0; i <length; i++)
			position[i] = new Position();
	}
	
	public int getLength() {
		return length;
	}
	
	public Position getPosition(int index) {
		return position[index];
	}
	
	public void enQueue(Creature creature) {
		if (cur > length - 1)
			System.out.println("Out of bound.");
		else {
			position[cur].setHolder(creature);
			cur++;
		}
	}
}

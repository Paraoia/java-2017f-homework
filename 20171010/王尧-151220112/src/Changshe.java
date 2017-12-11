public class Changshe implements Formation{
	private int xBegin, yBegin;
	private int lengthOfQueue;
	
	@Override
	public void form(Queue queue, Coordinate beginning, Space space) {
		int sideLength = space.getSideLength();
		lengthOfQueue = queue.getLength();
		xBegin = beginning.getX();
		yBegin = beginning.getY();
		
		for (int i = 0; i < lengthOfQueue; i++) {
			if (xBegin >= 0 && xBegin < sideLength && yBegin + i >= 0 && yBegin + i < sideLength) {
				if (space.getPosition(xBegin, yBegin + i).isEmpty())
					;
				else {
					System.out.println("Overlapping.");
					return;
				}
			}
			else {
				System.out.println("Space Out of bound.");
				return;
			}
		}
		
		for (int i = 0; i < lengthOfQueue; i++) {
			space.getPosition(xBegin, yBegin + i).setHolder(queue.getPosition(i).getHolder());
		}
	}
}

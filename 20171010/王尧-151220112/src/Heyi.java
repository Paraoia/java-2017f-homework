public class Heyi implements Formation{
	private int xBegin, yBegin;
	private int lengthOfQueue;
	
	@Override
	public void form(Queue queue, Coordinate beginning, Space space) {
		int sideLength = space.getSideLength();
		lengthOfQueue = queue.getLength();
		xBegin = beginning.getX();
		yBegin = beginning.getY();
		
		for (int i = 0; i < lengthOfQueue; i++) {
			int xCur = xBegin + (int)((i+1)/2*(-1));
			int yCur = yBegin + (int)((i+1)/2*Math.pow(-1,i));
			if (xCur >= 0 && xCur < sideLength && yCur >= 0 && yCur < sideLength) {
				if (space.getPosition(xCur, yCur).isEmpty())
					;
				else {
					System.out.println("Overlapping.");
				}
			}
			else {
				System.out.println("Space Out of bound.");
				return;
			}
		}
		
		for (int i = 0; i < lengthOfQueue; i++) {
			int xCur = xBegin + (int)((i+1)/2*(-1));
			int yCur = yBegin + (int)((i+1)/2*Math.pow(-1,i));
			space.getPosition(xCur, yCur).setHolder(queue.getPosition(i).getHolder());
		}
	}
}

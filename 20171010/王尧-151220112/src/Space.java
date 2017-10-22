public class Space {
	private Position position[][];
	private int sideLength;
	
	public Space(int sideLength) {
		this.sideLength = sideLength;
		position = new Position[sideLength][sideLength];
		for (int i = 0; i < sideLength; i++)
			for (int j = 0; j < sideLength; j++)
			{
				position[i][j] = new Position();
				position[i][j].setCoordinate(new Coordinate(i, j));
			}
	}
	
	public Position getPosition(int x, int y) {
		return position[x][y];
	}
	
	public int getSideLength() {
		return sideLength;
	}
	
	public void clearSpace() {
		for (int i = 0; i < sideLength; i++)
			for (int j = 0; j < sideLength; j++)
				position[i][j].setHolder(null);
	}
	
	public void printSpace() {
		for (int i = 0; i < sideLength; i++)
		{
			for (int j = 0; j < sideLength; j++)
			{
				if (position[i][j].isEmpty())
					System.out.print("     ");
				else
					System.out.print(position[i][j].getHolder().getName() + " ");
			}
			System.out.println();
		}
	}
}

public class Position {
	private Creature holder = null;
	private Coordinate coordinate;
	
	public boolean isEmpty() {
		return (holder == null);
	}
	
	public void setHolder(Creature creature) {
		this.holder = creature;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Creature getHolder() {
		return holder;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
}

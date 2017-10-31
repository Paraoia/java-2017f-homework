
public class Snake implements Creature {
	private Position position;
	
	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
		position.setHolder(this);
	}
	
	@Override 
	public void clearPosition() {
		this.position.clearHolder();
		this.position = null;
	}
	
	@Override
	public void report() {
		System.out.print("@Éß¾«");
	}
}

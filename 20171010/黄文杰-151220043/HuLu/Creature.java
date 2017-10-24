package HuLu;

public abstract class Creature {
	private String name;
	private Position position;
	
	public Creature(String name){
		this.name=name;
	}
	public abstract void report();
	public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }

	public String getName() {
		return name;
	}
}

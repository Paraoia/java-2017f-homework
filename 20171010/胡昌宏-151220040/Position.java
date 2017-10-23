
public class Position {
	private int x;
	private int y;
	private boolean is_empty;
	private Creature holder;
	public Position() {
		this.x = 0;
		this.y = 0;
		this.is_empty = true;
		this.holder = null;
	}
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		this.is_empty = true;
		this.holder = null;
	}
	
	
	public Creature getHolder() {
		return holder;
	}
	public void setHolder(Creature a) {
		this.holder = a;
		InPos();
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean Is_empty() {
		return is_empty;
	}
	public void InPos() {
		this.is_empty = false;
	}
	public void OutPos() {
		this.is_empty = true;
	}
}

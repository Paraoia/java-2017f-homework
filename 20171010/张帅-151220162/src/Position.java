public class Position {

	private int x;
	private int y;
	private boolean empty;
	private Creature holder;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
		this.empty = true;
	}

	public boolean getEmpty(){
		return empty;
	}
	public void setEmpty(){
		empty = true;
	}

	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}

	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
	}

	public Creature getHolder(){
		return holder;
	}
	public void setHolder(Creature holder){
		this.holder = holder;
		this.empty = false;
	}



}

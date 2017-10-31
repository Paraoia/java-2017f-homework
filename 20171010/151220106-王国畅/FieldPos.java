
public class FieldPos {
	private Creature holder;
	private int x,y;
	
	public Creature getHolder(){
		return holder;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setHolder(Creature holder){
		this.holder = holder;
	}
	
	public FieldPos(int x,int y){
		this.x = x;
		this.y = y;
		this.holder = null;
	}
}

package HuLu;

public class Position{
	private int x;
	private int y;
	private Creature holder;
    
	
	public Creature getHolder() {
        return holder;
    }
	
	public Creature removeHolder(){
		Creature temp=this.holder;
		this.holder=null;
		return temp;
	}
	
    public void setHolder(Creature holder) {
        this.holder = holder;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position(int x,int y){
        super();
        this.x = x;
        this.y=y;
        this.holder=null;
    }
}

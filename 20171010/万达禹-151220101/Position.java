package HuluTeam;

public class Position {
	
	private int x;
	private int y;
	private Creature holder;
	private boolean isthereCreature;
	
	public Position(int positionx, int positiony) {
		this.x = positionx;
		this.y = positiony;
		this.isthereCreature = false;
	}
	
	public void SetHolder(Creature a) {
		this.holder = a;
		this.isthereCreature = true;
	}
	
	public void DeleteHolder() {
		this.holder = null;
		this.isthereCreature = false;
	}
	
	public void SetPosition(int positionx, int positiony) {
		this.x = positionx;
		this.y = positiony;
	}
	
	public int GetPositionX() {
		return this.x;
	}
	
	public int GetPositionY() {
		return this.y;
	}
	
	public Creature GetHolder() {
		return this.holder;
	}
	
	public void report() {
		if(isthereCreature == true)
			this.holder.report();
		else System.out.print("¡£  ");
	}
}

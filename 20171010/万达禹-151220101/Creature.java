package HuluTeam;

public class Creature {
	
	protected String name;
	protected Position position;
	
	Creature(String n){
		this.name = n;
	}
	
	public String getname() {
		return this.name;
	}
	
	public void report() {
		System.out.print(this.toString()+"  ");
	}
	
	public void setPosition(int x, int y) {
		Position p = new Position(x, y);
		this.position = p;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public String toString() {
		 return this.name;
	}
}

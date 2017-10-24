package huluwa;

public class Goblin extends Creature{
	private Number number;
	
	public Goblin() {
	}
	
	public Goblin(Number number) {
		setName(number.toString());
		setProperty(false);
		setActivity(State.BATTLER);
	}
	
	public String getNumber() {
		return number.toString();
	}
	
	public void setNumber(Number number) {
		this.number=number;
	}
}
		
enum Number{
	ONE,TWO,THREE,FOUR,FIVE,SIX;
}



public class Grandpa implements Creature{ 
	private Position position;
	
	 public void report() {
		   System.out.print("үү"+'\t');
	   }
		public void setPosition(Position position) {
			this.position = position;
			position.setHolder(this);
			position.InPos();
		}
		public Position getPosition() {
			return this.position;
		}
}

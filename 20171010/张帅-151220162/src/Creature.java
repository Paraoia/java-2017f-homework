public class Creature {

	private Position position;
	private Position queuePosition;

	public void report(){
		System.out.print(this.toString());
	}

	public void setQueuePosition(Position queuePosition){
		this.queuePosition = queuePosition;
		queuePosition.setHolder(this);
	}

	public Position getQueuePosition(){
		return queuePosition;
	}

	public void setPosition(Position position){
		this.position = position;
		position.setHolder(this);
	}

	public Position getPosition(){
		return position;
	}
}

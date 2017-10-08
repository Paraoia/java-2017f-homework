public class Queue {
	public Position[] positions;
	
	public Queue() {
		positions = new Position[7];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = new Position();
            positions[i].holder = null;
        }
	}
	
	 public void enqueue(Huluwa[] hlw) {

	        if (hlw.length > this.positions.length) {
	            return; //actually should throw exception
	        }
	        
	        positions[0].holder = hlw[1];
	        positions[1].holder = hlw[2];
	        positions[2].holder = hlw[6];
	        positions[3].holder = hlw[4];
	        positions[4].holder = hlw[3];
	        positions[5].holder = hlw[5];
	        positions[6].holder = hlw[0];

	    }
}

class Position {
	public Huluwa holder;
}
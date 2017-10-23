package HuLu;


public class Space {
	
	private int row_num;
	private Position[][] positions;
	
	
	public Position[][] getPositions() {
	    return positions;
	}
	
	public int getRownum() {
		return row_num;
	}
	
	public Space(int n) {
	    this.row_num=n;
	    this.positions = new Position[n][n];
	    for (int i = 0; i < n; i++) {
	        for(int j=0;j<n;j++){
	            this.positions[i][j] = new Position(i,j);
	        }
	    }
	}
	
	public void setCreature(Creature creature,int x,int y) {
	    creature.setPosition(this.positions[x][y]);
	}
	

	public void spaceShow() {
	    for (int i=0;i<row_num;i++) {
	        for(int j=0;j<row_num;j++){
//	        	System.out.print(i+",");
//	        	System.out.print(j);
//	        	System.out.print(positions[i][j].getOwned()+"  ");
	            if(positions[i][j].getOwned()) {
	                positions[i][j].getHolder().show();
	            }
	            else{
	                System.out.print(String.format("%-15s",("#"+"("+i+","+j+")")));
	            }
	        }
	        System.out.print("\n");
	    }
	    System.out.print("\n\n");
	}
	
	public void cleanSpace(){
	    for (int i=0;i<row_num;i++) {
	        for (int j = 0; j < row_num; j++) {
	            positions[i][j].setHolder(null);
	            positions[i][j].setOwned(false);
	        }
	    }
	}
}
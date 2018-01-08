package HuLu;
//enum DIRECTION{ROW,LINE}
public class BubbleSorter implements Sorter {

	@Override
	public void sortRow(Space space,int startX,int startY,int len) {
		Position [][]positions=space.getPositions();
		
		for(int i=0;i<len;i++){
			for(int j=0;j<len-i-1;j++){
				
		
				
				
					if (((Comparable) (positions[startX+j][startY].getHolder())).isBiggerThan((Comparable) (positions[startX+j+1][startY].getHolder()))) {
	                    Creature creature = positions[startX+j][startY].getHolder();
	                    positions[startX+j+1][startY].getHolder().setPosition(positions[startX+j][startY]);
	                    creature.setPosition(positions[startX+j+1][startY]);
	                }
				
			}
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void sortCol(Space space,int startX,int startY,int len) {
		Position [][]positions=space.getPositions();
		
		for(int i=0;i<len;i++){
			for(int j=0;j<len-i-1;j++){
				
					
				
					if (((Comparable) (positions[startX+j][startY].getHolder())).isBiggerThan((Comparable) (positions[startX+j+1][startY].getHolder()))) {
	                    Creature creature = positions[startX+j][startY].getHolder();
	                    positions[startX+j+1][startY].getHolder().setPosition(positions[startX+j][startY]);
	                    creature.setPosition(positions[startX+j+1][startY]);
	                }
				
			}
		}
		// TODO Auto-generated method stub

	}
}

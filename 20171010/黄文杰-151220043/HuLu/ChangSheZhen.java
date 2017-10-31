package HuLu;

public class ChangSheZhen implements ZhenArranger {

	@Override
	public boolean arrange(Space space,int startX,int startY, Creature []creatures, int creatureNum) {
		
		int length=space.getLength();
		//int width=space.getWidth();
		
		if(startX+creatureNum>=length)
			return false;
		Position[][] positions=space.getPositions();
		
		for(int i=0;i<creatureNum;i++){
			creatures[i].setPosition(positions[startX+i][startY]);
		}
		// TODO Auto-generated method stub
		return true;
	}

}

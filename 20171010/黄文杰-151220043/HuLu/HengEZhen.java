package HuLu;

public class HengEZhen implements ZhenArranger {

	@Override
	public boolean arrange(Space space, int startX, int startY, Creature[] creatures, int creatureNum) {
		// TODO Auto-generated method stub
		int length=space.getLength();
		if(startX+creatureNum>=length)
			return false;
		Position[][] positions=space.getPositions();
		for(int i=0;i<creatureNum;i++){
			creatures[i].setPosition(positions[startX+i][startY+i%2]);
		}
		return true;
	}

}

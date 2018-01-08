package HuLu;

public class ZhenChangshe implements ZhenInterface{

	@Override
	public boolean arrange(Space space,int x,int y, Creature []creatures) {
		
		int length=space.getRownum();
		int creatureNum=creatures.length;
		 if(x<0||y<0||x>=length||y>=length||x+creatureNum>length){
		        System.out.println("…ﬂ–Œ’Û ≤º’Û ß∞‹");
		        return false;
		    }
		
		for(int i=0;i<creatureNum;i++){
			creatures[i].setPosition(space.getPositions()[x+i][y]);
		}
		return true;
	}

}
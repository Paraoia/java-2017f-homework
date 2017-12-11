package HuLu;

public class ZhenYanhang implements ZhenInterface{

	@Override
	public boolean arrange(Space space,int x,int y, Creature []creatures) {
		
		int length=space.getRownum();
		int creatureNum=creatures.length;
		
		if(x<0||y<0||x>=length||y>=length||x-creatureNum+1<0||y+creatureNum>length){
		    System.out.println("—„––’Û ≤º’Û ß∞‹");
		    return false;
		}
	
		
		
		for(int i=0;i<creatureNum;i++){
		    creatures[i].setPosition(space.getPositions()[x-i][y+i]);
		}
		
		return true;
	}

}




package HuLu;

public class ZhenHeyi implements ZhenInterface{

	@Override
	public boolean arrange(Space space,int x,int y, Creature []creatures) {
		
		int length=space.getRownum();
		int creatureNum=creatures.length;
		
		if(x<0||y<0||x>=length||y>=length||x-(creatureNum)/2<0||y-(creatureNum)/2<0||y+(creatureNum)/2>length){
		    System.out.println("º×ÒíÕó ²¼ÕóÊ§°Ü");
		    return false;
		}
		
		
		for(int i=0;i<creatureNum;i++){
		    if(i%2==0)
		        creatures[i].setPosition(space.getPositions()[x-i/2][y+i/2]);
		    else
		        creatures[i].setPosition(space.getPositions()[x-(i+1)/2][y-(i+1)/2]);
		}
		
		return true;
	}

}




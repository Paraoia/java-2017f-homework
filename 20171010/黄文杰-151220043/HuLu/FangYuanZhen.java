package HuLu;

public class FangYuanZhen implements ZhenArranger{//数量为奇数时，会将多余的一个放在下方尾部
	
	@Override
	public boolean arrange(Space space,int startX,int startY, Creature []creatures, int creatureNum) {
		
		int length=space.getLength();
		int row=creatureNum/2+1;
		
		int width=space.getWidth();
		int row_dis=row/2-row%2==0?1:0;
		if(startX+row>=length||(row_dis+startY>width||startY-row_dis<0))
			return false;
		Position[][] positions=space.getPositions();
		int row_i=0,index=0;
		creatures[index].setPosition(positions[startX][startY]);
		row_i++;
		index++;
		for(;row_i<row/2;row_i++,index+=2){
			creatures[index].setPosition(positions[startX+row_i][startY-row_i]);
			creatures[index+1].setPosition(positions[startX+row_i][startY+row_i]);
		}
		int j;
		if(row%2==1){
			creatures[index].setPosition(positions[startX+row_i][startY-row_i]);
			creatures[index+1].setPosition(positions[startX+row_i][startY+row_i]);
			row_i++;
			j=row_i-2;
			index+=2;
		}
		else
			j=row_i-1;
		for(;j>0;j--){
			
			creatures[index].setPosition(positions[startX+row_i][startY-j]);
			creatures[index+1].setPosition(positions[startX+row_i][startY+j]);
			row_i++;
			index+=2;
		}
		if(index==creatureNum-1)
			creatures[index].setPosition(positions[startX+row_i][startY]);
		else{
			creatures[index].setPosition(positions[startX+row_i][startY]);
			creatures[index+1].setPosition(positions[startX+row_i+1][startY]);
		}
		// TODO Auto-generated method stub
		return true;
	}

}

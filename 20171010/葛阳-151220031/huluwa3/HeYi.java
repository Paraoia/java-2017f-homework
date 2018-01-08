package huluwa3;

public class HeYi implements positionSetter
{
	@Override
	public void setPosition(Queue queue,Position[][] positions)
	{
		Creature[] creatures=queue.getCreatures();		
		Position first=creatures[0].getPosition();
		
		for (int i=1;i<creatures.length/2+1;i++)
		{
			
			creatures[i].setPosition(positions[first.getX()+i][first.getY()+i]);
		}
		
		for (int i=creatures.length/2+1;i<creatures.length;i++)
		{
			
			creatures[i].setPosition(positions[first.getX()+creatures.length-i-1][first.getY()+i]);
		}
	}
}

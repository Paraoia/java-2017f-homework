package huluwa3;

public class ChangShe implements positionSetter{
	@Override
	public void setPosition(Queue queue,Position[][] positions)
	{
		Creature[] creatures=queue.getCreatures();		
		Position first=creatures[0].getPosition();
		
		for (int i=1;i<creatures.length;i++)
		{
			creatures[i].setPosition(positions[first.getX()+i][first.getY()]);
		}
	}

}

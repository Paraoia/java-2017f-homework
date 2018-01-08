package huluwa3;

public class FengShi implements positionSetter
{
	@Override
	public void setPosition(Queue queue,Position[][] positions)
	{
		Creature[] creatures=queue.getCreatures();
		
		int part=(creatures.length-creatures.length%3-3)/3;
		Position temp=positions[creatures[0].getPosition().getX()][creatures[0].getPosition().getY()+part];
		creatures[0].setPosition(temp);
		Position first=creatures[0].getPosition();
		
		for (int i=1;i<=part;i++)
		{
			
			creatures[i].setPosition(positions[first.getX()+i][first.getY()-2*i]);
		}
		
		for (int i=part+1;i<part*2+3+creatures.length%3;i++)
		{
			
			creatures[i].setPosition(positions[first.getX()+i-part][first.getY()]);
		}
		
		for (int i=part*2+3+creatures.length%3;i<creatures.length;i++)
		{
			
			int space=i-part*2-3-creatures.length%3+1;
			creatures[i].setPosition(positions[first.getX()+space][first.getY()+space*2]);
		}
	}
}


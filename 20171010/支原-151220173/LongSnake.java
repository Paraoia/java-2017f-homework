public class LongSnake extends Queue {
    LongSnake(Battle battle)
    {
        num=7;
        positions=new Position[7];
        for(int i=0;i<7;i++)
        {
            positions[i]=battle.getPosition(2+i,1);
        }
    }
}

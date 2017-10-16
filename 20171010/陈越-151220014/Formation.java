package huluwa;

public class Formation {
    public Position [][]positions;
    protected int num;
    protected int LouLuoNum;
    public Formation()
    {

    }
    public void initial(int n,int m)
    {
        num = n;
        LouLuoNum = m;
        positions = new Position[n][];
        for(int i=0;i<n;i++)
        {
            positions[i]=new Position[n];
            for(int j=0;j<n;j++)
            {
                positions[i][j]= new Position();
                positions[i][j].setHolder(new Nothing());
            }
        }
    }
    public void StandInSpace(Position position[][],int n,int m)
    {
        for(int i = 0;i<num&&n+i<num;i++)
        {
            for(int j=0;j<num&&m+j<num;j++)
                positions[i][j].getHolder().sit(position[n+i][m+j]);
        }
    }
}

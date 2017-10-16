public class Space //二维坐标表示的空间
{
    public static final int N = 11;
    private Position [][]positions;
    Space()
    {
        positions = new Position[N][N];
        int i, j;
        for(i = 0; i < N; i++)
            for(j = 0; j < N; j++)
            {
                positions[i][j] = new Position(i, j);//初始化N*N个位置
            }
    }
    public Position getPosition(int x, int y)
    {
        return positions[x][y];
    }
    public void Output() //输出当前局面
    {
        int i,j ;
        for( i = 0; i < N; i++)
        {
            for (j = 0; j < N; j++)
            {
                if (!positions[i][j].ifEmpty())
                {
                   positions[i][j].getHolder().report();
                }
                else
                     System.out.print("    ");
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}

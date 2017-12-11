
public class Space {
    private static final int N = 20;   //定义二维空间的大小为 N * N
    Position[][] map = new Position[N][N];
    /* 构造函数，初始化世界空间 */
    Space(){
        int i, j;
        for(i=0; i<N; i++)
            for(j=0; j<N; j++)
            {
                map[i][j] = new Position();
            }
    }

    /* 获取二维空间的大小 */
    int GetSize(){
        return N;
    }

    /* 清除空间上的蝎子、啰喽、爷爷、蛇精 */
    void clean_some_creatures(){
        int i, j;
        for(i=0; i<N; i++)
            for(j=0; j<N; j++)
            {
                if(map[i][j].taken == true && (map[i][j].holder.name == "蝎子" || map[i][j].holder.name == "喽啰"
                        || map[i][j].holder.name == "爷爷" || map[i][j].holder.name == "蛇精"))
                {
                    map[i][j].Reset();
                }
            }
    }

    /* 打印出空间状况分布 */
    void presentSpace() {
        int i,j;
        for(i=0; i<N; i++) {
            for (j = 0; j < N; j++) {
                if (map[i][j].taken == false)
                    //为了使空间打印出来显示整齐，将每一个position的显示大小设置为4个byte...
                    System.out.print("----");
                else{
                    if(map[i][j].holder.pattern == 'O')
                        System.out.print(map[i][j].holder.name);
                    else
                        System.out.print(map[i][j].holder.name);
                }
            }
            System.out.println();
        }
    }
}

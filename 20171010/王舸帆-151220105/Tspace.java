/**
 * Created by macbook on 2017/10/15.
 */
public class Tspace {
        private static final int N = 40;   //定义二维空间的大小为 N * N
        Hulu[][] tspace = new Hulu[N][N];
        //初始化tspace
        Tspace(){
            for(int i=0; i<N; i++)
                for(int j=0; j<N; j++)
                {
                    tspace[i][j] = new Hulu();
                }
        }
        //打印tspace
        public void printTspace() {
            for(int i=0; i<N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tspace[i][j].free == true)
                        System.out.print("     ");
                    else{
                        tspace[i][j].getHolder().baogao();
                    }
                }
                System.out.println();
            }
        }

        public void cleanTspace(){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    tspace[i][j].free=true;
                }
            }
        }
}

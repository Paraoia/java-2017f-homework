/**
 * Created by macbook on 2017/10/17.
 */
public class B_sort implements Sorter {
    public void sort(Tspace tspace,Renwu renwus[],int h,int l){
        Renwu renwu1;
        for (int i = 0; i < renwus.length - 1; i++) {
            for (int j = 0; j < renwus.length - 1 - i; j++) {
                if (((Comparable) (tspace.tspace[h][l].getHolder())).biggerThan((Comparable) (tspace.tspace[h+1][j+l].getHolder()))) {
                    renwu1 = tspace.tspace[h+1][l+j].getHolder();
                    tspace.tspace[h+1][l+j].setHolder(tspace.tspace[h][l+j].getHolder());
                    tspace.tspace[h][l+j].setHolder(renwu1);
                }
            }
        }
    }
}

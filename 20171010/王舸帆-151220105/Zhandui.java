/**
 * Created by macbook on 2017/10/14.
 */
public class Zhandui {

    public void she(Tspace tspace,Renwu renwus[],int h,int l){
        for(int i=0;i<7;i++,h++){
            if(tspace.tspace[h][l].free== true) {
                tspace.tspace[h][l].setHolder(renwus[i]);
                tspace.tspace[h][l].free = false;
            }
        }
    }

    public void yeye(Tspace tspace,Renwu renwu,int h,int l){
        if(tspace.tspace[h][l].free== true){
            tspace.tspace[h][l].setHolder(renwu);
            tspace.tspace[h][l].free=false;
        }
    }

    public void shejing(Tspace tspace,Renwu renwu,int h,int l){
        if(tspace.tspace[h][l].free== true){
            tspace.tspace[h][l].setHolder(renwu);
            tspace.tspace[h][l].free=false;
        }
    }

    public void yan(Tspace tspace,Renwu renwus[],int h,int l){  //h:蝎子精的行数 l:蝎子精的列数
        if(tspace.tspace[h][l].free== true){
            tspace.tspace[h][l].setHolder(renwus[0]);
            tspace.tspace[h][l].free=false;
        }
        h++;
        l--;
        for(int i = 1; i<renwus.length; i++, h++, l--){
            if(tspace.tspace[h][l].free== true) {
                tspace.tspace[h][l].setHolder(renwus[i]);
                tspace.tspace[h][l].free = false;
            }
        }
    }
    public void he(Tspace tspace,Renwu renwus[],int h,int l){
        if(tspace.tspace[h][l].free== true){
            tspace.tspace[h][l].setHolder(renwus[0]);
            tspace.tspace[h][l].free=false;
        }
        h++;int h1=h;
        l--;int l1=l;
        for(int i = 1; i<(renwus.length)/2; i++, h1++, l1--){
            if(tspace.tspace[h1][l1].free== true) {
                tspace.tspace[h1][l1].setHolder(renwus[i]);
                tspace.tspace[h1][l1].free = false;
            }
        }
        l=l+2;
        for(int i = (renwus.length)/2; i<renwus.length; i++, h++, l++){
            if(tspace.tspace[h][l].free== true) {
                tspace.tspace[h][l].setHolder(renwus[i]);
                tspace.tspace[h][l].free = false;
            }
        }
    }
}

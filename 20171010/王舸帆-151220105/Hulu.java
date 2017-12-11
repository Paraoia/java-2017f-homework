/**
 * Created by macbook on 2017/10/11.
 * 这是葫芦娃，蛇精，蝎子精等的容身之地。
 */
public class Hulu {

    public Renwu getHolder() {
        return holder;
    }

    public void setHolder(Renwu holder) {
        this.holder = holder;
    }//把人物放进去

    public Renwu holder;

    public boolean free;//true表示空的可以放置人物

    Hulu(){
        holder=null;
        free=true;
    }
}

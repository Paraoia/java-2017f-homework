/**
 * Created by macbook on 2017/10/14.
 */
public class Shejing implements Renwu{
    Hulu hulu;
    String name;
    public void setHulu(Hulu hulu){
        this.hulu=hulu;
        hulu.setHolder(this);
    }

    public Hulu getHulu(){
        return hulu;
    }
    public void baogao(){
        System.out.print(name);
    }
    Shejing(String name){
        this.name=name;
    }
}

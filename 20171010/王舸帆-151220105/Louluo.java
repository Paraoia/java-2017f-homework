/**
 * Created by macbook on 2017/10/14.
 */
public class Louluo implements Renwu {
    public String name;
    public Hulu hulu;
    public void baogao() {
        System.out.print(name);
    }
    public void setHulu(Hulu hulu){
        this.hulu=hulu;
        hulu.setHolder(this);
    }

    public Hulu getHulu(){
        return hulu;
    }
    Louluo(String name){
        this.name=name;
    }
}

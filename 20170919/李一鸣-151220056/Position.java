public class Position {
    private HuLuWa cha;
    public Position(HuLuWa tmp){
        cha = tmp;
    }
    public void show(){
        cha.showrank();
    }
    public boolean larger(Position tmp){
        if ( this.cha.cmp1(tmp.cha) )
            return true;
        return false;
    }
}

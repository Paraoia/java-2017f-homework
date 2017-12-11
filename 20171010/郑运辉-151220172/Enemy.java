public class Enemy extends Soldier{
    //构造函数
    public Enemy(int row,int col,ENEMYTYPE e){
        super(row,col);
        type=TYPE.坏人;
        if(e==ENEMYTYPE.蝎子精) mark=MARK.蝎;
        else mark=MARK.喽;
    }
}


enum ENEMYTYPE{
    蝎子精,喽啰
}
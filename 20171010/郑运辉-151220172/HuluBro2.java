public class HuluBro2 {
    public static void main(String []args){
        //初始化二维空间
        int spaceSize=10;
        Space s=Space.CreateSpace(spaceSize);

        //初始化葫芦娃
        int huluwaSize=7;
        battleGroup huluGroup=new battleGroup(TYPE.葫芦兄弟,huluwaSize,Huluwa.Ramdom(huluwaSize));

        //初始化蝎子精和小喽啰
        int enemySize=7;
        battleGroup badGroup=new battleGroup(TYPE.坏人,enemySize);

        //初始化爷爷
        Yeye yeye=new Yeye(0,0);
        yeye.setOnSpace();

        //初始化蛇精
        Snake snake=new Snake(0,9);
        snake.setOnSpace();

        //输出空间
        s.print();

        //重新站阵
        huluGroup.ChangShe(0,1);
        badGroup.ChongE(1,5);

        //输出空间
        s.print();

        //重新站阵
        huluGroup.ChongE(1,1);
        badGroup.ChangShe(1,5);

        //输出空间
        s.print();
    }
}

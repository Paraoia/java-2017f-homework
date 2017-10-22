import java.util.*;

public class main {
    public static void main(String[] args) {
        //初始化爷爷
        Grandpa pa = new Grandpa();
        //初始乱序七兄弟
        pa.ShuffleCalabash();
        //让七个兄弟按长蛇形依序（老大至老七）站队
        pa.SortCalabash();
        //初始化二维空间
        Position position = new Position();
        //初始化蝎子精和小喽啰
        Scorpion sc = new Scorpion();
        //将葫芦兄弟的长蛇阵营和蝎子精小喽啰的鹤翼阵营放置于二位空间中，形成对峙局面；
        position.SnakeArray(2, 8, pa.calabashes);
        position.CraneWingArray(5, 1, sc.Minions);
        //爷爷为葫芦娃加油助威
        position.AddCreature(5, 6, pa);
        //初始化蛇精
        Snake sn = new Snake();
        //蛇精给蝎子精小喽啰加油助威
        position.AddCreature(5, 4, sn);
        //打印对峙局面
        position.Echo();
        System.out.println();
        //移除蝎子精小喽啰阵营
        position.RemoveCreature(CreatureType.Scorpion);
        position.RemoveCreature(CreatureType.Minion);
        //将蝎子精小喽啰阵营变换为冲轭阵
        position.BluntYokeArray(2,1,sc.Minions);
        //打印对峙局面
        position.Echo();
    }
}

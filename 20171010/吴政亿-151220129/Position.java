import java.util.*;

public class Position {
    private int N;//定义二维数组的宽度和高度
    private Creature[][] Point;//定义二维数组

    public Position() {
        SetN(11);
    }

    //更改二维数组宽度和高度
    public void SetN(int N) {
        this.N = N;
        Point = new Creature[N][N];
        InitPoint();
    }

    //初始化二维数组Creature
    private void InitPoint() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                Point[i][j] = new Creature();
    }

    //打印当前位置信息
    public void Echo() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!Point[i][j].HaveCreature())
                    System.out.print("\t");
//                    System.out.print("[" + i + "][" + j + "]");
                Point[i][j].Echo();
            }
            System.out.println();
        }
    }

    //设置[x][y]的生物
    public boolean AddCreature(int x, int y, Creature creature) {
        if (Point[x][y].HaveCreature()) {
            System.out.println("Sorry, [" + x + "][" + y + "] has a Creature.");
            return false;
        }
        Point[x][y] = creature;
        return true;
    }

    //长蛇阵
    public boolean SnakeArray(int x, int y, Queue creatures) {
        if (x + creatures.Size() > N) {
            System.out.println("Your team is too long, or N is too small");
            return false;
        }
        for (int i = 0; i < creatures.Size(); i++) {
            if (Point[x + i][y].HaveCreature()) {
                System.out.println("Sorry, [" + (x + i) + "][" + y + "] has a Creature.");
                return false;
            }
        }
        for (int i = 0; i < creatures.Size(); i++) {
            AddCreature(x + i, y, creatures.GetCreature(i));
        }
        return true;
    }

    //鹤翼阵
    public boolean CraneWingArray(int x, int y, Queue creatures) {
        int mid = creatures.Size() / 2 + 1;
        //判断是否覆盖其他生物
        for (int i = 0; i < mid; i++) {
            if (Point[x - i][y + i].HaveCreature()) {
                System.out.println("Sorry, [" + (x - i) + "][" + (y + i) + "] has a Creature.");
                return false;
            }
            //当下半部分是x等于1或者循环到最后有奇数个生物时要跳过
            if (!(i == 0 || (i == mid - 1 && creatures.Size() % 2 == 1)))
                if (Point[x + i][y + i].HaveCreature()) {
                    System.out.println("Sorry, [" + (x + i) + "][" + (y + i) + "] has a Creature.");
                    return false;
                }
        }
        //布阵
        int num = 0;
        for (int i = 0; i < mid; i++) {
            AddCreature(x - i, y + i, creatures.GetCreature(num));
            num++;
            if (!(i == 0 || (i == mid - 1 && creatures.Size() % 2 == 0))) {
                AddCreature(x + i, y + i, creatures.GetCreature(num));
                num++;
            }

        }
        return true;
    }

    //冲轭阵
    public boolean BluntYokeArray(int x, int y, Queue creatures) {
        if (x + creatures.Size() > N || y + 1 > N) {
            System.out.println("Your team is too long, or N is too small");
            return false;
        }
        for (int i = 0; i < creatures.Size(); i++) {
            if (Point[x + i][y + i % 2].HaveCreature()) {
                System.out.println("Sorry, [" + (x + i) + "][" + (y + i % 2) + "] has a Creature.");
                return false;
            }
        }
        for (int i = 0; i < creatures.Size(); i++) {
            AddCreature(x + i, y + i % 2, creatures.GetCreature(i));
        }
        return true;
    }

    //移除指定类型的生物
    public void RemoveCreature(CreatureType type) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (Point[i][j].type == type)
//                    Point[i][j].type = CreatureType.Null;
                    Point[i][j] = new Creature();
    }
}

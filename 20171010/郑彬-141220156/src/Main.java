
public class Main {
    public static void main(String []args) {
        Plane plane = new Plane(20);

        Grandpa Yeye = new Grandpa();
        Creature huLuBro[] = new Creature[] {
                new HuLuWa(COLOR.绿, SENIORITY.四),
                new HuLuWa(COLOR.黄, SENIORITY.三), new HuLuWa(COLOR.青, SENIORITY.五),
                new HuLuWa(COLOR.橙, SENIORITY.二), new HuLuWa(COLOR.蓝, SENIORITY.六),
                new HuLuWa(COLOR.赤, SENIORITY.一), new HuLuWa(COLOR.紫, SENIORITY.七)
        };

        Creature sheJingMen[] = new Creature[] {
                new SheJing(),
                new XieZiJing(), new XieZiJing(),
                new XiaoLouLuo(), new XiaoLouLuo(),
                new XieZiJing(), new XieZiJing()
        };

        System.out.println("----------------------------------------------------------");

        System.out.println("    长蛇葫芦娃   V.S.   峰矢蛇精们");
        plane.addFormation(new Point(4,4), Formation.CHANGSHE, huLuBro);
        plane.addCreature(new Point(4, 6), Yeye);
        plane.addFormation(new Point(4,12), Formation.FENGSHI.UD(), sheJingMen);
        plane.print();

        System.out.println("----------------------------------------------------------");

        System.out.println("    长蛇葫芦娃   V.S.   衡轭蛇精们");
        plane.clear();
        plane.addFormation(new Point(4,4), Formation.CHANGSHE, huLuBro);
        plane.addCreature(new Point(4, 6), Yeye);
        plane.addFormation(new Point(4,12), Formation.HENGE.EX().UD(), sheJingMen);
        plane.print();

        System.out.println("----------------------------------------------------------");

        System.out.println("    长蛇葫芦娃   V.S.   鹤翼蛇精们");
        plane.clear();
        plane.addFormation(new Point(4,4), Formation.CHANGSHE, huLuBro);
        plane.addCreature(new Point(4, 6), Yeye);
        plane.addFormation(new Point(4,12), Formation.HEYI.UD(), sheJingMen);
        plane.print();

        System.out.println("----------------------------------------------------------");
    }
}

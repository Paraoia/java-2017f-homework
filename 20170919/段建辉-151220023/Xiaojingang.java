public class Xiaojingang {
    protected int rank;
    protected Color color;
    protected enum Color {QICAI, RED, ORANGE, YELLOW, GREEN, VERDANT, BLUE, PURPLE};
    protected String name;

    Xiaojingang() {
        rank = 0;
        color = Color.QICAI;
        name = "小金刚";
    }

    int getRank() {
        return rank;
    }

    Color getColor() {
        return color;
    }

    String getName() {
        return name;
    }
    void talk() {
        System.out.println("小金刚");
    }

    void Skill(int r) {
        switch (r) {
            case 1: System.out.println("我有力壮术、巨大化的技能！"); break;
            case 2: System.out.println("我有千里眼、顺风耳的技能！"); break;
            case 3: System.out.println("我有刀枪不入的技能！"); break;
            case 4: System.out.println("我有火攻、吸纳火焰、霹雳的技能！"); break;
            case 5: System.out.println("我有洪击、蓄水、闪电的技能！"); break;
            case 6: System.out.println("我有隐身的技能！"); break;
            case 7: System.out.println("哈哈哈！我有神葫芦！"); break;
            default: {talk();
                System.out.println("我可以打败蛇精！"); break;}
        }
    }
}

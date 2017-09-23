public class Sanwa extends Xiaojingang {
    Sanwa() {
        rank = 3;
        color = Color.YELLOW;
        name = "三娃";
    }
    @Override
    void talk() {
        System.out.print("三娃");
    }

    void skill() {
        Skill(3);
    }
}

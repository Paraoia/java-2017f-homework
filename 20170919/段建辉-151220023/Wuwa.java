public class Wuwa extends Xiaojingang {
    Wuwa() {
        rank = 5;
        color = Color.CYAN;
        name = "五娃";
    }
    @Override
    void talk() {
        System.out.print("五娃");
    }
    void skill() {
        Skill(5);
    }
}

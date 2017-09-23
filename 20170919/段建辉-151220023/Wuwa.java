public class Wuwa extends Xiaojingang {
    Wuwa() {
        rank = 5;
        color = Color.VERDANT;
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

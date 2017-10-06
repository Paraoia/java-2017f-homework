//制片人：生成了爷爷，并且控制爷爷完成操作

public class Producer {
    public static void main(String args[]) {

        Grandpa a = new Grandpa();
        a.init();

        a.disturb();
        a.show();
        a.sortByRank();

        a.disturb();
        a.show();
        a.sortByColor();

    }
}

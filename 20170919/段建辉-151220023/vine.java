import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class vine {
    private static Dawa dawa = new Dawa();
    private static Erwa erwa = new Erwa();
    private static Sanwa sanwa = new Sanwa();
    private static Siwa siwa = new Siwa();
    private static Wuwa wuwa = new Wuwa();
    private static Liuwa liuwa = new Liuwa();
    private static Qiwa qiwa = new Qiwa();
    private static Xiaojingang[] creatures = new Xiaojingang[7];
    /* COMPOSITION. */
    private static Position positions = new Position(creatures);
    /* Vine has method for creatures to sort in rank order. */
    static void rankSort() {
        positions.rankSort();
    }
    /* Vine has method for creatures to sort in color order. */
    static void colorSort() {
        positions.colorSort();
    }
    /* Set order for creatures, and set it in descending order. */
    static void setOrder() {
        creatures[0] = qiwa;
        creatures[1] = liuwa;
        creatures[2] = wuwa;
        creatures[3] = siwa;
        creatures[4] = sanwa;
        creatures[5] = erwa;
        creatures[6] = dawa;
    }
    static void finishedOrder(int c) {
        switch (c) {
            case 0:
                for(int i = 0; i < 6; i++)
                    System.out.print(creatures[i].talkName() + "->");
                System.out.println(creatures[6].talkName());
                break;
            case 1:
                for(int i = 0; i < 6; i++)
                    System.out.print(creatures[i].getColor() + "->");
                System.out.println(creatures[6].getColor());
                break;
            default: break;
        }
    }
}

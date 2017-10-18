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
    static Xiaojingang[] huluwa = new Xiaojingang[7];
    /* COMPOSITION. */
    private static Position positions = new Position(huluwa);

    /* Vine has method for huluwas to sort in rank order. */
    static void rankSort() {
        positions.rankSort();
    }
    /* Vine has method for huluwas to sort in color order. */
    static void colorSort() {
        positions.colorSort();
    }
    /* Set order for huluwas, and set it in descending order. */
    static void setOrder() {
        huluwa[0] = qiwa;
        huluwa[1] = liuwa;
        huluwa[2] = wuwa;
        huluwa[3] = siwa;
        huluwa[4] = sanwa;
        huluwa[5] = erwa;
        huluwa[6] = dawa;
    }
    static void finishedOrder(int c) {
        switch (c) {
            case 0:
                for(int i = 0; i < 6; i++)
                    System.out.print(huluwa[i].talkName() + "->");
                System.out.println(huluwa[6].talkName());
                break;
            case 1:
                for(int i = 0; i < 6; i++)
                    System.out.print(huluwa[i].talkColor() + "->");
                System.out.println(huluwa[6].talkColor());
                break;
            default: break;
        }
    }
}

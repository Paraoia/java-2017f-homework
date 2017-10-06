public class grandFather {
    static Dawa dawa = new Dawa();
    static Erwa erwa = new Erwa();
    static Sanwa sanwa = new Sanwa();
    static Siwa siwa = new Siwa();
    static Wuwa wuwa = new Wuwa();
    static Liuwa liuwa = new Liuwa();
    static Qiwa qiwa = new Qiwa();
    /* First grandfather calls all huluwas and generates 7 positions. */
    static Xiaojingang[] huluwa = new Xiaojingang[7];
    static Position positions = new Position(huluwa);

    /* Set order for huluwas, and set it in descending order. */
    public static void setOrder(Xiaojingang[] huluwa) {
        huluwa[0] = qiwa;
        huluwa[1] = liuwa;
        huluwa[2] = wuwa;
        huluwa[3] = siwa;
        huluwa[4] = sanwa;
        huluwa[5] = erwa;
        huluwa[6] = dawa;
    }
    /* Grandfather messages huluwas to sort in rank order. */
    public static void rankSort() {
        positions.rankSort();
    }
    /* Grandfather messages huluwas to sort in color order. */
    public static void colorSort() {
        positions.colorSort(0, 6);
    }
    /* Using talk function to messaging. */
    public static void talkSkill(Xiaojingang[] huluwa) {
        for(int i = 0; i < 7; i++)
            huluwa[i].talkSkill();
    }
    public static void finishedOrder(int c) {
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
    public static void main(String arg[]) {
        setOrder(huluwa);
        /* Sort according Rank. */
        rankSort();
        System.out.println("Rank sort finished.");
        finishedOrder(0);
        setOrder(huluwa);
        /* Sort according Color. */
        colorSort();
        System.out.println("Color sort finished.");
        finishedOrder(1);
        /* Test function. */
        talkSkill(huluwa);
    }
}

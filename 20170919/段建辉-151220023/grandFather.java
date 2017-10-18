public class grandFather {
    /* First grandfather calls all huluwas and generates 7 positions. */
    /* Plant a vine. */
    static vine Vine;

    /* Using talk function to messaging. */
    public static void talkSkill(Xiaojingang[] huluwa) {
        for(int i = 0; i < 7; i++)
            huluwa[i].talkSkill();
    }

    public static void main(String arg[]) {
        vine.setOrder();
        /* Sort according Rank. */
        vine.rankSort();
        System.out.println("Rank sort finished.");
        vine.finishedOrder(0);
        vine.setOrder();
        /* Sort according Color. */
        vine.colorSort();
        System.out.println("Color sort finished.");
        vine.finishedOrder(1);
        /* Test function. */
        talkSkill(vine.huluwa);
    }
}

public class Square {
    /* First grandfather calls all huluwas and generates 7 positions. */

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
    }
}

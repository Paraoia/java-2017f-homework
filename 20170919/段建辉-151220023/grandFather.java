public class grandFather {

    static Dawa dawa = new Dawa();
    static Erwa erwa = new Erwa();
    static Sanwa sanwa = new Sanwa();
    static Siwa siwa = new Siwa();
    static Wuwa wuwa = new Wuwa();
    static Liuwa liuwa = new Liuwa();
    static Qiwa qiwa = new Qiwa();

    public static void setOrder(Xiaojingang[] huluwa) {
        huluwa[0] = qiwa;
        huluwa[1] = liuwa;
        huluwa[2] = wuwa;
        huluwa[3] = siwa;
        huluwa[4] = sanwa;
        huluwa[5] = erwa;
        huluwa[6] = dawa;
    }

    public static void rankSort(Xiaojingang[] huluwa) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                Xiaojingang temp;
                if (huluwa[j].getRank() > huluwa[j + 1].getRank()) {
                    temp = huluwa[j];
                    huluwa[j] = huluwa[j + 1];
                    System.out.println(huluwa[j].getName() + ": " + (j + 1) + "->" + j);
                    huluwa[j + 1] = temp;
                    System.out.println(huluwa[j + 1].getName() + ": " + j + "->" + (j + 1));
                }
            }
        }
    }
    public static int binarySearch(Xiaojingang[] huluwa, int start, int end, Xiaojingang value) {
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (huluwa[mid].color.compareTo(value.color) < 0)
                start = mid + 1;
            else if (huluwa[mid].color.compareTo(value.color) > 0)
                end = mid - 1;
            else
                break;
        }
        if (huluwa[mid].color.compareTo(value.color) < 0)
            return mid + 1;
        else if (huluwa[mid].color.compareTo(value.color) > 0)
            return mid;

        return mid + 1;

    }

    public static void colorSort(Xiaojingang[] huluwa, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            Xiaojingang value = huluwa[i];
            int insertLoc = binarySearch(huluwa, start, i - 1, value) ;
            for (int j = i; j > insertLoc; j--) {
                huluwa[j] = huluwa[j - 1];
                System.out.println(huluwa[j].getName() + ": " + (j - 1) + "->" + j);
            }
            huluwa[insertLoc] = value;
            System.out.println(huluwa[insertLoc].getName() + ": " + i + "->" + insertLoc);
        }
    }

    public static void talkSkill(Xiaojingang[] huluwa) {
        for(int i = 0; i < 7; i++)
            huluwa[i].Skill(huluwa[i].getRank());
    }
    public static void main(String arg[]) {
        Xiaojingang[] huluwa = new Xiaojingang[7];
        setOrder(huluwa);
        // According Rank
        rankSort(huluwa);
        System.out.println("Rank sort finished.");
        for(int i = 0; i < 6; i++)
            System.out.print(huluwa[i].getName() + "->");
        System.out.println(huluwa[6].getName());
        setOrder(huluwa);
        // According Color
        colorSort(huluwa,0, 6);
        System.out.println("Color sort finished.");
        for(int i = 0; i < 6; i++)
            System.out.print(huluwa[i].getColor(huluwa[i].getRank()) + "->");
        System.out.println(huluwa[6].getColor(huluwa[6].getRank()));
        talkSkill(huluwa);
    }
}

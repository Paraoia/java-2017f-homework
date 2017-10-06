public class Position {

    private Xiaojingang[] positions;

    public Position(Xiaojingang[] a) {
        positions = a;
    }
    /* Ranksort uses bubble sort. */
    public void rankSort() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                Xiaojingang temp;
                if (positions[j].getRank() > positions[j + 1].getRank()) {
                    temp = positions[j];
                    positions[j] = positions[j + 1];
                    System.out.println(positions[j].talkName() + ": " + (j + 1) + "->" + j);
                    positions[j + 1] = temp;
                    System.out.println(positions[j + 1].talkName() + ": " + j + "->" + (j + 1));
                }
            }
        }
    }

    public int binarySearch(int start, int end, Xiaojingang value) {
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (positions[mid].color.compareTo(value.color) < 0)
                start = mid + 1;
            else if (positions[mid].color.compareTo(value.color) > 0)
                end = mid - 1;
            else
                break;
        }
        if (positions[mid].color.compareTo(value.color) < 0)
            return mid + 1;
        else if (positions[mid].color.compareTo(value.color) > 0)
            return mid;

        return mid + 1;

    }
    /* Colorsort uses binary sort. */
    public void colorSort(int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            Xiaojingang value = positions[i];
            int insertLoc = binarySearch(start, i - 1, value) ;
            for (int j = i; j > insertLoc; j--) {
                positions[j] = positions[j - 1];
                System.out.println(positions[j].talkName() + ": " + (j - 1) + "->" + j);
            }
            positions[insertLoc] = value;
            System.out.println(positions[insertLoc].talkName() + ": " + i + "->" + insertLoc);
        }
    }

}

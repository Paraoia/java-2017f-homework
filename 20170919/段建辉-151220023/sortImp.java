
class ranksort implements sort {

    @Override
    public void Sort(Xiaojingang[] positions) {
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions.length - 1; j++) {
                Xiaojingang temp;
                if (positions[j].Compare( positions[j + 1].getRank())){
                    temp = positions[j];
                    positions[j] = positions[j + 1];
                    System.out.println(positions[j].talkName() + ": " + (j + 1) + "->" + j);
                    positions[j + 1] = temp;
                    System.out.println(positions[j + 1].talkName() + ": " + j + "->" + (j + 1));
                }
            }
        }
    }
}

class colorsort implements sort {
    private int binarySearch(int start, int end, Xiaojingang value, Xiaojingang[] positions) {
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (positions[mid].getColor().compareTo(value.getColor()) < 0)
                start = mid + 1;
            else if (positions[mid].getColor().compareTo(value.getColor()) > 0)
                end = mid - 1;
            else
                break;
        }
        if (positions[mid].getColor().compareTo(value.getColor()) < 0)
            return mid + 1;
        else if (positions[mid].getColor().compareTo(value.getColor()) > 0)
            return mid;

        return mid + 1;

    }
    /* Colorsort uses binary sort. */
    @Override
    public void Sort(Xiaojingang[] positions) {
        Sort_imp(0, positions.length - 1, positions);
    }
    private void Sort_imp(int start, int end, Xiaojingang[] positions) {
        for (int i = start + 1; i <= end; i++) {
            Xiaojingang value = positions[i];
            int insertLoc = binarySearch(start, i - 1, value, positions) ;
            for (int j = i; j > insertLoc; j--) {
                positions[j] = positions[j - 1];
                System.out.println(positions[j].talkName() + ": " + (j - 1) + "->" + j);
            }
            positions[insertLoc] = value;
            System.out.println(positions[insertLoc].talkName() + ": " + i + "->" + insertLoc);
        }
    }
}
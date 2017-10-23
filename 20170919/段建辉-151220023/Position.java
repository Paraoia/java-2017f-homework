class Position {
    private Xiaojingang[] positions;
    private ranksort Sort1 = new ranksort();
    private colorsort Sort2 = new colorsort();

    Position(Xiaojingang[] a) {
        positions = a;
    }
    /* Ranksort uses bubble sort. */
    void rankSort() {
        Sort1.Sort(positions);
    }
    void colorSort() {
        Sort2.Sort(positions);
    }
}

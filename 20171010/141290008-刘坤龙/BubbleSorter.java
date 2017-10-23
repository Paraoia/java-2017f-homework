public class BubbleSorter implements Sorter {
    @Override
    public void sort(Space space,int x,int y,int length) {
        Position[][] positions = space.getPositions();


        Creature creature;

        for (int i = 0; i < length - 1; i++) {
            int sx = x;
            int sy = y;
            for (int j = 0; j < length - 1 - i; j++) {
                int nx = sx + 1;
                int ny = sy ;
                if (((Comparable) (positions[sx][sy].getHolder())).biggerThan(
                        (Comparable) (positions[nx][ny].getHolder()))) {
                    creature = positions[sx][sy].getHolder();
                    positions[nx][ny].getHolder().setPosition(positions[sx][sy]);
                    creature.setPosition(positions[nx][ny]);
                }
                sx += 1;
            }
        }
    }
}

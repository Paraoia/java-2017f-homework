package HuluwaGo;

public class QuickSorter implements Sorter {

    @Override
    public void sort(Queue queue) {
        System.out.println("快速排序中...");
        _quickSort(queue, 0, queue.getPositions().length - 1);
        System.out.println("快速排序完成！");
    }

    private void _quickSort(Queue queue, int l, int r) {
        if (l >= r) return;

        Position[] positions = queue.getPositions();

        int middle = l;
        int split = l;
        for (int i = middle + 1; i <= r; i++) {
            if (((Comparable)(positions[middle].getHolder())).biggerThan(
                    (Comparable) positions[i].getHolder())) {
                split++;
                queue.swap(positions[split], positions[i]);
            }
        }

        queue.swap(positions[split], positions[middle]);
        middle = split;

        _quickSort(queue, l, middle - 1);
        _quickSort(queue, middle + 1, r);
    }
}

import java.util.Comparator;
import java.util.List;

public class QueueManager {

    private Brother[] brothers;

    public QueueManager(int length) {
        brothers = new Brother[length];
    }

    public void enqueue(List<Brother> bros) {
        if(bros.size() != brothers.length) {
            System.out.println("Wrong numbers!");
            return;
        }

        for(int i = 0;i < brothers.length;i++) {
            brothers[i] = bros.get(i);
            brothers[i].setPos(i);
        }
    }

    public void arrangeQueuebyBubbleSort(Comparator<Brother> comparator) {
        for(int i = 0;i < brothers.length - 1;i++) {
            for(int j = 0;j < brothers.length - 1 - i;j++) {
                if(comparator.compare(brothers[j], brothers[j+1]) > 0) {
                    swapBrothers(brothers, j, j+1);
                }
            }
        }
    }

    private int partition(Comparator<Brother> comparator, int low, int high) {
        Brother pivot = brothers[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && comparator.compare(brothers[right], pivot) >= 0) {
                right--;
            }
            while (left < right && comparator.compare(brothers[left], pivot) <= 0) {
                left++;
            }
            if (left < right) {
                swapBrothers(brothers, left, right);
            }
        }
        brothers[low] = brothers[left];
        brothers[left] = pivot;
        return left;
    }

    private void sort(Comparator<Brother> comparator, int low, int high) {
        if(low < high) {
            int p = partition(comparator, low, high);
            sort(comparator, low, p - 1);
            sort(comparator, p + 1, high);
        }
    }

    public void arrangeQueuebyQuickSort(Comparator<Brother> comparator) {
        sort(comparator, 0, brothers.length - 1);
    }

    public void printQueue() {
        System.out.println("Brothers:");
        for(int i = 0;i < brothers.length;i++) {
            brothers[i].speak();
        }
    }

    public void swapBrothers(Brother[] brothers, int i, int j) {
        Brother tmp = brothers[i];
        brothers[i] = brothers[j];
        brothers[j] = tmp;
        brothers[i].speak();
        System.out.println(j + "->" + i);
        brothers[j].speak();
        System.out.println(i + "->" + j);
    }
}



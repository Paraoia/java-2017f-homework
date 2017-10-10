public class Sort {
    public void BubbleSort(HuLu h[]) {
        System.out.println("Bubble Sort:");
        for (int i = 0; i < HuLu.TOTAL - 1; i++)
            for (int j = 0; j < HuLu.TOTAL - 1; j++) {
                if (h[j].getNum() > h[j + 1].getNum()) {
                    h[j + 1].ChangePosition(j + 1, j);
                    h[j].ChangePosition(j, j + 1);
                    HuLu temp = h[j];
                    h[j] = h[j + 1];
                    h[j + 1] = temp;
                }
            }
    }

    public void BinSort(HuLu h[]) {
        System.out.println("Binary Sort:");
        for (int i = 1; i < HuLu.TOTAL; i++) {
            int temp = h[i].getNum();
            HuLu l = h[i];
            int right = i - 1;
            int left = 0;
            int mid;
            while (left < right) {
                mid = (left + right) / 2;
                if (h[mid].getNum() > temp)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            for (int j = i; j > left; j--) {
                h[j] = h[j - 1];
                h[j].ChangePosition(j, j - 1);
            }
            h[left].ChangePosition(left, i);
            h[left] = l;
        }
    }

    //QuickSort_(h:葫芦娃数组，low=0，high=总数-1)
    public void QSort(HuLu h[], int low, int high) {
        if (low >= high) {
            return;
        }
        int index = partition(h, low, high);
        QSort(h, low, index - 1);
        QSort(h, index + 1, high);
    }

    private int partition(HuLu h[], int low, int high) {
        HuLu key = h[low];
        int temp = low;
        while (low < high) {
            while (h[high].getNum() >= key.getNum() && high > low) {
                high--;
            }
            if (low % HuLu.TOTAL != high % HuLu.TOTAL) h[low].ChangePosition(low % HuLu.TOTAL, high % HuLu.TOTAL);
            h[low] = h[high];
            while (h[low].getNum() <= key.getNum() && high > low) {
                low++;
            }
            if (low % HuLu.TOTAL != high % HuLu.TOTAL) h[high].ChangePosition(high % HuLu.TOTAL, low % HuLu.TOTAL);
            h[high] = h[low];
        }
        if (high % HuLu.TOTAL != temp % HuLu.TOTAL) h[high].ChangePosition(high % HuLu.TOTAL, temp % HuLu.TOTAL);
        h[high] = key;
        return high;
    }

}

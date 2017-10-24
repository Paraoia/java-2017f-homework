import java.util.Random;

public class Queue {
    private Huluwa[] huluwas;

    public Queue() {
        huluwas = new Huluwa[8];
    }

    public void enQueue(Huluwa[] hulus) {
        for(int i = 0; i < 7; i++) {
            huluwas[i + 1] = hulus[i];
        }
        randomQueue();
    }

    public void randomQueue() {
        System.out.println("随机站队...");
        Random random = new Random();
        for(int i = 1; i < huluwas.length; i++) {
            int rnd = random.nextInt(7) + 1;
            Huluwa.swapPos(huluwas, i, rnd);
        }
    }

    public void reportByName() {
        System.out.println("葫芦兄弟根据名字报数:");
        for(int i = 1; i < huluwas.length; i++) {
            System.out.print(huluwas[i].getName() + " ");
        }
        System.out.println();
    }

    public void reportByColor() {
        System.out.println("葫芦兄弟根据颜色报数:");
        for(int i = 1; i < huluwas.length; i++) {
            System.out.print(huluwas[i].getColor() + " ");
        }
        System.out.println();
    }

    public void bubbleSort() {
        //注: 排序都是借助0号位置来完成, 而非直接交换两个葫芦娃的位置
        System.out.println("开始排序: ");
        for(int i = 1; i < huluwas.length; i++) {
            for(int j = i + 1; j < huluwas.length; j++) {
                if(huluwas[i].getID() > huluwas[j].getID()) {
                    Huluwa.swapPos(huluwas, i, j);
                    Huluwa.printSwapInfo(huluwas, i, j);
                }
            }
        }
    }

    public void quickSort() {
        System.out.println("开始排序: ");
        quickSort(huluwas, 1, huluwas.length - 1);
    }

    private void quickSort(Huluwa[] huluwas, int low, int high) {
        if(low >= high) {
            return;
        }
        int idx = partition(huluwas, low, high);
        quickSort(huluwas, low, idx - 1);
        quickSort(huluwas, (idx + 1), high);
    }

    private int partition(Huluwa[] huluwas, int low, int high) {
        Huluwa key = huluwas[low];
        int first = low;

        while(low < high) {
            while(huluwas[high].getID() >= key.getID() && high > low) {
                high--;
            }
            huluwas[low] = huluwas[high];
            System.out.println(huluwas[high].getName() + ": " + high + "->" + low);

            while(huluwas[low].getID() <= key.getID() && high > low) {
                low++;
            }
            huluwas[high] = huluwas[low];
            System.out.println(huluwas[low].getName() + ": " + low + "->" + high);
        }

        huluwas[high] = key;
        System.out.println(key.getName() + ": " + first + "->" + high);
        return high;
    }
}

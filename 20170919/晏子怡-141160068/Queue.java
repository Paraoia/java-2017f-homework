import java.util.Random;

public class Queue {
    Huluwa[] queue;
    int size;

    public Queue() {
        queue = new Huluwa[7];
        Random random = new Random();
        EColor[] colors = EColor.values();
        ERank[] ranks = ERank.values();
        size = 7;
        for (int i = 0; i < size; i++) {
            Huluwa tmp = new Huluwa(colors[i], ranks[i], i + 1);
            queue[i]=tmp;
        }
        //随机打乱队伍
        for (int i = 0; i <size; i++) {
            int p = random.nextInt(i + 1);
            queue[i].changePosition(p+1);
            queue[p].changePosition(i+1);
            Huluwa tmp= queue[i];
            queue[i] = queue[p];
            queue[p] = tmp;
        }

    }
}

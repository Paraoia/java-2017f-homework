package unit;

import field.Queue;

import java.util.ArrayList;
import java.util.List;

public class Shejing extends Manager implements FormationProtocol {
    public Shejing(String name, Queue queue) {
        super(name, queue, List.of(Xiaolouluo.class, Xiezijing.class, Shejing.class));
    }

    @Override
    public void enqueue() {
        List<Unit> Xiaolouluos = new ArrayList<>();
        Xiaolouluos.add(new Xiezijing("蝎子精"));
        Xiaolouluos.add(this);
        for (int i = 0;i < 10;i++) {
            Xiaolouluos.add(new Xiaolouluo("小喽啰" + "0123456789".charAt(i)));
        }
        super.addMembers(Xiaolouluos);
    }

    @Override
    public void report() {
        super.report();
        System.out.println();
    }
}

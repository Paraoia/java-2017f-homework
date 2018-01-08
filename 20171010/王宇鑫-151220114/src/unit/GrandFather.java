package unit;

import field.Queue;

import java.util.ArrayList;
import java.util.List;

public class GrandFather extends Manager implements FormationProtocol {
    private List<Unit> members = new ArrayList<>();

    public GrandFather(String name, Queue queue) {
        super(name, queue, List.of(Huluwa.class, GrandFather.class));
    }

    @Override
    public void enqueue() {
        members.add(this);
        for (int i = 1; i <= 7; i++) {
            members.add(new Huluwa("老老" + "零大二三四五六七".charAt(i), Huluwa.Color.colorAt(i), i));
        }
        super.addMembers(members);
    }

    @Override
    public void report() {
        super.report();
        System.out.println();
    }
}

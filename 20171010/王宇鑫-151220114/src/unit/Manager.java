package unit;

import field.Coordinate;
import field.Position;
import field.Queue;
import formation.FormationImage;
import javafx.util.Pair;
import sort.Sorter;

import java.util.ArrayList;
import java.util.List;

public abstract class Manager extends Unit implements FormationProtocol {
    private String formationPath;
    private Queue queue;
    private List<Class> management = new ArrayList<>();

    public Manager(String name, Queue queue, List<Class> management) {
        super(name);
        this.queue = queue;
        this.management = management;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public void addMembers(List<Unit> members) {
        queue.enqueue(members);
    }

    public void shuffle() {
        queue.shuffle();
    }

    public void sort() {
        queue.sort();
    }

    public void setSorter(Sorter sorter) {
        queue.setSorter(sorter);
    }

    public void reportAll() {
        queue.report();
    }

    public Boolean isManager(Class c) {
        return management.contains(c);
    }

    public abstract void enqueue();

    @Override
    public void setFormation(String formationPath) {
        this.formationPath = formationPath;
    }

    @Override
    public void formation() {
        if (formationPath == null) return;
        FormationImage img = new FormationImage(formationPath, queue.getN());
        List<Unit> positions = new ArrayList<>();
        management.forEach((Class c) -> positions.addAll(queue.getUnits(this, c)));
        Integer index = 0;
        for (Pair<Double, Coordinate> pair : img.read()) {
            if (index >= positions.size()) break;
            positions.get(index++).moveTo(queue.get(pair.getValue()));
        }
    }

    @Override
    public void formationDraw() {
        Integer N = queue.getN(), count = 0;
        for (Position position : queue) {
            System.out.format("%-6s", position.getSeat().getName());
            if (count % N == N - 1) System.out.println();
            count++;
        }
        System.out.println();
    }
}

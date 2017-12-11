import field.Queue;
import sort.BubbleSort;
import sort.QuickSort;
import unit.GrandFather;
import unit.Manager;
import unit.Shejing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuluwaProject {
    private Map<String, String> formation = new HashMap<>();
    private String format = "src/material/%s.png";
    private Integer N;

    public HuluwaProject(Integer N) {
        this.N = N;
        initFormation();
    }

    private void initFormation() {
        formation.put("葫芦娃", String.format(format, "长蛇"));
        formation.put("小喽啰1", String.format(format, "方円"));
        formation.put("小喽啰2", String.format(format, "鹤翼"));
    }

    public void projectRun() {
        //a queue
        Queue queue = new Queue(N);
        //managers
        Manager gf = new GrandFather("爷爷爷", queue);
        Manager sj = new Shejing("蛇蛇精", queue);
        List<Manager> managers = List.of(gf, sj);
        //enqueue
        managers.forEach(Manager::enqueue);
        //select one
        Manager manager = managers.get(0);
        //go
        manager.setSorter(new BubbleSort());
        manager.shuffle();
        manager.sort();
        manager.reportAll();
        manager.setSorter(new QuickSort());
        manager.shuffle();
        manager.sort();
        manager.reportAll();
        //formation
        gf.setFormation(formation.get("葫芦娃"));
        sj.setFormation(formation.get("小喽啰1"));
        managers.forEach(Manager::formation);
        manager.formationDraw();
        //change
        sj.setFormation(formation.get("小喽啰2"));
        sj.formation();
        sj.formationDraw();
    }

    public static void main(String[] args) {
        HuluwaProject hp = new HuluwaProject(10);
        hp.projectRun();
    }
}

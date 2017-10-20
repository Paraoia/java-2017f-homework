public class GrandFather {
    private static Integer huluwaNumber = 7;
    private Queue queue = new Queue();
    private Huluwa[] huluwas = new Huluwa[huluwaNumber];

    GrandFather() {
        for (Integer i = 1; i <= huluwaNumber; i++) huluwas[i - 1] = new Huluwa(i, nameForHuluwa(i), Huluwa.Color.colorAt(i));
    }

    public void enqueueHuluwas() {
        for (Huluwa h : huluwas) addHuluwaToQueue(h);
        queue.shuffle();
    }

    public void dequeueHuluwas() {
        queue.clear();
    }

    public void sortHuluwas(Queue.SortType type) {
        queue.sort(type);
    }

    public void addHuluwaToQueue(Huluwa huluwa) {
        Queue.Position p = new Queue.Position(queue.tail(), huluwa);
        queue.add(p);
    }

    public void report(ReportType what) {
        queue.report(what);
    }

    private static String seniorityString = "零大二三四五六七";
    private String nameForHuluwa(Integer i) {
        return "老" + seniorityString.charAt(i);
    }

    public enum ReportType {
        NAME, COLOR
    }
}

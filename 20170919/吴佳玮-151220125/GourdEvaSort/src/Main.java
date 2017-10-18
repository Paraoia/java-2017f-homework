public class Main {
    public static void main(String[] args){
        GourdEvaQueue troop=new GourdEvaQueue();
        troop.gourdEvaList.add(new GourdEva(0, GourdEva.colors.RED,1));
        troop.gourdEvaList.add(new GourdEva(1, GourdEva.colors.ORANGE,2));
        troop.gourdEvaList.add(new GourdEva(2, GourdEva.colors.YELLOW,3));
        troop.gourdEvaList.add(new GourdEva(3, GourdEva.colors.GREEN,4));
        troop.gourdEvaList.add(new GourdEva(4, GourdEva.colors.BLUENESS,5));
        troop.gourdEvaList.add(new GourdEva(5, GourdEva.colors.BLUE,6));
        troop.gourdEvaList.add(new GourdEva(6, GourdEva.colors.PURPLE,7));
        troop.randSetPosition();
        troop.countOffAge();
        troop.buddleSort();
        troop.countOffAge();
        troop.randSetPosition();
        troop.countOffColor();
        troop.quickSort(0,6);
        troop.countOffColor();
        return;
    }
}

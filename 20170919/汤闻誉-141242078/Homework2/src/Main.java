public class Main {
    public static void main(String[] args){
        HuLuWas huLuWaArray=new HuLuWas();
        huLuWaArray.lineup();
        huLuWaArray.printLineByName();
        huLuWaArray.bubbleSort();
        huLuWaArray.printLineByName();
        System.out.println();
        huLuWaArray.lineup();
        huLuWaArray.printLineByColor();
        huLuWaArray.quickSort(0,6);
        huLuWaArray.printLineByColor();
    }
}

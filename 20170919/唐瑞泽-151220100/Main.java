public class Main {
    public static void main(String []args) {
        HuluwaSort huluwaSort = new HuluwaSort();

        System.out.println("----Bubble sort start----");
        huluwaSort.disorganize();
        huluwaSort.bubbleSort();
        System.out.println("----Bubble sort end----\n");
        System.out.println("----Report name----");
        huluwaSort.reportName();


        System.out.println("\n----Quick sort start----");
        huluwaSort.disorganize();
        huluwaSort.quickSort();
        System.out.println("----Quick sort end----\n");
        System.out.println("----Report color----");
        huluwaSort.reportColor();

    }
}

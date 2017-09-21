import java.util.Random;

enum Color{
    RED("红色", 1),ORANGE("橙色", 2),YELLOW("黄色", 3),GREEN("绿色", 4),CYAN("青色", 5),BLUE("蓝色", 6),PURPLE("紫色", 7);

    public String name;
    public int index;
    Color(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
public class Hulubaby {
    int range; //排名
    Color color;
    String rank;
    private Hulubaby(int range, Color color, String rank){
        this.range = range;
        this.color = color;
        this.rank = rank;
    }
    public static void main(String[] args) {
        Hulubaby[] Baby = new Hulubaby[7];
        Baby[0] = new Hulubaby(1, Color.RED, "老大");
        Baby[1] = new Hulubaby(2, Color.ORANGE, "老二");
        Baby[2] = new Hulubaby(3, Color.YELLOW, "老三");
        Baby[3] = new Hulubaby(4, Color.GREEN, "老四");
        Baby[4] = new Hulubaby(5, Color.CYAN, "老五");
        Baby[5] = new Hulubaby(6, Color.BLUE, "老六");
        Baby[6] = new Hulubaby(7, Color.PURPLE, "老七");
        rand_sort(Baby, 7);
        bubble_sort(Baby, 7);
        rand_sort(Baby, 7);
        quick_sort(Baby, 7);
    }
    private static void print_baby(Hulubaby[] baby, int num){
        for(int i = 0; i < num; i++) {
            System.out.print(baby[i].rank + " ");
        }
        System.out.println("");
    }
    private static void quick_sort(Hulubaby[] baby, int num) {
        int i = 0, j = num-1;
        quickSort(baby, i, j);
        print_baby(baby, num);
    }

    private static void quickSort(Hulubaby[] baby, int i, int j) {
        if(i >= j)
            return;
        Hulubaby pivot = baby[i];
        int p = i, q = j;
        while(i<j){
            for(; i < j && baby[j].range >= pivot.range; j--);
            if(baby[j].range < pivot.range){
                System.out.println(baby[j].rank + ": " + j + "->" + i + " " );
                baby[i] = baby[j];
            }
            for(; i < j && baby[i].range <= pivot.range; i++);
            if(baby[i].range > pivot.range) {
                System.out.println(baby[i].rank + ": " + i + "->" + j + " " );
                baby[j] = baby[i];
            }
        }
        System.out.println(pivot.rank + ": X"  + "->" + i + " " );
        baby[i] = pivot;
        quickSort(baby, p, i-1);
        quickSort(baby, i+1, q);

    }

    private static void bubble_sort(Hulubaby[] baby, int num) {
        for(int i = 0; i < num; i++)
        {
            for(int j = 0; j < num -1 -i; j++){
                if(baby[j].range > baby[j+1].range){
                    System.out.print(baby[j].rank + ": " + j + "->" + (j+1) + " " );
                    System.out.println(baby[j+1].rank + ": " + (j+1) + "->" + j  );
                    Hulubaby temp = baby[j];
                    baby[j] = baby[j+1];
                    baby[j+1] = temp;
                }
            }
        }
        print_baby(baby, num);
    }

    private static void rand_sort(Hulubaby[] baby, int num) {
        for (int i = 0; i < 5; i++) {
            Random r = new Random();
            int r1 = r.nextInt(7);
            int r2 = r.nextInt(7);
            Hulubaby temp = baby[r1];
            baby[r1] = baby[r2];
            baby[r2] = temp;
        }

        print_baby(baby, num);

    }

}


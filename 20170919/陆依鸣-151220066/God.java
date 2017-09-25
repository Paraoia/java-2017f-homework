import java.util.*;

public class God {
    public static void main(String[] args) throws C1 {
        HuluBrothers huluwas = new HuluBrothers();

        System.out.print("随意站队: ");
        huluwas.shuffle();
        huluwas.tellAll();

        System.out.println("\n冒泡排序:");
        huluwas.bubbleSort();

        System.out.println("\n报数:");
        huluwas.tellRank();

        System.out.print("\n随意站队: ");
        huluwas.shuffle();
        huluwas.tellAll();

        System.out.println("\n快速排序:");
        huluwas.quickSort();
        
        System.out.println("\n报颜色:");
        huluwas.tellColor();
    }
}


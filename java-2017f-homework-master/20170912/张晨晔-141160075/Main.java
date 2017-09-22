import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        int[] a = {111, 3232321, 4444, 512, 776767, 83, 91, 109, 21, 45, 792};
        Arrays.sort(a); //默认升序
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}


public class SimpleSort {

    public static void main(String[] args) {
        int i;
        for(i = 0; i < args.length - 1; ++i) {
            for(int j = 0; j < args.length - i - 1; ++j) {
                if (Integer.parseInt(args[j]) > Integer.parseInt(args[j + 1])) {
                    String var3 = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = var3;
                }
            }
        }

        for(i = 0; i < args.length; ++i) {
            System.out.print(args[i] + ' ');
        }
        System.out.println();
    }
}
public class sort {
    public static void main(String[] args){
        int a[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        for(int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++)
                if (a[j] < a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
        }
        for(int t = 0; t < a.length; t++)
            System.out.print(a[t] + " ");
    }
}
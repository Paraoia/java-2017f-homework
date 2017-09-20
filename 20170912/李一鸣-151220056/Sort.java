public class Sort{
    public static void main (String[] args){
        int num[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        System.out.print("The original array:  ");
        for (int i=0;i<num.length ;i++) {
            System.out.print(" " + num[i]);
        }
        for (int j=0;j<num.length ;j++)
            for (int k = j + 1; k < num.length; k++)
                if (num[j] > num[k]) {
                    int tem = num[j];
                    num[j] = num[k];
                    num[k] = tem;
                }
        System.out.println();
        System.out.print("The sorted array:  ");
        for (int i=0;i<num.length ;i++) {
            System.out.print(" " + num[i]);
        }
    }

}
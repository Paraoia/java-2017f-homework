public class Main {
    public static void main(String[] args) {
        int[] num=new int[20];
        for(int a=0;a<20;a++)
        {
            num[a]=(int)(Math.random()*100);
            System.out.print(num[a]+" ");
        }
        System.out.println();
        int temp;
        for (int i=0;i<num.length-1;i++){
            for (int j=i+1;j<num.length;j++){
                if (num[j]>num[i]){
                    temp=num[j];
                    num[j]=num[i];
                    num[i]=temp;
                }
            }
        }
        for (int k=0;k<num.length;k++){
            System.out.print(num[k]+" ");
        }
    }
}

public class sort {
    public static void main(String[] args){
        int num[]={2,34,67,23,45,98,346,53,32,9};

        for(int i=0;i<9;i++){
            for(int j=0;j<9-i;j++){
                if(num[j]>num[j+1]){
                    int temp;
                    temp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=temp;
                }
            }
        }
        for(int i=0;i<10;i++) {
            System.out.print(num[i] + " ");
        }
    }

}

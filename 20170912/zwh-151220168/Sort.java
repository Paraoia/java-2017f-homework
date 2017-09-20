public class Sort {
    public static void main(String[] args) {
        int[] myList={1,9,9,7,0,4,1,6};
        for (int i = 0; i < myList.length; i++)
            for (int j = i; j < myList.length; j++)
            {
                if(myList[i]>myList[j])
                {
                    int temp=myList[i];
                    myList[i]=myList[j];
                    myList[j]=temp;
                }
            }
        for (int i = 0; i < myList.length; i++)
            System.out.println(myList[i]);
    }
}

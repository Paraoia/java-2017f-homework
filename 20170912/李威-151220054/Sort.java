public class Sort {
    public static void main(String[] args) {
        int array[] = {3,5,8,12,36,23,78,0};
        for(int i = 0; i < array.length-1; i++)
        {
            int k = i;
            int key = array[i];
            for (int j=i+1; j<array.length; j++)
            {
                if (array[j]<key)
                {
                    k = j;
                    key = array[j];
                }
            }
            if (k!=i) {
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i]+" ");
    }
}
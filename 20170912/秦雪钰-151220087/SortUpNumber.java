/*
  Sort in an Array Example
  This Java Example shows how to sort number in a ascending order in an
  array.
*/
public class SortUpNumber {
    public static void main(String[] args) {
        //array of 10 numbers
        int numbers[] = new int[]{100,200,150,233,888,886,38,419,1,521};
        int smallest=0;
        for(int i=0; i< numbers.length-1; i++)
        {
            smallest=i;
            for(int j=i+1;j<numbers.length; j++)
            {
                if (numbers[j] <numbers[smallest])
                    smallest = j;
            }
            int temp=numbers[i];
            numbers[i]=numbers[smallest];
            numbers[smallest]=temp;
        }
        System.out.println("After sorting: ");
        for(int i=0; i< numbers.length; i++)
            System.out.println(numbers[i]+" ");
    }
}
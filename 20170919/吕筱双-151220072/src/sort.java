public class sort{
    /*
    冒泡排序
     */
    public static void bubbleSort(calabash [] number){
        for(int i =0; i < number.length-1;i++){
            for(int j = 0 ; j < number.length-1-i;j++){
                if(number[j].getName().getIndex() > number[j+1].getName().getIndex())
                {
                    System.out.println(number[j].getName().getName() +':'+(j+1)+"->"+(j+2));
                    System.out.println(number[j+1].getName().getName() +':'+(j+2)+"->"+(j+1));

                    calabash temp = number[j];
                    number[j] = number[j+1];
                    number[j+1] = temp;

                }
            }
        }
    }
    /*
    快速排序
     */
    public static void quickSort(calabash[] numbers,int low,int high){
        if(low < high){
            int middle = getMiddle(numbers,low,high);
            quickSort(numbers,low,middle-1);
            quickSort(numbers,middle+1,high);
        }
    }
    private static int getMiddle(calabash[] numbers,int low,int high){
        calabash temp = numbers[low];
        int flag = low+1;

        while(low < high)
        {
            while(low < high && numbers[high].getColor().getIndex() >= temp.getColor().getIndex())
                high--;

            if(numbers[low] != numbers[high])
                System.out.println(numbers[high].getName().getName() +':'+(high+1)+"->"+(low+1));
            numbers[low] = numbers[high];

            while(low < high && numbers[low].getColor().getIndex() <= temp.getColor().getIndex())
                low++;

            if(numbers[low] != numbers[high])
                System.out.println(numbers[low].getName().getName() +':'+(low+1)+"->"+(high+1));
            numbers[high] = numbers[low];

        }

        if(numbers[low] != temp)
            System.out.println(temp.getName().getName() +':'+flag+"->"+(low+1));
        numbers[low] = temp;

        return low;
    }
}
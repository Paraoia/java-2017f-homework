public class Sort{
    public static void main(String[] args) {
        //array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        int lenth = numbers.length;
        
        //selection sort
        for (int i = 0; i < lenth - 1; i++)      
        {  
            int index = i;  
            for (int j = i + 1; j < lenth; j++)     
                if (numbers[j] < numbers[index])  
                    index = j;  
      
            if (index != i)    
               {
                   int tmp = numbers[index];
                   numbers[index] = numbers[i];
                   numbers[i] = tmp;
               }
        } 
        
        for(int i = 0; i < lenth;i++)
            System.out.println(numbers[i]);
    }
}
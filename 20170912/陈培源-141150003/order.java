class Order {

    public static void main(String[] args) {
        int numbers[]=new int[]{32,43,53,54,32,65,63,98,43,23};
        int i,k,j,t;
        for(i=0; i<numbers.length; i++)
        {
            for(k=i,j=i+1; j<numbers.length; j++) {
                if (numbers[j] < numbers[k])
                    k = j;
                if (k != i) {
                    t = numbers[k];
                    numbers[k] = numbers[i];
                    numbers[i] = t;
                }
            }
        }
        System.out.println("The ordered numbers is");
        for (i=0; i<numbers.length; i++){
            System.out.println(numbers[i] + ",");
        }
    }
}


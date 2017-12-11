public class Sort {
    Hulu []Brother=new Hulu[8];

    void init() {
        int []rank={1,3,5,7,2,4,6};
        for(int i=1; i<8; i++){
            Brother[i]=new Hulu(rank[i-1],i);
        }
    }
    void BubbleSort()
    {
        for(int i=1; i<Brother.length-1; i++)
        {
            for(int j=1; j< Brother.length-i-1; j++)
            {
                if(Brother[j].getName() > Brother[j+1].getName())
                {
                    Brother[j].print_move(j+1);
                    Brother[j+1].print_move(j);
                    Hulu temp=Brother[j];
                    Brother[j]=Brother[j+1];
                    Brother[j+1]=temp;
                }
            }
        }
        for(int i=1; i<Brother.length; i++)
            Brother[i].print_name();
    }

    void BinarySort(int first, int last)
    {
        int low, high, middle;
        for(int i = first; i <= last; i++) {
            Hulu temp = Brother[i];
            low = first;
            high = i-1;
            while (low <= high) {
                middle = (low + high) / 2;
                if(Brother[i].getColor()<Brother[middle].getColor())
                    high = middle -1;
                else low = middle + 1;
            }
            for(int j =i-1; j>=low; j--) {
                Brother[j].print_move(j+1);
                Brother[j+1].print_move(j);
                Brother[j + 1] = Brother[j];
            }
            Brother[low] = temp;
        }
        for(int i=1; i<Brother.length; i++)
            Brother[i].print_color();
    }

    public static void main(String args[]) {
        Sort brothersort=new Sort();
        brothersort.init();
        brothersort.BubbleSort();
        brothersort.init();
        brothersort.BinarySort( 1, 7);
    }
}

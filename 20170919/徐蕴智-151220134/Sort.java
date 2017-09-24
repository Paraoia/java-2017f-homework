public class Sort {
    static Output print=new Output();

    //Bubblesort
    public static void BubbleSort(HuLuWa huluwa[],int n) {
        for (int i= 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (huluwa[i].Rank > huluwa[j].Rank) {
                    HuLuWa temp = huluwa[i];
                    huluwa[i] = huluwa[j];
                    huluwa[j] = temp;
                    print.Change(huluwa[i].Rank,i,j);
                    print.Change(huluwa[j].Rank,j,i);
                }
            }
        }
    }

    public static void BubbleSort(int rank[],int n) {
        for (int i= 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (rank[i] > rank[j]) {
                    int temp = rank[i];
                    rank[i] = rank[j];
                    rank[j] = temp;
                    print.Change(rank[i],i,j);
                    print.Change(rank[j],j,i);
                }
            }
        }
    }

    //Quicksort
    public static void QuickSort(int rank[],int l,int r)
    {
        if(l>=r)return;
        int last = r;
        int first =l;
        int key =rank[l];
        while(first<last)
        {
            while(rank[last]>key&&first<last)
            {
                last--;
            }
            rank[first]=rank[last];
            print.Change(rank[first],last,first);
            while(key>rank[first]&&first<last)
            {
                first++;
            }
            rank[last]=rank[first];
            print.Change(rank[last],first,last);
        }
        rank[first]=key;
        print.Change(key,l,first);
        QuickSort(rank,l,first-1);
        QuickSort(rank,first+1,r);
    }

    public static void QuickSort(HuLuWa rank[],int l,int r)
    {
        if(l>=r)return;
        int last = r;
        int first =l;
        HuLuWa key =rank[l];
        while(first<last)
        {
            while(rank[last].Rank>key.Rank&&first<last)
            {
                last--;
            }
            rank[first]=rank[last];
            print.Change(rank[first].Rank,last,first);
            while(key.Rank>rank[first].Rank&&first<last)
            {
                first++;
            }
            rank[last]=rank[first];
            print.Change(rank[last].Rank,first,last);
        }
        rank[first]=key;
        print.Change(key.Rank,l,first);
        QuickSort(rank,l,first-1);
        QuickSort(rank,first+1,r);
    }
}

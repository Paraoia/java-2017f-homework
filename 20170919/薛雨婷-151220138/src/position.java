public class position {
    WaterLily seats[];

    public position(brothers brother[]) {
        seats = new WaterLily[7];

        for(int i=0;i<7;i++){
            seats[i]=new WaterLily(brother[i]);
        }
    }

    void BubbleSort(){
        for(int i=0;i<6;i++){
            for(int j=0;j<6-i;j++){
                if(seats[j].bro.get_num()>seats[j+1].bro.get_num()){
                    WaterLily temp=seats[j];
                    seats[j]=seats[j+1];
                    seats[j+1]=temp;
                    System.out.println(seats[j].bro.get_name()+": "+j+" -> "+(j+1));
                    System.out.println(seats[j+1].bro.get_name()+": "+(j+1)+" -> "+j);
                }
            }
        }
    }
    void outputName() {
        for (int i = 0; i < 7; i++)
            System.out.print(seats[i].bro.get_name() + "  ");
        System.out.println();
    }

    void QuickSort(int low,int high){
        if(low<high){
            int par=partition(low,high);
            QuickSort(low,par-1);
            QuickSort(par+1,high);
        }
        return;
    }
    int partition(int low,int high) {
        WaterLily pivot = seats[low];
        int sta = low;
        while (low < high) {
            while (seats[high].bro.get_num() >= pivot.bro.get_num() && high > low)
                high--;
            if (low != high) {
                seats[low] = seats[high];
                System.out.println(seats[high].bro.get_color() + ": " + high + " -> " + low);
            }
            while (seats[low].bro.get_num() <= pivot.bro.get_num() && high > low)
                low++;
            if (low != high) {
                seats[high] = seats[low];
                System.out.println(seats[low].bro.get_color() + ": " + low + " -> " + high);
            }
        }
        if (high != sta) {
            seats[high] = pivot;
            System.out.println(pivot.bro.get_color() + ": " + sta + " -> " + high);
        }
        return high;
    }

    void outputColor() {
        for (int i = 0; i < 7; i++)
            System.out.print(seats[i].bro.get_color() + "  ");
        System.out.println();
    }

    public class WaterLily{
        brothers bro;

        public WaterLily(brothers person){
            bro=person;
        }
    }
}

public class Sort {
    public int partition(Huluwa[] queue, int start, int end) {
        Huluwa pivot= queue[start];
        int i = start - 1;
        int j = end + 1;
        while (true){
            do{
                i=i+1;
            }while (queue[i].getRank().compareTo(pivot.getRank())<0);
            do{
                j=j-1;
            }while (queue[j].getRank().compareTo(pivot.getRank())>0);
            //报告交换次序
            if(i<j){
                queue[i].changePosition(j + 1);
                queue[j].changePosition(i + 1);

                Huluwa tmp = queue[i];
                queue[i] = queue[j];
                queue[j] = tmp;

                queue[i].reportSwitch(queue[j]);
                queue[j].reportSwitch(queue[i]);
            }

            else break;
        };
        return j;
    }

    public void quickSort(Huluwa[] queue,int start,int end) {
        if(start>=end) return;
        int splitpoint= partition(queue,start,end);
        quickSort(queue,start,splitpoint);     // Hoare Partition,区分区间完成后pivot不一定在中间
        quickSort(queue,splitpoint+1,end);
    }

    public void bubbleSort(Huluwa[] queue) {
        for (int i = 0; i < queue.length - 1; i++)
            for (int t = 0; t < queue.length - 1 - i; t++)
                if (queue[t].getColor().compareTo(queue[t + 1].getColor()) > 0) {

                    Huluwa tmp = queue[t];
                    queue[t] = queue[t + 1];
                    queue[t + 1] = tmp;
                    //报告交换次序
                    queue[t].reportSwitch(queue[t+1]);
                    queue[t+1].reportSwitch(queue[t]);

                    queue[t].changePosition(t+2);
                    queue[t+1].changePosition(t+1);

                }

    }
}

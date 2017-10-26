public class Run {
    public static void queueReportRank(Queue q){
        for(Huluwa h:q.queue){
            h.reportRank();
        }
    }
    public static void queueReportColor(Queue q){
        for(Huluwa h:q.queue){
            h.reportColor();
        }
    }
    public  static void main(String args[]){
        //随意站队
        Sort mysort = new Sort();
        Queue queue1= new Queue();
        System.out.println("第一次随机站队后顺序:");
        queueReportRank(queue1);
        //冒泡排序
        mysort.bubbleSort(queue1.queue);
        System.out.println("冒泡排序后顺序:");
        //报数
        queueReportRank(queue1);

        //再次重新排队
        Queue queue2=new  Queue();
        System.out.println("第二次随机站队后顺序:");
        queueReportColor(queue2);
        //快速排序
        mysort.quickSort(queue2.queue,0,queue2.size-1);
        System.out.println("快速排序后顺序:");
        //报数
        queueReportColor(queue2);
    }
}

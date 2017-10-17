public class HuluBrotherSort {
    HuluBrother []hlb=new HuluBrother[7];
    MyQueue myqueue=new MyQueue();

    HuluBrotherSort(){
        for (int i=0;i<7;i++){
            hlb[i]=new HuluBrother();
        }

        hlb[0].setNum(1); hlb[0].setClr(Color.CHI); hlb[0].setName("大娃");
        hlb[1].setNum(2); hlb[1].setClr(Color.CHENG); hlb[1].setName("二娃");
        hlb[2].setNum(3); hlb[2].setClr(Color.HONG); hlb[2].setName("三娃");
        hlb[3].setNum(4); hlb[3].setClr(Color.LV); hlb[3].setName("四娃");
        hlb[4].setNum(5); hlb[4].setClr(Color.QING); hlb[4].setName("五娃");
        hlb[5].setNum(6); hlb[5].setClr(Color.LAN); hlb[5].setName("六娃");
        hlb[6].setNum(7); hlb[6].setClr(Color.ZI); hlb[6].setName("七娃");

    }

    int partitionMethod(int left, int right){
        int splitpt=left;
        Position pivot;
        pivot=myqueue.position[left];

        for (int i=left+1;i<=right;i++) {
            if (myqueue.position[i].holder.clr.ordinal() < pivot.holder.clr.ordinal()) {
                splitpt++;
                hlb[i].swap(myqueue,i,splitpt);
            }
        }

        hlb[left].swap(myqueue,left,splitpt);
        return splitpt;

    }

    void quickSort(int left, int right){
        if (left<right){
            int mid=partitionMethod(left,right);
            quickSort(left,mid-1);
            quickSort(mid+1,right);
        }
        return;
    }

    void bubbleSort(){
        for (int i=0;i<hlb.length-1;i++){
            for (int j=0;j<hlb.length-1-i;j++){
                if (myqueue.position[j].holder.num>myqueue.position[j+1].holder.num)
                    hlb[j].move(myqueue,j);
            }
        }
    }

    void printMyQueue(){
        for (int i=0;i<hlb.length;i++){
            System.out.print(myqueue.position[i].holder.getName()+" ");
        }

        System.out.println("");
    }

    public static void main(String[] args){
        HuluBrotherSort hlbsort=new HuluBrotherSort();

        hlbsort.myqueue.allEnQueue(hlbsort.hlb);
        hlbsort.myqueue.randomStandInLine();
        System.out.println("Randomly Stand in Line:");
        hlbsort.printMyQueue();
        System.out.println("");

        hlbsort.bubbleSort();
        System.out.println("After BubbleSort:");
        hlbsort.printMyQueue();
        System.out.println("");

        hlbsort.myqueue.randomStandInLine();
        System.out.println("Randomly Stand in Line:");
        hlbsort.printMyQueue();
        System.out.println("");

        hlbsort.bubbleSort();
        System.out.println("After QuickSort:");
        hlbsort.printMyQueue();
        System.out.println("");
    }
}

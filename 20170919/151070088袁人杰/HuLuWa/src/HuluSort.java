import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuluSort {
    private int length;
    private Box[] boxes;

    public static void main(String[] args) {

        //生成葫芦娃兄弟
        Huluwa[] bros = new Huluwa[7];
        for (int i=0;i<bros.length;i++){
            bros[i] = new Huluwa(i+1);
        }

        //生成盒子
        Box[] boxes = new Box[7];
        for (int i=0;i<boxes.length;i++){
            boxes[i] = new Box(i+1,bros[i]);
        }

        //生成队列
        HuluSort Line = new HuluSort(boxes.length,boxes);//通过移动盒子来实现排序

        Line.shuffle(7);
        Line.report();
        Line.bubbleSort();
        Line.report();

        Line.shuffle(7);
        Line.report();
        Line.binaryInsertSort();
        Line.report();




/*
        //随机站队
        System.out.println("\n随机站队！");
        bros = shuffle(7);
        print(bros);

        //冒泡排序
        bubbleSort(bros);
        System.out.println("\n冒泡排序结果！");
        print(bros);

        //再次随机站队
        System.out.println("\n再次随机站队！");
        bros = shuffle(7);
        print(bros);

        //二分排序
        binaryInsertSort(bros);
        System.out.println("\n二分插入排序结果！");
        print(bros);



*/
    }

    public HuluSort() {

    }

    public HuluSort(int length, Box[] nboxes) {
        this.length = length;
        this.boxes = nboxes;
    }

    public Box[] getBoxes() {
        return boxes;
    }

    public int getLength() {
        return length;
    }

    public void setBoxes(Box[] boxes) {
        this.boxes = boxes;
    }

    public void setLength(int length) {
        this.length = length;
    }



    public void bubbleSort(){
        System.out.println("\n冒泡排序过程！");
        for (int i=0;i<this.length-1;i++){
            for (int j=0;j<this.length-1-i;j++){
                if (this.boxes[j].readRanking()>this.boxes[j+1].readRanking()){
                    Box temp = this.boxes[j];
                    this.boxes[j]=this.boxes[j+1];
                    this.boxes[j+1]=temp;
                    System.out.print(this.boxes[j].readName()+":"+ (j+1) +"->"+j+ ", ");
                }
            }
        }
        System.out.println();
    }

    public void binaryInsertSort(){
        System.out.println("\n二分插入排序过程！");
        Box temp;
        int i=1;
        int j;
        while ( i < this.length){
            temp = this.boxes[i];
            int left = 0;
            int right = i-1;
            while (left<=right){
                int mid = (left+right)/2;
                if (temp.getBoxcode()<this.boxes[mid].getBoxcode())
                    right=mid-1;
                else
                    left=mid+1;
            }
            for (j=i-1;j>=left;j--){
                this.boxes[j+1]=this.boxes[j];
            }
            this.boxes[left]=temp;
            System.out.print(temp.readName()+":"+ i +"->"+left+ ", ");
            i++;
        }
        System.out.println();

    }

    public Box[] shuffle(int len){
        System.out.println("\n打乱顺序");
        List list = new ArrayList<Box>();
        for (int i=0;i<this.length;i++) {
            list.add(this.boxes[i]);
        }
        Collections.shuffle(list);
        list.toArray(this.boxes);
        return this.boxes;
    }

    public void report(){
        for (int i=0;i<length;i++) {
            System.out.print(this.boxes[i].readName()+", ");
        }
        System.out.println();
    }

}


class Box {
    private int boxcode;
    private Huluwa boys;

    public Box(){

    }

    public Box(int code){
        this.boxcode = code;
    }

    public Box(int code, Huluwa hulu){
        this.boys = hulu;
        this.boxcode = code;

    }

    public int getBoxcode() {
        return boxcode;
    }

    public String readName() {
        return boys.getName();
    }

    public String readColor() {
        return boys.getColor();
    }

    public int readRanking() {
        return boys.getRanking();
    }
}
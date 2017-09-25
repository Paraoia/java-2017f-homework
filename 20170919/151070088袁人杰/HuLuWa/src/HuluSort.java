import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuluSort {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        //生成葫芦娃兄弟
        Huluwa[] bros = new Huluwa[7];
        for (int i=0;i<bros.length;i++){
            bros[i] = new Huluwa(i+1);
        }
        System.out.println("生成葫芦娃兄弟！");
        print(bros);

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




    }

    public static void bubbleSort(Huluwa[] arr){
        System.out.println("\n冒泡排序过程！");
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j].getRanking()>arr[j+1].getRanking()){
                    Huluwa temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    System.out.print("Lao"+arr[j].getRanking()+":"+ (j+1) +"->"+j+ ", ");
                }
            }
        }
    }

    public static void binaryInsertSort(Huluwa[] arr){
        System.out.println("\n二分插入排序过程！");
        Huluwa temp;
        int i=1;
        int j;
        while ( i < arr.length){
            temp = arr[i];
            int left = 0;
            int right = i-1;
            while (left<=right){
                int mid = (left+right)/2;
                if (temp.getRanking()<arr[mid].getRanking())
                    right=mid-1;
                else
                    left=mid+1;
            }
            for (j=i-1;j>=left;j--){
                arr[j+1]=arr[j];
            }
            arr[left]=temp;
            System.out.print("Lao"+temp.getRanking()+":"+ i +"->"+left+ ", ");
            i++;
        }

    }

    public static Huluwa[] shuffle(int len){
        Huluwa[] arr = new Huluwa[len];
        for (int i=0;i<arr.length;i++){
            arr[i] = new Huluwa(i+1);
        }

        List list = new ArrayList<Huluwa>();
        for (int i=0;i<arr.length;i++) {
            list.add(arr[i]);
        }

        Collections.shuffle(list);
        list.toArray(arr);
        return arr;

    }

    public static void print(Huluwa[] arr){
        for (int i=0;i<arr.length;i++) {
            System.out.print("Lao"+arr[i].getRanking()+" "+arr[i].getColor()+", ");
        }
        System.out.println();
    }

}

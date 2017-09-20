import java.util.ArrayList;
import java.util.List;


public class ArrayListToAry {
    static String[] s={"0","老大","老二","老三","老四","老五","老六","小七"};
    static String[] c={"0","红色","橙色","黄色","绿色","青色","蓝色","紫色"};

    //生成一个1,2,3,4,5,6，7的随机数组
        public static void main(String[] args) {
            // 数组
            int[] ary = new int[7];
            // 集合 ,临时集合temp存放1~10个数字
            ArrayList<Integer> temp = new ArrayList<Integer>();
            //list集合存放需要的数字
            ArrayList<Integer> list = new ArrayList<Integer>();
            // 给集合添加1~10的数字
            for (int i = 1; i < 8; i++) {
                temp.add(i);
            }
            // while循环 随即抽取集合的数字给数组
            int index = 0;
            while (true) {
                if (list.size() == 7) {
                    break;
                }
                int it = temp.get((int) (Math.random() * 7));
                //如果list存在这个数组就继续循环
                if (list.contains(it)) {
                    continue;
                } else {
                    //如果list不存在这个数字，那么就把这个数字给数组，并且在list中加入这个数字
                    ary[index] = it;
                    list.add(it);
                    index++;
                }
            }
            // /输出数组的元素
            System.out.print("葫芦兄弟随机初序列为:");
            for (int i = 0; i < ary.length; i++) {
                System.out.print(s[ary[i]] + " ");
            }
            System.out.print("\n");
            int[] ary2={0,0,0,0,0,0,0};
            for (int i =0;i<7;i++)
                ary2[i]=ary[i];
            System.out.println("下面开始冒泡排序");
            bubbleSort(ary);
            System.out.println("经过冒泡排序之后...");
            for (int i = 0; i < ary.length; i++) {
                System.out.print(s[ary[i]] + " ");}
            System.out.println();
            System.out.println();

            System.out.print("葫芦兄弟随机初序列为:");
            for (int i = 0; i < ary2.length; i++) {
                System.out.print(s[ary2[i]] + " ");
            }
            System.out.println();
            System.out.println("下面开始二分法排序");
            mergeSort(ary2);
            System.out.println("经过二分法排序之后...");
            for (int i = 0; i < ary2.length; i++) {
                System.out.print(c[ary2[i]] + " ");}
        }

    private static void bubbleSort(int a[])
    {
        for(int i=1;i<a.length;i++)
            for(int j=0;j<a.length-i;j++)
            {
                if(a[j]>a[j+1])//相邻两数进行比较
                {
                    System.out.println(s[a[j]]+":"+j+"->"+(j+1));
                    System.out.println(s[a[j+1]]+":"+(j+1)+"->"+j);
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;

                }
            }

    }
    private static void mergeSort(int[] a) {
        Sort(a, 0, a.length - 1);
    }

    private static void Sort(int[] a, int left, int right) {
        if(left>=right)
            return;

        int mid = (left + right) / 2;
        Sort(a, left, mid);
        Sort(a, mid + 1, right);
        merge(a, left, mid, right);

    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex=left;
        // 逐个归并
        while(left <=mid && r1 <= right) {
            if (a[left] <= a[r1])
            {
                if(left!=tIndex)
                    System.out.println(s[a[left]]+":"+left+"->"+tIndex);
                tmp[tIndex++] = a[left++];
            }
            else {
                if(r1!=tIndex)
                    System.out.println(s[a[r1]]+":"+r1+"->"+tIndex);
                tmp[tIndex++] = a[r1++];
            }
        }
        // 将左边剩余的归并
        while (left <=mid) {
            if(left!=tIndex)
                System.out.println(s[a[left]]+":"+left+"->"+tIndex);
            tmp[tIndex++] = a[left++];
        }
        // 将右边剩余的归并
        while ( r1 <= right ) {
            if(r1!=tIndex)
                System.out.println(s[a[r1]]+":"+r1+"->"+tIndex);
            tmp[tIndex++] = a[r1++];
        }
        //从临时数组拷贝到原数组
        while(cIndex<=right){
            a[cIndex]=tmp[cIndex];
            //输出中间归并排序结果
            cIndex++;
        }

    }
}

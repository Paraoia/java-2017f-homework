import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {  	
        HashSet<calabash> calabashes = new HashSet<>();
        calabashes.add(new calabash("老大", 1, "赤"));
        calabashes.add(new calabash("老二", 2, "橙"));
        calabashes.add(new calabash("老三", 3, "黄"));
        calabashes.add(new calabash("老四", 4, "绿"));
        calabashes.add(new calabash("老五", 5, "青"));
        calabashes.add(new calabash("老六", 6, "蓝"));
        calabashes.add(new calabash("老七", 7, "紫"));
        calabash[] calabashes1 = new calabash[7];

        //实现随机站队
        Iterator<calabash> iterator = calabashes.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            calabashes1[index] = iterator.next();
            index++;
        }
    	//当前顺序报数
    	System.out.println("当前随机顺序:");
    	for (int i = 0; i < calabashes1.length; i++) {
            System.out.print(calabashes1[i].rank + " ");
        }
    	System.out.println();
    	//冒泡排序
    	bubbleSort(calabashes1);
    	System.out.println("冒泡排序后:");
        for (int i = 0; i < calabashes1.length; i++) {
            System.out.println(calabashes1[i].rank + " ");
        }
        System.out.println();
        //再次随机站队
        iterator = calabashes.iterator();
        index = 0;
        while (iterator.hasNext()) {
            calabashes1[index] = iterator.next();
            index++;
        }
        //当前顺序报数
    	System.out.println("当前随机顺序:");
    	for (int i = 0; i < calabashes1.length; i++) {
            System.out.print(calabashes1[i].color + " ");
        }
    	System.out.println();
        //快速排序
    	quickSort(calabashes1,0,calabashes1.length-1);
    	System.out.println("快速排序后:");
        for (int i = 0; i < calabashes1.length; i++) {
            System.out.print(calabashes1[i].color + " ");
        }
        System.out.println();
    }

    //冒泡排序
    public static void bubbleSort(calabash[] calabashes) {
        for (int i = 0; i < calabashes.length; i++) {
            for (int j = 0; j < calabashes.length - 1 - i; j++) {
                if (calabashes[j].index > calabashes[j + 1].index) {
                    swap(calabashes, j, j + 1);
                }
            }
        }
    }

    //交换位置并输出移动信息
    public static void swap(calabash[] calabashes, int i, int j) {
        System.out.println(calabashes[i].rank + " : " + i + " -> " + j);
        System.out.println(calabashes[j].rank + " : " + j + " -> " + i);
        calabash temple = calabashes[i];
        calabashes[i] = calabashes[j];
        calabashes[j] = temple;
    }

    //快速排序
    public static void quickSort(calabash[] calabashes, int start, int end){
    	int i = start,j = end;
    	while(i<j) {
    		while(j>i && calabashes[j].index >= calabashes[start].index)
    			j--;
    		if(i<j) {
    			swap(calabashes, i, j);
    			i++;
    		}
    		while(i<j && calabashes[i].index <= calabashes[j].index) 
    			i++;
    		if(i<j) {
    			swap(calabashes, i, j);
    			j--;
    		}
    	}
    	 if(start<i-1)
    		 quickSort(calabashes, start, i-1);
    	 if(i+1<end)
    		 quickSort(calabashes, i+1, end);
    }
    
    public static void move(calabash[] calabashes, int i, int j) {
        System.out.println(calabashes[i].rank + " : " + i + " -> " + j);
    }
}
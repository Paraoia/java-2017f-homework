import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class start{

    public static void main(String [] args){

       calabash []brothers = new calabash[7];
       queue brotherQueue = new queue();
       brotherQueue.setPositions(7);


        //冒泡排序并报名字
       lineUp(brothers);
       brotherQueue.sitDown(brothers);
       brotherQueue.bubbleSort();
       brotherQueue.numOff();

        //快速排序并报颜色
       lineUp(brothers);
       brotherQueue.sitDown(brothers);
       brotherQueue.quickSort(0,6);
       brotherQueue.colorOff();

    }

    /*
    实现葫芦娃初始随机排队
     */
    public static void lineUp(calabash[] brothers){
        int []arr = getRandoms(1,7,7);
        for (int i = 0; i < 7; i++) {
            calabash temp = new calabash(arr[i]);
            brothers[i] = temp;
            //System.out.println(brothers[i].getName().getName() + brothers[i].getColor().getColor());
        }
    }

    /*
    获取1-7七个不重复的随机数
     */
    private static int[] getRandoms(int min, int max, int count){
        int[] randoms = new int[count];
        List<Integer> listRandom = new ArrayList<Integer>();

        if( count > ( max - min + 1 )){
            return null;
        }

        for(int i = min; i <= max; i++){
            listRandom.add(i);
        }

        for(int i = 0; i < count; i++){
            Random random = new Random();
            int index = random.nextInt(listRandom.size());
            randoms[i] = listRandom.get(index);
            listRandom.remove(index);
        }
        return randoms;
    }
}
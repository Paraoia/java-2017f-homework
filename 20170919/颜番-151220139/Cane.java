package FancyYan.HuluSort;


/**
 * 葫芦藤曼，包含一个长度为7的数组，用于存储7个葫芦娃
 * 内置冒泡排序，快速排序算法，对葫芦娃进行排序
 */
public class Cane {
    HuluBaby[] HuluBabies;
    static final int HuluCount = 7;

    Cane(){
        HuluBabies = new HuluBaby[HuluCount];
        RandomSetPos();
    }

    /**
     * 随机化设置葫芦娃位置
     */
    public void RandomSetPos(){
        HuluBabies[0] = new HuluBaby(6);
        HuluBabies[1] = new HuluBaby(2);
        HuluBabies[2] = new HuluBaby(3);
        HuluBabies[3] = new HuluBaby(1);
        HuluBabies[4] = new HuluBaby(4);
        HuluBabies[5] = new HuluBaby(7);
        HuluBabies[6] = new HuluBaby(5);
    }



    /**
     * 交换数组中两个葫芦娃的位置
     * @param x 被交换的葫芦娃位置
     * @param y 被交换的葫芦娃位置
     */
    private void exchangeValues(int x, int y){
        HuluBaby temp = HuluBabies[x];
        HuluBabies[x]=HuluBabies[y];
        HuluBabies[y]=temp;
    }

    /**
     * 让藤上葫芦依次报告自己排行，输出到屏幕
     */
    public void reportPosRank(){
        for(int i=0; i<7; i++)
            System.out.println(HuluBabies[i].reportRank());
    }

    /**
     * 让藤上葫芦一次报告自己的颜色，输出到屏幕
     */
    public void reportPosColor(){
        for(int i=0; i<7; i++)
            System.out.println(HuluBabies[i].reportColor());
    }

    /**
     * 对藤上乱序的葫芦娃进行冒泡排序
     */
    public void bubbleSort(){
    //    System.out.println("葫芦娃变阵！冒泡排序开始：");
        for(int count = 0; count<HuluCount-1; count++){
            for(int index = 0; index<HuluCount-count-1; index++){
                if(HuluBabies[index].getRank()>HuluBabies[index+1].getRank()){
                    HuluBabies[index].reportExchangePos(index, index+1);
                    HuluBabies[index+1].reportExchangePos(index+1, index);
                    exchangeValues(index, index+1);
                }
            }
        }

    //    System.out.println("冒泡排序结束，葫芦娃报数：");
    //    reportPosRank();
    }


    private int split(int left, int right){
        int splitPos=left;
        int index = left+1;
        for(; index<=right; index++){
            if(HuluBabies[index].getRank()<HuluBabies[left].getRank()){
                splitPos++;
                HuluBabies[splitPos].reportExchangePos(splitPos, index);
                HuluBabies[index].reportExchangePos(index, splitPos);
                exchangeValues(splitPos, index);
            }
        }

        HuluBabies[splitPos].reportExchangePos(splitPos, left);
        HuluBabies[left].reportExchangePos(left, splitPos);
        exchangeValues(left, splitPos);
        return splitPos;
    }

    /**
     * 对藤上某一段葫芦娃进行快速排序
     * @param left 排序开始位置
     * @param right 排序结束位置
     */
    public void quickSort(int left, int right){
        if(left<right) {
            int splitPos = split(left, right);
            quickSort(left, splitPos - 1);
            quickSort(splitPos + 1, right);
        }
    }
}

import java.util.Random;

public class Grandfather {
    HuluBaby[] HuluBabies;
    int HuluCount = 7;

    Grandfather(){
        HuluBabies = new HuluBaby[HuluCount];
        int s = getRandomOneToSeven();
        for(int i = 0 ;i<7; i++){
            HuluBaby temp = new HuluBaby((s+i)%7+1);
            HuluBabies[i] = temp;
        }
    }

    private int getRandomOneToSeven(){
        int max = 7;
        int min = 1;
        Random random = new Random();

        int s = random.nextInt(max-1)+min;
        return s;
    }

    private void exchangeValues(int x, int y){
        HuluBaby temp = HuluBabies[x];
        HuluBabies[x]=HuluBabies[y];
        HuluBabies[y]=temp;
    }

    public void resetPos(){
        int s = getRandomOneToSeven();
        for(int i = 0 ;i<7; i++){
            HuluBaby temp = new HuluBaby((s+i)%7+1);
            HuluBabies[i] = temp;
        }
    }

    public void bubbleSort(){
        System.out.println("葫芦娃变阵！冒泡排序开始：");
        for(int count = 0; count<HuluCount-1; count++){
            for(int index = 0; index<HuluCount-count-1; index++){
                if(HuluBabies[index].getRank()>HuluBabies[index+1].getRank()){
                    HuluBabies[index].reportExchangePos(index, index+1);
                    HuluBabies[index+1].reportExchangePos(index+1, index);
                    exchangeValues(index, index+1);
                }
            }
        }

        System.out.println("冒泡排序结束，葫芦娃报数：");
        for(int i=0; i<7; i++)
            System.out.println(HuluBabies[i].reportRank());
    }

    public void reportPosRank(){
        for(int i=0; i<7; i++)
            System.out.println(HuluBabies[i].reportRank());
    }
    public void reportPosColor(){
        for(int i=0; i<7; i++)
            System.out.println(HuluBabies[i].reportColor());
    }

    public int split(int left, int right){
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

    void quickSort(int left, int right){
        if(left<right) {
            int splitPos = split(left, right);
            quickSort(left, splitPos - 1);
            quickSort(splitPos + 1, right);
        }
    }
}

import java.util.*;

class Queue{
    private Position[] positions;
    // 构造函数
    public Queue(){
        positions = new Position[7];
        for (int i=0; i<positions.length; i++){
            positions[i] = new Position();
            positions[i].index = i;
            positions[i].holder = null;
        }
    }
    // 随机入队
    public void randomEnqueue(Huluwa[] huluwas) {
        if (huluwas.length > this.positions.length) {
            return;
        }
        for (int i=0; i<positions.length; i++){
            int randomPosition = new Random().nextInt(7);
            while (positions[randomPosition].holder != null){
                randomPosition = new Random().nextInt(7);
            }
            positions[randomPosition].holder = huluwas[i];
        }
    }
    // 全部出队
    public void allDequeue(){
        for (int i=0; i<positions.length; i++) {
            positions[i].holder = null;
        }
    }
    // 让所有娃报排行
    public void repoName(){
        for (int i=0; i<positions.length; i++){
            positions[i].holder.repoName();
        }
        System.out.print("\n");
    }
    // 让所有娃报颜色
    public void repoColor(){
        for (int i=0; i<positions.length; i++) {
            positions[i].holder.repoColor();
        }
        System.out.print("\n");
    }
    // 根据排行冒泡排序 & 报告交换动作
    // 位置信息从1开始记
    public void bubbleSort(){
        for(int i = 0; i < positions.length; i++) {
            boolean exchangeHappened = false;
            for (int j = 0; j < positions.length - 1 - i; j++) {
                if (positions[j].holder.isYounger(positions[j + 1].holder)) {
                    exchangeHappened = true;
                    positions[j].holder.swap(positions[j], positions[j+1]);
                }
            }
            if (!exchangeHappened) {
                break;
            } else{
                System.out.print("\n");
            }
        }
    }
    // 根据颜色快速排序 & 报告交换动作
    // 位置信息从1开始记
    private int split(int left, int right) {
        int i = left;
        int j = right;
        Position tmpPosition = new Position();
        tmpPosition.holder = null;
        tmpPosition.index = -1;
        positions[i].holder.move(positions[i], tmpPosition);
        while (i<j)
        {
            while (i<j && (!positions[j].holder.isOlder(tmpPosition.holder)))
                j--;
            if (i<j) {
                positions[j].holder.move(positions[j], positions[i]);
            }
            while (i<j && (!positions[i].holder.isYounger(tmpPosition.holder)))
                i++;
            if (i<j){
                positions[i].holder.move(positions[i], positions[j]);
            }
        }
        tmpPosition.holder.move(tmpPosition, positions[i]);
        return i;
    }
    public void quickSort(int left, int right){
        int pivot;
        if (left<right)
        {
            pivot = split(left, right);
            quickSort(left, pivot - 1);
            quickSort(pivot + 1, right);
        }
    }
}

class Position {
    public int index;
    public Huluwa holder;
}
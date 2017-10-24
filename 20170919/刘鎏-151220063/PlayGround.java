public class PlayGround {
    public static final int MAX = 7; //规定最多7个葫芦娃
    public static void main(String[] args){
        HuLuWaPlaying playing = new HuLuWaPlaying(); //构造葫芦娃在玩 构造函数构造了7个葫芦娃对象
        playing.randStand(true); //随机站队 mode表示按颜色or排行
        playing.bubbleSort(); //冒泡排序
        playing.displayRank(true);
        playing.randStand(false); //随机站队
        playing.quickSort(); //快速排序
        playing.displayRank(false);
    }
}

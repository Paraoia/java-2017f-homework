public class PlayGround {
    public static void main(String[] args){
        HuLuWaPlaying playing = new HuLuWaPlaying(); //构造葫芦娃在玩 构造函数构造了7个葫芦娃对象
        playing.randStand(true); //随机站队
        playing.bubbleSort(); //冒泡排序
        playing.randStand(false); //随机站队
        playing.quickSort(); //快速排序
    }
}

/**
 * Created by cbcwe on 2017/9/22.
 */
public class GourdDoll {
    /***
     * 模拟一个葫芦娃
     * name:葫芦娃的名字
     * value:0代表大娃，1代表2娃，以此类推
     */
    String name;
    int value;

    public GourdDoll(int new_value) {
        value = new_value;
        value %= 7;
        switch (value) {
            case 0:
                name = "红娃";
                break;
            case 1:
                name = "橙娃";
                break;
            case 2:
                name = "黄娃";
                break;
            case 3:
                name = "绿娃";
                break;
            case 4:
                name = "青娃";
                break;
            case 5:
                name = "蓝娃";
                break;
            case 6:
                name = "紫娃";
                break;
            default:
                name = "谁家的孩子?";
        }
    }

    public void speakColor(){
        System.out.print(name+"! ");
    }

    public void speakRank(){
        switch(value){
            case 0:
                System.out.print("老大 ");
                break;
            case 1:
                System.out.print("老二 ");
                break;
            case 2:
                System.out.print("老三 ");
                break;
            case 3:
                System.out.print("老四 ");
                break;
            case 4:
                System.out.print("老五 ");
                break;
            case 5:
                System.out.print("老六 ");
                break;
            case 6:
                System.out.print("老七 ");
                break;
            default:
                System.out.print("爷爷什么时候多摘了个葫芦？ ");

        }
    }
}

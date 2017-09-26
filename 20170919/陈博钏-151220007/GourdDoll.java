/**
 * Created by cbcwe on 2017/9/22.
 * Edited by cbcwe on 2017/9/26
 */
public class GourdDoll {
    /***
     * 模拟一个葫芦娃
     * name:葫芦娃的名字
     * rank:0代表大娃，1代表2娃，以此类推
     */
    private String name;
    private int rank;

    // 获取葫芦娃的排行
    public int getRank(){
        return rank;
    }

    // 获取葫芦娃的名字
    public String getName(){
        return name;
    }

    public GourdDoll(int new_value) {
        rank = new_value;
        rank %= 7;
        switch (rank) {
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
        System.out.println(name+"诞生了");
    }

    // 报出葫芦娃的名字
    public void speakName(){
        System.out.print(name+" ");
    }

    // 报出葫芦娃的排行
    public void speakRank(){
        switch(rank){
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

    // 静态函数，交换GourdDoll数组的两个元素的值，即把葫芦娃a和葫芦娃b交换位置
    public static void swap(GourdDoll []gourdDoll , int a , int b){
        GourdDoll tmp = gourdDoll[a];
        gourdDoll[a] = gourdDoll[b];
        gourdDoll[b] = tmp;
    }
}

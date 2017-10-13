package HuluWaSort;

public class HuluWaFactory
{
    //生产一只葫芦娃
    public HuluWa produce(String colorname) throws Exception {
        HuluWa huluWa = null;
        switch(colorname){
            case "红": huluWa = new HuluWa(COLOR.RED);break;
            case "橙": huluWa = new HuluWa(COLOR.ORANGE);break;
            case "黄": huluWa = new HuluWa(COLOR.YELLOW);break;
            case "绿": huluWa = new HuluWa(COLOR.GREEN);break;
            case "青": huluWa = new HuluWa(COLOR.CYAN);break;
            case "蓝": huluWa = new HuluWa(COLOR.BLUE);break;
            case "紫": huluWa = new HuluWa(COLOR.PURPLE);break;
            default:throw new Exception("没有这个颜色（"+colorname+"）的葫芦娃！");
        }
        return huluWa;
    }
}

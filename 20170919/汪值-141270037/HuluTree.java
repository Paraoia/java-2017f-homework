public class HuluTree {
    private static String[] names = {"老大","老二","老三","老四","老五","老六","老七"};
    private static String[] colors = {"红色","橙色","黄色","绿色","青色","蓝色","紫色"};

    public static Huluwa[] createHuluwas(){
        Huluwa[] huluwas = new Huluwa[7];
        for(int i = 0; i < huluwas.length; i++) {
            huluwas[i] = new Huluwa(names[i], colors[i], i+1);
        }
        return huluwas;
    }
}

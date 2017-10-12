public class CalabashBro {
    String name;
    String color;
    int[] signature;
    CalabashBro(int seq){
        signature = new int[2];
        switch (seq){
            case 0: name = "老大"; color = "红色"; signature[0] = 0; signature[1] = 0; break;
            case 1: name = "老二"; color = "橙色"; signature[0] = 1; signature[1] = 1; break;
            case 2: name = "老三"; color = "黄色"; signature[0] = 2; signature[1] = 2; break;
            case 3: name = "老四"; color = "绿色"; signature[0] = 3; signature[1] = 3; break;
            case 4: name = "老五"; color = "青色"; signature[0] = 4; signature[1] = 4; break;
            case 5: name = "老六"; color = "蓝色"; signature[0] = 5; signature[1] = 5; break;
            case 6: name = "老七"; color = "紫色"; signature[0] = 6; signature[1] = 6; break;
        }
    }
    final String getName() {
        return name;
    }
    final String getColor() {
        return color;
    }
    public static boolean isGreater(CalabashBro X, CalabashBro Y, int seqSignature){
        if(seqSignature < 0 || seqSignature > 1)    return false;
        return X.signature[seqSignature] > Y.signature[seqSignature];
    }
}

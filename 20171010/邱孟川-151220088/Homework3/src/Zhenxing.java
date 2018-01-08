public class Zhenxing {
    private Position[] positions;
    private ZNAME name;

    public Position[] getPositions() {
        return positions;
    }

    public String getName(){
        return name.toString();
    }

    public Zhenxing(ZNAME name, Position[] positions){
        this.name = name;
        this.positions = positions;
    }

    public void setZhenxing(ZNAME name, Position[] positions) {
        this.name = name;
        this.positions = positions;
    }
}

enum ZNAME{
    鹤翼("鹤翼"), 雁形("雁形"), 衡轭("衡轭"), 长蛇("长蛇"), 鱼鳞("鱼鳞"), 方円("方円"), 偃月("偃月"), 锋矢("锋矢");
    private final String key;
    private ZNAME(String key){
        this.key = key;
    }

    public static ZNAME getZNAME(String s){
        for(ZNAME a: ZNAME.values())
            if(a.key.equals(s))
                return a;
        return null;
    }
}
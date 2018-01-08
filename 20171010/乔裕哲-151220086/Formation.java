public class Formation {
    //用来变换阵法的类

    private Creature []creatures;
    private Position leaderPos;//creatures中的第一个元素作为leader
    private Direction dir;

    //数组的第一个元素作为leader，以leader的位置作为参考，每个阵法都有leader的位置说明，目前只实现了部分阵法
    //偃月的默认方向是right，其他默认方向为up，默认方向就是图中对应的阵型方向
    //根据方向会对阵型进行旋转，以leader为旋转中心，逆时针旋转，默认不转，right转1次，down2次，left3次
    public void changeFormation(Creature []creatures, Format format, Position leaderPos, Direction dir){
        this.creatures = creatures;
        this.leaderPos = leaderPos;
        this.dir = dir;
        switch (format) {
            case 偃月:
                break;
            case 冲轭:
                chongE();
                break;
            case 方圆:
                break;
            case 锋矢:
                break;
            case 长蛇:
                changShe();
                break;
            case 雁行:
                yanXing();
                break;
            case 鱼鳞:
                break;
            case 鹤翼:
                heYi();
                break;
            default:
                break;
        }
        if(format == Format.偃月){

        }
        else{
            int rotationTimes = dir.ordinal();
            for(int i = 1; i <= rotationTimes; ++i)
                rotation();
        }
    }

    //up方向的长蛇是最上面的人为leader
    private void changShe(){
        int x = leaderPos.getX();
        int y = leaderPos.getY();
        for(int i = 0; i < creatures.length; ++i)
            creatures[i].getPosition().setPosition(x, y + i);
    }

    //鹤翼是尖的那个人为leader
    private void heYi(){
        int x = leaderPos.getX();
        int y = leaderPos.getY();
        int shift = 0;
        for(int i = 0; i < creatures.length; ++i)
            if(i % 2 == 0){
                creatures[i].getPosition().setPosition(x - shift,  y - shift);
            }
            else {
                shift++;
                creatures[i].getPosition().setPosition(x + shift, y - shift);
            }
    }

    //up方向的雁行是最上面的人
    private void yanXing(){
        int x = leaderPos.getX();
        int y = leaderPos.getY();
        for(int i = 0; i < creatures.length; ++i)
            creatures[i].getPosition().setPosition(x - i, y + i);
    }

    private void chongE() {
        int x = leaderPos.getX();
        int y = leaderPos.getY();
        for(int i = 0; i < creatures.length; ++i)
            if(i % 2 == 0){
                creatures[i].getPosition().setPosition(x, y + i);
            }
            else
                creatures[i].getPosition().setPosition(x - 1, y + i);
    }

    //逆时针转90°
    private void rotation(){
        for(int i = 1; i < creatures.length; ++i) {
            int x = creatures[i].getPosition().getX();
            int y = creatures[i].getPosition().getY();
            x -= leaderPos.getX();
            y -= leaderPos.getY();
            int temp = x;
            x = y;
            y = -temp;
            x += leaderPos.getX();
            y += leaderPos.getY();
            creatures[i].getPosition().setPosition(x, y);
        }
    }

}

enum Direction{up, right, down, left};
enum Format{鹤翼, 雁行, 冲轭, 长蛇, 鱼鳞, 方圆, 偃月, 锋矢};
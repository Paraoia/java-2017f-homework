public class Spectator implements Creature {

    private WATCHER watcher;
    private Position position;

    public WATCHER getWatcher() {
        return watcher;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }

    Spectator(WATCHER watcher) {
        this.watcher = watcher;
        position = null;
    }

    @Override
    public void report(){
    switch (watcher){
        case 爷爷: System.out.print("爷爷@(" +position.getX()+ "," + position.getY()+"）"+"葫芦娃加油\n"); break;
        case 蛇精: System.out.print("蛇精@(" +position.getX()+","+ position.getY()+") "+"蝎子精加油\n"); break;
        default: break;
    }
    }

    @Override
    public String toString(){
        return this.watcher.toString();
    }
}

enum WATCHER{
    爷爷, 蛇精
}
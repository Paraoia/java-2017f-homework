public class ChongE implements Formation{
    private Position nextPos;
    private DIRECTION direction;
    int cnt;

    @Override
    public Position nextPos() {
        Position current = new Position(nextPos.getX(), nextPos.getY());

        cnt++;

        int x = 1;
        int y = 1;

        if(cnt%2 == 1) {
            x = 1;
            y = -1;
        } else {
            x = 1;
            y = 1;
        }

        switch (direction) {
            case UP:
                nextPos.setPosition(current.getX()+x, current.getY()+y);
                break;
            case DOWN:
                nextPos.setPosition(current.getX()-x, current.getY()-y);
                break;
            case LEFT:
                nextPos.setPosition(current.getX()+y, current.getY()+x);
                break;
            case RIGHT:
                nextPos.setPosition(current.getX()-y, current.getY()-x);
                break;
        }

        return current;
    }

    ChongE(Position first, DIRECTION dic) {
        nextPos = new Position(first.getX(), first.getY());
        this.direction = dic;
        this.cnt = 0;
    }
}

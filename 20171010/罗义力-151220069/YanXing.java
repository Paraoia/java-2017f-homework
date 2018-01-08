public class YanXing implements Formation{
    private Position nextPos;
    private DIRECTION direction;
    int cnt;

    @Override
    public Position nextPos() {
        Position current = new Position(nextPos.getX(), nextPos.getY());

        cnt++;
        switch (direction) {
            case UP:
                nextPos.setPosition(current.getX() + 1, current.getY() - 1);
                break;
            case DOWN:
                nextPos.setPosition(current.getX() - 1, current.getY() + 1);
                break;
            case LEFT:
                nextPos.setPosition(current.getX() + 1, current.getY() + 1);
                break;
            case RIGHT:
                nextPos.setPosition(current.getX() - 1, current.getY() - 1);
                break;
        }


        return current;
    }

    YanXing(Position first, DIRECTION dic) {
        nextPos = new Position(first.getX(), first.getY());
        this.direction = dic;
        this.cnt = 0;
    }
}

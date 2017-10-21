import javafx.geometry.Pos;

public class ChangShe implements Formation{
    private Position firstPos;
    private DIRECTION direction;
    private int cnt;

    @Override
    public Position nextPos() {
        Position current = new Position(firstPos.getX(), firstPos.getY());

        cnt++;
        switch (direction) {
            case UP:
                current.setPosition(firstPos.getX() + cnt, firstPos.getY());
                break;
            case DOWN:
                current.setPosition(firstPos.getX() - cnt, firstPos.getY());
                break;
            case LEFT:
                current.setPosition(firstPos.getX(), firstPos.getY() + cnt);
                break;
            case RIGHT:
                current.setPosition(firstPos.getX(), firstPos.getY() - cnt);
                break;
        }

        return current;
    }

    ChangShe(Position first, DIRECTION dic) {
        firstPos = new Position(first.getX(), first.getY());
        this.direction = dic;
        this.cnt = 0;
    }
}

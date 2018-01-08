/**
 * Created by bingo on 2017/10/24.
 */

import java.util.Random;

public class Plane {
    private Position plane[][];
    private int dimension;

    Plane(int n) {
        dimension = n;
        plane = new Position[n][n];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                plane[i][j] = new Position(new Point(i, j));
            }
        }
    }

    public void clear() {
        for(int i = 0; i < dimension; i ++) {
            for(int j = 0; j < dimension; j ++) {
                plane[i][j].setHolder(null);
            }
        }
    }

    public void print() {
        for(int i = 0; i < dimension; i ++) {
            for(int j = 0; j < dimension; j ++) {
                if(plane[i][j].getHolder() == null) {
                    System.out.printf("%c ", ' ');
                } else {
                    System.out.printf("%c ", plane[i][j].getHolder().getSymb());
                }
            }
            System.out.println();
        }
    }

    public void addCreature(Point pos, Creature creature) {
        if(outOfBound(pos)) return;
        plane[pos.getX()][pos.getY()].setHolder(creature);
    }

    public void addFormation(Point pos, Formation form, Creature creatures[]) {
        Point points[] = form.getPoints();
        for(int i = 0; i < points.length; i ++) {
            int absX = pos.getX() + points[i].getX();
            int abxY = pos.getY() + points[i].getY();
            if(outOfBound(new Point(absX, abxY))) continue;
            plane[absX][abxY].setHolder(creatures[i]);
        }
    }

    private boolean outOfBound(Point pos) {
        return (pos.getX() >= this.dimension) || (pos.getX() < 0)
                || (pos.getY() >= this.dimension) || (pos.getY() < 0);
    }
}

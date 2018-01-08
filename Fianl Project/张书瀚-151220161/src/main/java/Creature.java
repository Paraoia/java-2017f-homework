import java.util.Random;

public abstract class Creature implements Constants {
    protected BattleField field;

    protected int x;
    protected int y;
    protected String imageName;

    protected int health;
    protected int damage;

    protected ORIENTATION orientation;
    protected boolean isAlive = true;

    public Creature(int x, int y, BattleField field, String imageName) {
        this.x = x;
        this.y = y;
        this.field = field;
        this.imageName = imageName;

        initPosition();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void initPosition() {
        this.field.positions[x][y].setOccupy();
        this.field.positions[x][y].setHolder(this);
        this.field.positions[x][y].setImageName(imageName);
    }

    public void attack(Creature creature, int damagePoints) {
        if (creature.isAlive()) {
            creature.getHurt(damagePoints);
        }
    }

    public void getHurt(int damagePoints) {
        health = health - damagePoints;
        if (health <= 0) {
            isAlive = false;
            field.positions[x][y].clearOccupy();
            field.positions[x][y].addDeadBodies("dead" + imageName);
        }
    }

    public void getHealed(int healPoints) {
        if (isAlive) {
            health = health + healPoints;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive, int healhPoints) {
        isAlive = alive;
        health = healhPoints;
    }

    public boolean march(ORIENTATION orientation) {
        int dx = 0, dy = 0;
        switch (orientation) {
            case LEFT:
                dx = -1;
                dy = 0;
                break;
            case RIGHT:
                dx = 1;
                dy = 0;
                break;
            case UP:
                dx = 0;
                dy = -1;
                break;
            case DOWN:
                dx = 0;
                dy = 1;
                break;
        }

        if (x + dx >= 0 && x + dx < WUNIT && y + dy >= 0 && y + dy < HUNIT) {
            if (!this.field.positions[x + dx][y + dy].isOccupy()) {
                this.field.positions[x + dx][y + dy].setOccupy();
                this.field.positions[x + dx][y + dy].setHolder(this);
                this.field.positions[x + dx][y + dy].setImageName(imageName);
                this.field.positions[x][y].clearOccupy();
                x = x + dx;
                y = y + dy;
                return true;
            }
        }
        return false;
    }

    public boolean probability(int x) {
        int r = new Random().nextInt(10);
        if (r < x) {
            return true;
        } else {
            return false;
        }
    }

    public int distanceTo(Creature creature) {
        return Math.abs(x - creature.getX()) + Math.abs(y - creature.getY());
    }

    public void moveToNearest(Creature nearest) {
        if (nearest != null) {
            if (nearest.getX() > x) {
                if(march(ORIENTATION.RIGHT))
                    return;
            }
            if (nearest.getX() < x) {
                if(march(ORIENTATION.LEFT))
                    return;
            }
            if (nearest.getY() > y) {
                if(march(ORIENTATION.DOWN))
                    return;
            }
            if (nearest.getY() < y) {
                if(march(ORIENTATION.UP))
                    return;
            }
        }

    }
}

enum ORIENTATION {
    LEFT, RIGHT, UP, DOWN,
}
import java.util.ArrayList;

public class Position {
    private int x, y;
    //private Image image;
    private String imageName;
    private ArrayList<String> deadBodies = new ArrayList<>();
    private boolean occupy;
    private Creature holder;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.occupy = false;
        this.holder = null;
    }

    public void setHolder(Creature creature) {
        holder = creature;
    }

    public Creature getHolder() {
        return holder;
    }

    public void setOccupy() {
        this.occupy = true;
    }

    public void clearOccupy() {
        this.occupy = false;
        this.holder = null;
        this.imageName = null;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    public void addDeadBodies(String imageName) {
        deadBodies.add(imageName);
    }

    public ArrayList<String> getDeadBodies() {
        return deadBodies;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public boolean isOccupy() {
        return occupy;
    }

    public String printStatus() {
        String rst = "";
        if (imageName != null) {
            rst = rst + imageName;
        }
        if (!deadBodies.isEmpty()) {
            for (String body : deadBodies) {
                rst = rst + " " + body;
            }
        }
        return rst;
    }

}

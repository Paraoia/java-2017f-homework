import java.util.Random;

public class Scorpion extends Creature implements Runnable {

    public Scorpion(int x, int y, BattleField field, String imageName) {
        super(x, y, field, imageName);
        health = 100;
        damage = 15;
    }


    protected Creature getNearest() {
        int minDis = Integer.MAX_VALUE;
        Creature nearest = null;
        for (Boy boy : this.field.boys) {
            if (boy.isAlive() && distanceTo(boy) < minDis) {
                minDis = distanceTo(boy);
                nearest = boy;
            }
        }
        return nearest;
    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            if (isAlive) {
                //System.out.println("run scorpion");
                Random random = new Random();
                Creature nearest = getNearest();
                moveToNearest(nearest);
                if (distanceTo(nearest) == 1) {
                    attack(nearest, damage);
                }

                try {
                    Thread.sleep(random.nextInt(1000) + 500);
                    field.repaint();
                    synchronized (this.field) {
                        if (this.field.battlestatus == BATTLESTATUS.FIGHTING) {
                            this.field.printPositions();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("scorpion:" + e);
                    Thread.currentThread().interrupt();
                }

                this.field.checkGameOver();
            }
            else {
                return;
            }
        }
    }
}

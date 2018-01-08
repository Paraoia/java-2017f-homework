import java.util.Random;

public class Goblin extends Creature implements Runnable {

    //private int no;
    //private COLOR color;      //颜色

    public Goblin(int x, int y, BattleField field, String imageName) {
        super(x, y, field, imageName);
        health = 40;
        damage = 15;
    }

    protected Creature getNearest() {
        int minDis = Integer.MAX_VALUE;
        Creature nearest = null;
        for (Boy boy : this.field.boys) {
            if(boy.getRank()==6) {
                continue;
            }
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
                ////System.out.println("run gob");
                Random random = new Random();
                Creature nearest = getNearest();
                moveToNearest(nearest);
                if (distanceTo(nearest) == 1) {
                    int newDamage = damage;
                    if (!this.field.scorpion.isAlive()) {
                        newDamage = newDamage - 3;
                    }
                    attack(nearest, newDamage);
                }

                try {
                    Thread.sleep(random.nextInt(1000) + 500);
                    field.repaint();
                    synchronized (this.field) {
                        if (this.field.battlestatus == BATTLESTATUS.FIGHTING) {
                            this.field.printPositions();
                        }
                    }
                    this.field.checkGameOver();
                } catch (Exception e) {
                    System.out.println("goblin:" + e);
                    Thread.currentThread().interrupt();
                }
            } else {
                return;
            }
        }
    }

}

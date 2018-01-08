import java.util.ArrayList;
import java.util.Random;

public class Snake extends Creature implements Runnable {

    private boolean canUltimate = true;
    //private boolean pictureChoose = true;
    public ArrayList<Goblin> newgobs = new ArrayList<>();

    public Snake(int x, int y, BattleField field, String imageName) {
        super(x, y, field, imageName);
        health = 1000;
        damage = 0;
    }

    private void ultimate() {

        newgobs.add(new Goblin(15, 0, field, "goblin" + (new
                Random().nextInt(3)) + ".png"));
        newgobs.add(new Goblin(15, 1, field, "goblin" + (new
                Random().nextInt(3)) + ".png"));
        newgobs.add(new Goblin(15, 2, field, "goblin" + (new
                Random().nextInt(3)) + ".png"));
        newgobs.add(new Goblin(15, 6, field, "goblin" + (new
                Random().nextInt(3)) + ".png"));
        newgobs.add(new Goblin(15, 7, field, "goblin" + (new
                Random().nextInt(3)) + ".png"));
        newgobs.add(new Goblin(15, 8, field, "goblin" + (new
                Random().nextInt(3)) + ".png"));
        newgobs.add(new Goblin(15, 9, field, "goblin" + (new
                Random().nextInt(3)) + ".png"));

        for (Goblin gob : newgobs) {
            this.field.executorService.execute(gob);
        }
        this.field.goblins.addAll(newgobs);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            if (!this.field.scorpion.isAlive()) {
                ultimate();
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("snake:" + e);
                Thread.currentThread().interrupt();
            }
                /*
                if(canUltimate && !this.field.scorpion.isAlive()) {
                    ultimate();
                    canUltimate = false;
                }
                try {
                    Thread.sleep(1000);
                    field.repaint();
                    synchronized (this.field) {
                        if (this.field.battlestatus == BATTLESTATUS.FIGHTING) {
                            this.field.printPositions();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("snake:" + e);
                    Thread.currentThread().interrupt();
                }
                */
        }
    }
}

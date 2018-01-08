public class Grandpa extends Creature implements Runnable {

    private boolean canUltimate = true;
    private boolean needChange = false;

    public Grandpa(int x, int y, BattleField field, String imageName) {
        super(x, y, field, imageName);
        health = 1000;
        damage = 0;
    }

    private void ultimate(Boy deadboy) {
        deadboy.setAlive(true, 50);
        this.field.positions[x][y].setImageName("newboy.png");
        needChange = true;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {

            Boy deadboy = null;
            for (Boy boy : this.field.boys) {
                if (!boy.isAlive()) {
                    deadboy = boy;
                }
            }
            if (deadboy != null) {
                ultimate(deadboy);
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println("granpa:" + e);
                    Thread.currentThread().interrupt();
                }
                this.field.positions[x][y].setImageName("grandpa.png");
                return;
            }
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("granpa:" + e);
                Thread.currentThread().interrupt();
            }


        }
    }

}

//每一个葫芦娃：具有不同属性并能够报出自己的属性


import java.util.Random;

public class Boy extends Creature implements Runnable {
    private int rank;       //排行
    //private COLOR color;      //颜色
    private String storeImageName;
    private boolean doUltimate = false;

    public Boy(int r, int x, int y, BattleField field, String imageName) {
        super(x, y, field, imageName);
        rank = r;
        switch (r) {
            case 1:
                damage = 30;
                health = 50;
                break;
            case 2:
                damage = 15;
                health = 50;
                break;
            case 3:
                damage = 2;
                health = 300;
                break;
            case 4:
                damage = 10;
                health = 50;
                break;
            case 5:
                damage = 10;
                health = 50;
                break;
            case 6:
                damage = 0;
                health = Integer.MAX_VALUE;
                break;
            case 7:
                damage = 5;
                health = 20;
                break;
            default:
                System.out.println("boy init fail!");
        }
    }

    public int getRank() {
        return rank;
    }

    protected Creature getNearest() {
        int minDis = Integer.MAX_VALUE;
        Creature nearest = null;
        if (this.field.scorpion.isAlive() && distanceTo(this.field.scorpion)
                < minDis) {

            minDis = distanceTo(this.field.scorpion);
            nearest = this.field.scorpion;
        }
        for (Goblin gob : this.field.goblins) {
            if (gob.isAlive() && distanceTo(gob) < minDis) {
                minDis = distanceTo(gob);
                nearest = gob;
            }
        }
        return nearest;
    }

    public void ultimate(Creature target) {
        doUltimate = true;
        switch (rank) {
            case 4:
                if (probability(4)) {
                    for (int i = -2; i < 3; i++) {
                        for (int j = -2; j < 3; j++) {
                            if (x + i >= 0 && x + i < WUNIT && y + j >= 0 &&
                                    y + j < HUNIT) {
                                Creature temp = this.field.positions[x +
                                        i][y + j].getHolder();
                                if (temp instanceof Goblin || temp instanceof
                                        Scorpion) {
                                    attack(temp, 8);
                                    //System.out.println("fire!!!");
                                }
                            }
                        }
                    }
                    this.field.positions[x][y].setImageName("fire.png");
                }
                break;
            case 5:
                if (probability(4)) {
                    for (Boy boy : this.field.boys) {
                        if (boy.isAlive() && boy.rank != 6) {
                            boy.getHealed(8);
                            //System.out.println("heal!!!");
                        }
                    }
                    this.field.positions[x][y].setImageName("water.png");

                }
                break;
            case 6:
                if (distanceTo(target) == 1 && probability(2)) {
                    attack(target, 1000);
                }
                break;
            default:
                break;
        }
    }

    public void ultimateDone() {
        doUltimate = false;
        switch (rank) {
            case 4:
                //this.field.positions[x + 1][y].setImageName(storeImageName);
                this.field.positions[x][y].setImageName("4.png");
                break;
            case 5:
                //this.field.positions[x + 1][y].setImageName(storeImageName);
                this.field.positions[x][y].setImageName("5.png");
                break;
            default:
                break;
        }
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            if (this.isAlive) {
                ////System.out.println("run:"+rank);
                Random random = new Random();
                Creature nearest = getNearest();
                moveToNearest(nearest);
                if (distanceTo(nearest) == 1) {
                    int newDamage = damage;
                    for (Boy boy : this.field.boys) {
                        //二娃被动
                        if (boy.getRank() == 2 && boy.isAlive()) {
                            newDamage = newDamage + 10;
                            break;
                        }
                    }
                    attack(nearest, newDamage);
                }
                ultimate(nearest);

                try {
                    field.repaint();
                    synchronized (this.field) {
                        if (this.field.battlestatus == BATTLESTATUS.FIGHTING) {
                            this.field.printPositions();
                        }
                    }
                    Thread.sleep(random.nextInt(1000) + 1000);
                    if (doUltimate) {
                        ultimateDone();
                    }

                    this.field.checkGameOver();
                } catch (Exception e) {
                    System.out.println("boy" + rank + ":" + e);
                    Thread.currentThread().interrupt();
                }

            }
        }
    }


}


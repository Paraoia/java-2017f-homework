import java.util.Random;

public class HuluShuffle implements Shuffle {
    @Override
    public void arrRandom(Creature[] creatures) {
        System.out.println("打乱顺序");
        Random random = new Random();
        for (int i = creatures.length - 1; i > 0; i--) {
            int ranIndex = random.nextInt(i + 1);
            Grid nGrid = creatures[ranIndex].getGrid();
            creatures[ranIndex].setGrid(creatures[i].getGrid());
            creatures[i].setGrid(nGrid);
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Embattle {

    public ArrayList<Position> getPositions() { return positions; }

    public ArrayList<Creature> getCreatures() { return creatures; }

    public void addCreatures(Huluwa[] brothers, Grandpa grandpa, Scorpion scorpion, ArrayList<Lackey> lackeys, Snake snake) {
        this.creatures.clear();
        this.positions.clear();
        this.arr = new String[N][N];
        this.creatures.addAll(Arrays.asList(brothers));
        this.creatures.add(grandpa);
        this.creatures.add(scorpion);
        this.creatures.addAll(lackeys);
        this.creatures.add(snake);
    }

    public void show() {
        Iterator<Creature> it = creatures.iterator();
        while (it.hasNext()) {
            Creature cre = it.next();
            Position position = cre.getPosition();
            arr[position.getX()][position.getY()] = cre.toString();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != null)
                    System.out.print(arr[i][j] + " ");
                else System.out.print("   ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public final int broLength = 7;

    private final int N = 11;

    private String arr[][];

    private ArrayList<Position> positions = new ArrayList<Position>();

    private ArrayList<Creature> creatures = new ArrayList<Creature>();

    private void shuffle(Huluwa[] brothers) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = 0; i < broLength; i++) {
            int index = rnd.nextInt(broLength);
            Huluwa tmp = brothers[i];
            brothers[i] = brothers[index];
            brothers[index] = tmp;
        }
    }

    public static void main(String[] args) {

        Huluwa[] brothers = new Huluwa[7];
        for (int i = 0; i < brothers.length; i++)
            brothers[i] = new Huluwa(SENIORITY.values()[i]);

        Embattle em = new Embattle();

        em.shuffle(brothers);

        ArrayList<Lackey> lackeys = new ArrayList<Lackey>();

        // round 1
        for (int i = 0; i < 6; i++)
            lackeys.add(new Lackey());

        em.addCreatures(brothers, new Grandpa(), new Scorpion(), lackeys, new Snake());

        new Crane().rank(em, lackeys.size());

        em.show();

        lackeys.clear();

        // round 2
        for (int i = 0; i < 11; i++)
            lackeys.add(new Lackey());

        em.addCreatures(brothers, new Grandpa(), new Scorpion(), lackeys, new Snake());

        new Arrow().rank(em, lackeys.size());

        em.show();

        lackeys.clear();
    }

}

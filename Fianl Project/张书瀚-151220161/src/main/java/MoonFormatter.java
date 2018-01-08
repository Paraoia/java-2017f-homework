import java.util.Random;

public class MoonFormatter implements Formatter {
    @Override
    public void format(BattleField field, int boyORgoblin) {
        //  0 1 2 3 4 5 6 7   8 9 a b c d e f
        //0 . . . . . . . . | . . . . . . . g
        //1 5 . . . . . . . | . . . . . . g .
        //2 . 2 . . . . . . | . . . . . g g .
        //3 . . 4 . . . . . | . . . . g g . .
        //4 G . . 3 . . . . | . . . s g . . S
        //5 . . 1 . . . . . | . . . . g g . .
        //6 . 6 . . . . . . | . . . . . g g .
        //7 7 . . . . . . . | . . . . . . g .
        //8 . . . . . . . . | . . . . . . . g
        //9 . . . . . . . . | . . . . . . . .


        if (boyORgoblin == 1) {   //boy
            field.boys.clear();
            field.boys.add(new Boy(1, 2, 5, field, "1.png"));
            field.boys.add(new Boy(2, 1, 2, field, "2.png"));
            field.boys.add(new Boy(3, 3, 4, field, "3.png"));
            field.boys.add(new Boy(4, 2, 3, field, "4.png"));
            field.boys.add(new Boy(5, 0, 1, field, "5.png"));
            field.boys.add(new Boy(6, 1, 6, field, "6.png"));
            field.boys.add(new Boy(7, 0, 7, field, "7.png"));
            field.grandpa = new Grandpa(0, 4, field, "grandpa.png");
        } else if (boyORgoblin == 2) { //goblin
            field.goblins.clear();
            field.goblins.add(new Goblin(15, 0, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(15, 8, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(14, 1, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(14, 2, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(14, 6, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(14, 7, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 2, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 3, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 5, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 6, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(12, 3, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(12, 4, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(12, 5, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.scorpion = new Scorpion(11, 4, field, "scorpion.png");
            field.snake = new Snake(15, 4, field, "snake.png");
        }
    }
}

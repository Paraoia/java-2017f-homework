import java.util.Random;

public class ScaleFormatter implements Formatter {
    @Override
    public void format(BattleField field, int boyORgoblin) {
        //  0 1 2 3 4 5 6 7   8 9 a b c d e f
        //0 . . . . . . . . | . . . . . . . .
        //1 . . . . . . . . | . . . . . . . .
        //2 . . 7 . . . . . | . . . . g . . .
        //3 . . . 4 . . . . | . . . . . g . .
        //4 G . 5 2 3 . . . | . . . g g g g S
        //5 . . 6 . . . . . | . . s g g g g .
        //6 . . . 1 . . . . | . . . . g . . .
        //7 . . . . . . . . | . . . . . g . .
        //8 . . . . . . . . | . . . . . . . .
        //9 . . . . . . . . | . . . . . . . .


        if (boyORgoblin == 1) {   //boy
            field.boys.clear();
            field.boys.add(new Boy(1, 3, 6, field, "1.png"));
            field.boys.add(new Boy(2, 3, 4, field, "2.png"));
            field.boys.add(new Boy(3, 4, 4, field, "3.png"));
            field.boys.add(new Boy(4, 3, 3, field, "4.png"));
            field.boys.add(new Boy(5, 2, 4, field, "5.png"));
            field.boys.add(new Boy(6, 2, 5, field, "6.png"));
            field.boys.add(new Boy(7, 2, 2, field, "7.png"));
            field.grandpa = new Grandpa(0, 4, field, "grandpa.png");
        } else if (boyORgoblin == 2) { //goblin
            field.goblins.clear();
            field.goblins.add(new Goblin(14, 4, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(14, 5, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 3, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 4, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 5, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 7, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(12, 2, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(12, 4, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(12, 5, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(12, 6, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(11, 4, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(11, 5, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.scorpion = new Scorpion(10, 5, field, "scorpion.png");
            field.snake = new Snake(15, 4, field, "snake.png");
        }
    }
}

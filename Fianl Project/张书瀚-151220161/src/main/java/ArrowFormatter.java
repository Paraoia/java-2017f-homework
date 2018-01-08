import java.util.Random;

public class ArrowFormatter implements Formatter {
    @Override
    public void format(BattleField field, int boyORgoblin) {
        //  0 1 2 3 4 5 6 7   8 9 a b c d e f
        //0 . . . . . . . . | . . . . . g . .
        //1 . . . . . . . . | . . . . g . . .
        //2 . . G . . . . . | . . . g . . . .
        //3 . . . 4 . . . . | . . g . . . . .
        //4 . 7 5 2 3 . . . | . s g g g g g S
        //5 . . . 1 . . . . | . . g . . . . .
        //6 . . 6 . . . . . | . . . g . . . .
        //7 . . . . . . . . | . . . . g . . .
        //8 . . . . . . . . | . . . . . g . .
        //9 . . . . . . . . | . . . . . . . .


        if (boyORgoblin == 1) {   //boy
            field.boys.clear();
            field.boys.add(new Boy(1, 3, 5, field, "1.png"));
            field.boys.add(new Boy(2, 3, 4, field, "2.png"));
            field.boys.add(new Boy(3, 4, 4, field, "3.png"));
            field.boys.add(new Boy(4, 3, 3, field, "4.png"));
            field.boys.add(new Boy(5, 2, 4, field, "5.png"));
            field.boys.add(new Boy(6, 2, 6, field, "6.png"));
            field.boys.add(new Boy(7, 1, 4, field, "7.png"));
            field.grandpa = new Grandpa(2, 2, field, "grandpa.png");
        } else if (boyORgoblin == 2) { //goblin
            field.goblins.clear();
            field.goblins.add(new Goblin(14, 4, field, "goblin" + (new
                    Random().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 0, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 4, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 8, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(12, 1, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(12, 4, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(12, 7, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(11, 2, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(11, 4, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(11, 6, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(10, 3, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(10, 4, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(10, 5, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.scorpion = new Scorpion(9, 4, field, "scorpion.png");
            field.snake = new Snake(15, 4, field, "snake.png");
        }
    }
}

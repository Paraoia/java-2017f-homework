import java.util.Random;

public class BalanceFormatter implements Formatter {
    @Override
    public void format(BattleField field, int boyORgoblin) {
        //  0 1 2 3 4 5 6 7   8 9 a b c d e f
        //0 . . . . . . . . | . . . . . g . .
        //1 . . 6 . . . . . | . . . . . . g .
        //2 . 7 . . . . . . | . . . . . g . .
        //3 . . 4 . . . . . | . . . . . . g .
        //4 . 5 . . . . . . | . . . . . g . S
        //5 . . 3 . . . . . | . . . . . . g .
        //6 . 2 . . . . . . | . . . . . g . .
        //7 . . 1 . . . . . | . . . . . . g .
        //8 . G . . . . . . | . . . . . s . .
        //9 . . . . . . . . | . . . . . . g .


        if (boyORgoblin == 1) {   //boy
            field.boys.clear();
            field.boys.add(new Boy(1, 2, 7, field, "1.png"));
            field.boys.add(new Boy(2, 1, 6, field, "2.png"));
            field.boys.add(new Boy(3, 2, 5, field, "3.png"));
            field.boys.add(new Boy(4, 2, 3, field, "4.png"));
            field.boys.add(new Boy(5, 1, 4, field, "5.png"));
            field.boys.add(new Boy(6, 2, 1, field, "6.png"));
            field.boys.add(new Boy(7, 1, 2, field, "7.png"));
            field.grandpa = new Grandpa(1, 8, field, "grandpa.png");
        } else if (boyORgoblin == 2) { //goblin
            field.goblins.clear();
            field.goblins.add(new Goblin(13, 0, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 2, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 4, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(13, 6, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(14, 1, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(14, 3, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(14, 5, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(14, 7, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.goblins.add(new Goblin(14, 9, field, "goblin" + (new Random
                    ().nextInt(3)) + ".png"));
            field.scorpion = new Scorpion(13, 8, field, "scorpion.png");
            field.snake = new Snake(15, 4, field, "snake.png");
        }
    }
}

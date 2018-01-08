import java.util.Random;

public class SnakeFormatter implements Formatter {
    @Override
    public void format(BattleField field, int boyORgoblin) {
        //  0 1 2 3 4 5 6 7   8 9 a b c d e f
        //0 . . . . . . . . | . . . . . . g .
        //1 . 6 . . . . . . | . . . . . . g .
        //2 . 2 . . . . . . | . . . . . . g .
        //3 . 4 . . . . . . | . . . . . . g .
        //4 G 3 . . . . . . | . . . . . s g S
        //5 . 1 . . . . . . | . . . . . . g .
        //6 . 5 . . . . . . | . . . . . . g .
        //7 . 7 . . . . . . | . . . . . . g .
        //8 . . . . . . . . | . . . . . . g .
        //9 . . . . . . . . | . . . . . . g .


        if (boyORgoblin == 1) {   //boy
            field.boys.clear();
            field.boys.add(new Boy(1, 1, 5, field, "1.png"));
            field.boys.add(new Boy(2, 1, 2, field, "2.png"));
            field.boys.add(new Boy(3, 1, 4, field, "3.png"));
            field.boys.add(new Boy(4, 1, 3, field, "4.png"));
            field.boys.add(new Boy(5, 1, 6, field, "5.png"));
            field.boys.add(new Boy(6, 1, 1, field, "6.png"));
            field.boys.add(new Boy(7, 1, 7, field, "7.png"));
            field.grandpa = new Grandpa(0, 4, field, "grandpa.png");
        } else if (boyORgoblin == 2) { //goblin
            field.goblins.clear();
            for (int i = 0; i < 10; i++) {
                field.goblins.add(new Goblin(14, i, field, "goblin" + (new
                        Random().nextInt(3)) + ".png"));
            }
            field.scorpion = new Scorpion(13, 4, field, "scorpion.png");
            field.snake = new Snake(15, 4, field, "snake.png");
        }
    }
}

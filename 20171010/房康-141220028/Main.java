import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Creature[] huluwa = new Creature[7];
        for(int i=0;i<7;++i){
            huluwa[i] = new Huluwa(Huluwa.Order.values()[i],Huluwa.Color.values()[i]);
        }
        Creature[] soldierTeam = new Creature[8];
        for(int i=0;i<8;++i){
            if(i==0) soldierTeam[i] = new Scorpion();
            else soldierTeam[i] = new Soldier();
        }
        Creature grandpa = new Grandpa();
        Creature snake = new Snake();

        Random random = new Random();

        Space space = new Space(10,huluwa,soldierTeam,grandpa, snake);

        space.arrangeFormation(huluwa,Formation.CHANGSHE);
        int choice = random.nextInt(Formation.choices.length);
        space.arrangeFormation(soldierTeam,Formation.choices[choice]);
        space.arrangeFormation(new Creature[]{grandpa}, Formation.SINGLE);
        space.arrangeFormation(new Creature[]{snake}, Formation.SINGLE);

        space.print();

        System.out.println("==================================");

        space.arrangeFormation(huluwa,Formation.CHANGSHE);
        choice = random.nextInt(Formation.choices.length);
        space.arrangeFormation(soldierTeam,Formation.choices[choice]);
        space.arrangeFormation(new Creature[]{grandpa}, Formation.SINGLE);
        space.arrangeFormation(new Creature[]{snake}, Formation.SINGLE);

        space.print();
    }
}

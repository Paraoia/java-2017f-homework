package HuluwaFighting;

public class SortCreature {

    //该函数用于将生物按数组中的次序排座位，默认数组中的生物是按长幼排好序的。

    public void Sort(Creature[] creature){
        for(int i=0; i<creature.length-1; i++){
            for(int j=0; j<creature.length-i-1; j++){
                Position first = creature[j].getPosition();
                Position second = creature[j+1].getPosition();
                if(!first.isbiggerThan(second)){
                    creature[j].setPosition(second);
                    creature[j+1].setPosition(first);
                }
            }
        }
    }

    //test code:
 /*   public static void main(String[] args){
        Huluwa[] brothers = new Huluwa[7];
        for(int i=0; i<brothers.length; i++) {
            brothers[i] = new Huluwa(i);
        }

        Field f = new Field();

        for(int i = 0; i<brothers.length; i++){
            brothers[i].setPosition(f.getPosition(i, 1));
        }
        f.shuffle(brothers);

        for(Creature x:brothers)
            x.report();

        SortCreature sort = new SortCreature();
        sort.Sorter(brothers);
        for(Creature x:brothers)
            x.report();
    }*/
}

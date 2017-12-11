import java.util.Random;
public class  Formation {
    private Creature[] creatures;

    public Formation(Creature[] creatures) {
        this.creatures = creatures;
        this.shuffle();
    }

    private void shuffle() {
        Random r=new Random();
        for (int i = 0; i < creatures.length; i++) {
            int index = r.nextInt(creatures.length);
            Creature temp=creatures[i];
            creatures[i]=creatures[index];
            creatures[index]=temp;
        }
    }

    private void sort(){    //bubble sort
        for(int i=0;i<creatures.length-1;i++){
            for(int j=0;j<creatures.length-1-i;j++){
                if(((Comparable)creatures[j]).biggerThan((Comparable)creatures[j+1])){
                    Creature temp=creatures[j+1];
                    creatures[j+1]=creatures[j];
                    creatures[j]=temp;
                }
            }
            }
    }

    public  Creature[] 长蛇阵(){
        this.sort();
        for(int i=0;i<creatures.length;i++){
            Position position=new Position(0,i);
            creatures[i].setPosition(position);
        }
        return creatures;
    }

    public  Creature[] 雁行阵(){
        this.sort();
        for(int i=0;i<creatures.length;i++){
            Position position=new Position(-i,i);
            creatures[i].setPosition(position);
        }
        return creatures;
    }

    public  Creature[] 鹤翼阵(){
        this.sort();
        int i;
        for(i=0;i<creatures.length/2;i++){
            Position position=new Position(i,i);
            creatures[i].setPosition(position);
        }
        for(;i<creatures.length;i++){
            Position position=new Position(i,creatures.length-i-1);
            creatures[i].setPosition(position);
        }
        return creatures;
    }

    public  Creature[] 冲轭阵(){
        this.sort();
        for(int i=0;i<creatures.length;i++){
            Position position=new Position(i%2,i);
            creatures[i].setPosition(position);
        }
        return creatures;
    }

}

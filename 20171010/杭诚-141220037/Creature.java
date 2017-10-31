public class Creature {
    String name;
    Type type;
    enum Type {HULU, SCORP, SNAKE, LOLUO, GRANDPA};
    Creature(String name, Type type){
        this.name = name;
        this.type = type;
    }
    Creature(Creature another){
        this.name = another.name;
        this.type = another.type;
    }
}

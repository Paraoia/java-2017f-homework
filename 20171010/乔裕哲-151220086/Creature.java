enum CreatureType{爷, 娃, 蝎, 蛇, 喽};

abstract class Creature {
    Position position;
    CreatureType type;

    public String report(){
        return this.type.toString();
    };

    public Position setPosition(Position position){
        Position temp = this.position;
        this.position = position;
        position.setHolder(this);
        return temp;
    }

    public void reportPos(){
        System.out.println(position.getX() + " " + position.getY());
    }

    public Position getPosition() {
        return position;
    }

    public CreatureType getType() {
        return type;
    }
}

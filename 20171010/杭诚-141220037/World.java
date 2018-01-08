public class World {
    public static void main(String[] args){
        Creature[] hulubro = createBro();
        Creature grandpa = createPa();
        Creature snake = createSnake();
        Creature scorp = createScorp();
        Creature[] loluos = createLOLUO();
        Space space = new Space();
        God god = new God();
        god.hulu_shape(hulubro, space, 7, 17);
        god.scorp_shape_goose(scorp, loluos, space, 14, 6);
        god.grandpa_snake(grandpa, snake, space, 10, 15,10,6);
        space.display();
        space.clear();
        god.hulu_shape(hulubro, space, 7, 17);
        god.scorp_shape_edge(scorp, loluos, space, 12, 6);
        god.grandpa_snake(grandpa, snake, space, 10, 15,10,6);
        space.display();
    }
    private static Creature[] createBro(){
        Creature[] bro = new Creature[7];
        bro[0] = new Creature("老大", Creature.Type.HULU);
        bro[1] = new Creature("老二", Creature.Type.HULU);
        bro[2] = new Creature("老三", Creature.Type.HULU);
        bro[3] = new Creature("老四", Creature.Type.HULU);
        bro[4] = new Creature("老五", Creature.Type.HULU);
        bro[5] = new Creature("老六", Creature.Type.HULU);
        bro[6] = new Creature("老七", Creature.Type.HULU);
        return bro;
    }
    private static Creature createPa(){
        return new Creature("爷爷", Creature.Type.GRANDPA);
    }
    private static Creature createSnake(){
        return new Creature("蛇精", Creature.Type.SNAKE);
    }
    private static Creature createScorp(){
        return new Creature("蝎子", Creature.Type.SCORP);
    }
    private static Creature[] createLOLUO(){
        Creature[] loluos = new Creature[7];
        for(int i = 0; i < 6; i++)
            loluos[i] = new Creature("喽啰", Creature.Type.LOLUO);
        return loluos;
    }
}

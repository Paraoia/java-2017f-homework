public class Snake extends Creature implements Active {

    Snake(){
        super("蛇");
    }

    @Override
    public void act(){
        System.out.println("蝎哥哥,666!");
    }
}

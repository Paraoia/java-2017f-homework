public class Grandpa extends Creature implements Active {

    Grandpa(){
        super("爷");
    }

    @Override
    public void act(){
        System.out.println("葫芦娃,666!");
    }
}

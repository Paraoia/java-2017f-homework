public class Minions extends Creature implements Active {

    Minions(String name){
        super(name);
    }

    @Override
    public void act(){
        System.out.println("别猖狂,葫芦娃!");
    }
}

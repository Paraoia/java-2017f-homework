public class Grandpa extends Creature {
    @Override
    public String toString(){
        return "爷爷";
    }


    @Override
    public void act() {
        System.out.print(toString() + ":葫芦娃，这是我最后的波纹了!  ");
    }
}

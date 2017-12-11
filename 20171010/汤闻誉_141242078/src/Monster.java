public class Monster  extends Creature implements Comparable{
    private MONSTERLEVEL monsterLevel;
    public MONSTERLEVEL mosterLevel() {
        return monsterLevel;
    }

    public MONSTERLEVEL getMonsterLevel() {
        return monsterLevel;
    }

    @Override
    public void report(){
        System.out.print(this.monsterLevel.toString());
    }

    @Override
    public boolean biggerThan(Comparable brother){
        if (brother instanceof  Monster)
            return this.getMonsterLevel().ordinal()> ((Monster) brother).getMonsterLevel().ordinal();
        else
            return false;
    }

    @Override
    public boolean lessThan(Comparable brother){
        if (brother instanceof  Monster)
            return this.getMonsterLevel().ordinal()< ((Monster) brother).getMonsterLevel().ordinal();
        else
            return false;
    }

    public Monster(MONSTERLEVEL monsterLevel) {
        this.monsterLevel = monsterLevel;
    }
}



enum MONSTERLEVEL {
    蝎子精,小喽啰
}
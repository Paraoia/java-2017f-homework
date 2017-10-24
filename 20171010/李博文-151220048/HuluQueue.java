public class HuluQueue {
    private Position[] positions;
    private HuluBaby[] huluBabies;

    public Position[] getPositions() {
        return positions;
    }

    public HuluBaby[] getHuluBabies() {
        return huluBabies;
    }
    public HuluQueue(HuluBaby[] babies){
        positions = new Position[babies.length];
        huluBabies = babies;

        for(int i = 0; i < babies.length; i++){
            positions[i] = new Position(i, 0);
            babies[i].setPosition(positions[i]);
        }

    }

    public Creature[] getCreature() {

        return getHuluBabies();
    }
}

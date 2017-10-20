public class Contianer {
    //这是一个容器，包含双方队伍，以及各自的座位

    private Creature []positiveChars;
    private Creature []negativeChars;
    private Position []positivePos;
    private Position []negativePos;

    public Contianer (Creature []positiveChars, Creature []negativeChars){

//        this.positiveChars = new Position[positiveChars.length];
        this.positiveChars = positiveChars;
        this.negativeChars = negativeChars;

        this.positivePos = new Position[positiveChars.length];
        for(int i = 0; i < positiveChars.length; ++i){
            this.positivePos[i] = new Position(i, i);
            this.positiveChars[i].setPosition(positivePos[i]);
        }

        if(negativeChars != null) {
            this.negativePos = new Position[negativeChars.length];
            for (int i = 0; i < negativeChars.length; ++i) {
                this.negativePos[i] = new Position(i, i);
                this.negativeChars[i].setPosition(negativePos[i]);
            }
        }

    }



    public Creature[] getPositiveChars() {
        return positiveChars;
    }

    public Creature[] getNegativeChars() {
        return negativeChars;
    }

}

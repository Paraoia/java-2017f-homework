package utils;

public enum HLW_SENIORITY {
    FIRST("老大", 0), SECOND("老二", 1), THIRD("老三", 2),
    FOURTH("老四", 3), FIFTH("老五", 4), SIXTH("老六", 5), SEVENTH("老七", 6);

    private String name;
    private int prior;

    HLW_SENIORITY(String name, int prior){
        this.name = name;
        this.prior = prior;
    }

    final public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return getName();
    }

    final static public boolean isGreater(HLW_SENIORITY greater, HLW_SENIORITY smaller){
        if(greater == null || smaller == null)  throw null;
        return greater.prior < smaller.prior;
    }

    final static public boolean isSmaller(HLW_SENIORITY smaller, HLW_SENIORITY greater){
        return isGreater(greater, smaller);
    }

    final static public boolean isEqual(HLW_SENIORITY cmp_1, HLW_SENIORITY cmp_2){
        return !isGreater(cmp_1, cmp_2) && !isSmaller(cmp_1, cmp_2);
    }
}

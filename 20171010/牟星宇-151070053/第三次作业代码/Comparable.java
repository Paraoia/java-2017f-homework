public interface Comparable {
    //爷爷最大，其次葫芦娃（内部按RANK排），其次妖怪（内部按M_RANK排）

    public boolean rank_biggerThan(Comparable another);

    //public boolean color_biggerThan(Comparable another);

}

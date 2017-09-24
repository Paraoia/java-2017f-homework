/*
对葫芦娃及其对应的名称进行枚举
 */
enum Name {
    ONE("老大",1),TWO("老二",2),THREE("老三",3),FOUR("老四",4),FIVE("老五",5),SIX("老六",6),SEVEN("老七",7);

    private String name;
    private int index;

    private Name(String name,int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }


}
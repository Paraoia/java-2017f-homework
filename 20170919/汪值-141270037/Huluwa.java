class Huluwa {
    private String name;
    private int ID;
    private String color;

    public Huluwa(String name, String color, int order) {
        this.name = name;
        this.color = color;
        this.ID = order;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getColor() {
        return color;
    }

    public static void swapPos(Huluwa[] huluwas, int i, int j) {
        Huluwa t = huluwas[i];
        huluwas[i] = huluwas[j];
        huluwas[j] = t;
    }

    public static void printSwapInfo(Huluwa[] huluwas, int i, int j) {
        System.out.println(huluwas[i].getName() + ": " + i + " -> " + 0);
        System.out.println(huluwas[j].getName() + ": " + j + " -> " + i);
        System.out.println(huluwas[i].getName() + ": " + 0 + " -> " + j);
    }

}

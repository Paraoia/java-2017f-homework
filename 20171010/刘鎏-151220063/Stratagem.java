public interface Stratagem {
    public void generate(int startRow, int startCol, Creature []creatures, Queue queue);
    public void cancel(int startRow, int startCol, Creature []creatures, Queue queue);
}

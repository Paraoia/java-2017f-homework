public class Yanxingzhen implements Stratagem{
    @Override
    public void cancel(int startRow, int startCol, Creature[] creatures, Queue queue) {
        for(int i = 0; i < creatures.length; ++i)
            queue.Add(startRow+i, startCol+i, new Vacancy());
    }

    @Override
    public void generate(int startRow, int startCol, Creature[] creatures, Queue queue){
        for(int i = 0; i < creatures.length; ++i)
            queue.Add(startRow+i, startCol+i, creatures[i]);
    }
}

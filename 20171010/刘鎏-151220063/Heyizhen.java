public class Heyizhen implements Stratagem {
    @Override
    public void cancel(int startRow, int startCol, Creature[] creatures, Queue queue) {
        for(int i = 0; i < creatures.length/2; ++i)
            queue.Add(startRow+i, startCol+i, new Vacancy());
        queue.Add(startRow + creatures.length/2, startCol + creatures.length/2, new Vacancy());
        for(int i = creatures.length/2 + 1; i < creatures.length; ++i)
            queue.Add(startRow+creatures.length-i-1, startCol+i, new Vacancy());
    }

    @Override
    public void generate(int startRow, int startCol, Creature[] creatures, Queue queue){
        for(int i = 0; i < creatures.length/2; ++i)
            queue.Add(startRow+i, startCol+i, creatures[i+1]);
        queue.Add(startRow + creatures.length/2, startCol + creatures.length/2, creatures[0]);
        for(int i = creatures.length/2 + 1; i < creatures.length; ++i)
            queue.Add(startRow+creatures.length-i-1, startCol+i, creatures[i]);
    }
}

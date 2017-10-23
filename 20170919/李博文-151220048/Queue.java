public class Queue {
    public Position[] positions;
    public Queue(){
        positions = new Position[8];
        for(int i = 0; i < positions.length; i++)
            positions[i] = new Position(i);
    }
    public void print_hulubabies(){
        for(int i = 1; i < positions.length; i++)
            System.out.print(positions[i].holder.name + " ");
        System.out.println("");
    }
    public void enqueue(Hulubaby[] hulubabies){
        if(hulubabies.length > positions.length){
            return;
        }
        positions[1].holder = hulubabies[0];
        positions[2].holder = hulubabies[2];
        positions[3].holder = hulubabies[6];
        positions[4].holder = hulubabies[4];
        positions[5].holder = hulubabies[3];
        positions[6].holder = hulubabies[5];
        positions[7].holder = hulubabies[1];
    }

    public static void main(String[] args) {
        Hulubaby[] hulubabies = new Hulubaby[7];
        hulubabies[0] = new Hulubaby(1, Color.RED, "老大");
        hulubabies[1] = new Hulubaby(2, Color.ORANGE, "老二");
        hulubabies[2] = new Hulubaby(3, Color.YELLOW, "老三");
        hulubabies[3] = new Hulubaby(4, Color.GREEN, "老四");
        hulubabies[4] = new Hulubaby(5, Color.CYAN, "老五");
        hulubabies[5] = new Hulubaby(6, Color.BLUE, "老六");
        hulubabies[6] = new Hulubaby(7, Color.PURPLE, "老七");
        Queue queue = new Queue();
        queue.enqueue(hulubabies);
        queue.bubble_sort();
        queue.enqueue(hulubabies);
        queue.quickSort(1, queue.positions.length-1);
        queue.print_colors();
    }

    private void print_colors() {
        for(int i = 1; i < positions.length; i++){
            System.out.print(positions[i].holder.color.name + " ");
        }
        System.out.println("");
    }

    public void bubble_sort(){
        for(int i = 1; i < positions.length; i++){
            for(int j = 1; j < positions.length-i; j++){
                if(positions[j].holder.range > positions[j+1].holder.range){
                    System.out.print(positions[j].holder.name + ": " + j + "->" + (j+1) + " ");
                    System.out.println(positions[j+1].holder.name + ": " + (j+1) + "->" + j);
                    positions[0].holder = positions[j].holder;
                    positions[j].holder = positions[j+1].holder;
                    positions[j+1].holder = positions[0].holder;
                }
            }
        }
        print_hulubabies();
    }
    public void quickSort( int i, int j){
        if(i>=j)
            return;
        Hulubaby pivot = positions[i].holder;
        int p = i, q = j;
        while(i < j){
            for(; i < j && positions[j].holder.range >= pivot.range; j--);
            if(positions[j].holder.range < pivot.range){
                System.out.println(positions[j].holder.name + ": " + j + "->" + i + " ");
                positions[i].holder = positions[j].holder;
            }
            for(; i < j && positions[i].holder.range <= pivot.range; i++);
            if(positions[i].holder.range > pivot.range) {
                System.out.println(positions[i].holder.name + ": " + i + "->" + j + " ");
                positions[j].holder = positions[i].holder;
            }
        }
        System.out.println(pivot.name + ": 0" + "->" + i + " ");
        positions[i].holder = pivot;
        quickSort(p, i-1);
        quickSort(i+1, q);
    }
}
class Position{
    public int index;
    public Hulubaby holder;
    public Position(int index) {
        this.index = index;
        this.holder = null;
    }
}
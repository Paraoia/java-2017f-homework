public class Queue {
    public Position[] positions;

    public Queue(){
        positions = new Position[8];
        for(int i = 0; i < positions.length; i++) {
            positions[i] = new Position();
            positions[i].index = i;
            positions[i].holder = null;
        }
    }

    public void enqueue(Huluwa[] huluwas) {
        if(huluwas.length > positions.length){
            return;//an exception has happened
        }
        positions[1].holder = huluwas[3];
        positions[2].holder = huluwas[4];
        positions[3].holder = huluwas[7];
        positions[4].holder = huluwas[2];
        positions[5].holder = huluwas[1];
        positions[6].holder = huluwas[6];
        positions[7].holder = huluwas[5];
    }

    public void myBubbleSort(){
        Huluwa temp;
        for (int i = positions.length - 1; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                if(positions[j].holder.getSeniority() > positions[j + 1].holder.getSeniority()) {
                    //exchange position
                    positions[j].holder.reportPosition(j, j + 1);
                    positions[j + 1].holder.reportPosition(j + 1, j);
                    temp = positions[j].holder;
                    positions[j].holder = positions[j + 1].holder;
                    positions[j + 1].holder = temp;
                }
            }
        }
    }

    public void myTwoInsertSort(){
        Huluwa temp;
        int left;
        int right;
        int middle;
        for (int i = 2; i < positions.length; i++) {
            temp = positions[i].holder;
            left = 1;
            right = i - 1;
            middle = (left + right) / 2;

            if(left == right){
                //corner case, i.e. the beginning
                if(positions[i].holder.getSeniority() > positions[middle].holder.getSeniority());
                else {
                    positions[middle].holder.reportPosition(middle,i);
                    positions[i].holder.reportPosition(i,middle);
                    positions[i].holder = positions[middle].holder;
                    positions[middle].holder = temp;
                }
            }
            else{
                //general cases
                int position;
                while(right - left != 1) {
                    //the result will always be that: right - left == 1
                    if (positions[i].holder.getSeniority() < positions[middle].holder.getSeniority()) {
                        right = middle;
                    }
                    else if (positions[i].holder.getSeniority() > positions[middle].holder.getSeniority()){
                        left = middle;
                    }
                    middle = (left + right) / 2;
                }

                //this means the insert position is included in 3 positions: left, right and right + 1
                if((positions[i].holder.getSeniority() > positions[left].holder.getSeniority()) && (positions[i].holder.getSeniority() < positions[right].holder.getSeniority())){
                    position = right;
                }
                else if(positions[i].holder.getSeniority() < positions[left].holder.getSeniority()){
                    position = left;
                }
                else{
                    position = right + 1;
                }

                if(i != position) {
                    positions[i].holder.reportPosition(i, position);

                    //after the insert position is found out, as the simple insertSort, elements start to move
                    for (int j = i; j > position; j--) {
                        positions[j - 1].holder.reportPosition(j - 1, j);
                        positions[j].holder = positions[j - 1].holder;
                    }

                    //after the elements moving, the vacant position is for the current element i
                    positions[position].holder = temp;
                }
            }
        }
    }

    public void reportNames(){
        for (int i = 1; i < positions.length; i++) {
            positions[i].holder.reportName();
        }
    }

    public void reportColors(){
        for (int i = 1; i < positions.length; i++) {
            positions[i].holder.reportColor();
        }
    }

    public static void main(String[] args) {
        Huluwa[] huluwas = new Huluwa[8];
        huluwas[0] = null;
        huluwas[1] = new Huluwa(1,"老大","红色");
        huluwas[2] = new Huluwa(2,"老二","橙色");
        huluwas[3] = new Huluwa(3,"老三","黄色");
        huluwas[4] = new Huluwa(4,"老四","绿色");
        huluwas[5] = new Huluwa(5,"老五","青色");
        huluwas[6] = new Huluwa(6,"老六","蓝色");
        huluwas[7] = new Huluwa(7,"老七","紫色");

        Queue queue = new Queue();

        queue.enqueue(huluwas);
        queue.myBubbleSort();
        queue.reportNames();

        System.out.println("-------");

        queue.enqueue(huluwas);
        queue.myTwoInsertSort();
        queue.reportColors();

        return;
    }
}

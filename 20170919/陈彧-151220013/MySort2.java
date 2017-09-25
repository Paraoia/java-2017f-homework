public class MySort2 {
    public MySort2() {
    }

    public void myBubbleSort(Huluwa[] huluwa, int size){
        int num;
        String number,color;
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(huluwa[j].getNum() > huluwa[j + 1].getNum()) {
                    //exchange position
                    huluwa[j].reportPosition(j, j + 1);
                    huluwa[j + 1].reportPosition(j + 1, j);
                    num = huluwa[j].getNum();
                    number = huluwa[j].getNumber();
                    color = huluwa[j].getColor();
                    huluwa[j].setNum(huluwa[j + 1].getNum());
                    huluwa[j].setNumber(huluwa[j + 1].getNumber());
                    huluwa[j].setColor(huluwa[j + 1].getColor());
                    huluwa[j + 1].setNum(num);
                    huluwa[j + 1].setNumber(number);
                    huluwa[j + 1].setColor(color);
                }
            }
        }
    }

    public void myTwoInsertSort(Huluwa[] huluwa, int size){
        int num;
        String number,color;
        int left;
        int right = 0;
        int middle;
        for (int i = 1; i < size; i++,right++) {
            num = huluwa[i].getNum();
            number = huluwa[i].getNumber();
            color = huluwa[i].getColor();
            left = 0;
            middle = (left + right) / 2;

            if(left == right){
                //corner case, i.e. the beginning
                if(huluwa[i].getNum() > huluwa[middle].getNum());
                else {
                    huluwa[middle].reportPosition(middle,i);
                    huluwa[i].reportPosition(i,middle);
                    huluwa[i].setNum(huluwa[middle].getNum());
                    huluwa[i].setNumber(huluwa[middle].getNumber());
                    huluwa[i].setColor(huluwa[middle].getColor());
                    huluwa[middle].setNum(num);
                    huluwa[middle].setNumber(number);
                    huluwa[middle].setColor(color);
                }
            }
            else{
                //general cases
                int position;
                while(right - left != 1) {
                    //the result will always be that: right - left == 1
                    if (huluwa[i].getNum() < huluwa[middle].getNum()) {
                        right = middle;
                    }
                    else if (huluwa[i].getNum() > huluwa[middle].getNum()){
                        left = middle;
                    }
                    middle = (left + right) / 2;
                }

                //this means the insert position is included in 3 positions: left, right and right + 1
                if((huluwa[i].getNum() > huluwa[left].getNum()) && (huluwa[i].getNum() < huluwa[right].getNum())){
                    position = right;
                }
                else if(huluwa[i].getNum() < huluwa[left].getNum()){
                    position = left;
                }
                else{
                    position = right + 1;
                }

                if(i != position) {
                    huluwa[i].reportPosition(i, position);

                    //after the insert position is found out, as the simple insertSort, elements start to move
                    for (int j = i; j > position; j--) {
                        huluwa[j - 1].reportPosition(j - 1, j);
                        huluwa[j].setNum(huluwa[j - 1].getNum());
                        huluwa[j].setNumber(huluwa[j - 1].getNumber());
                        huluwa[j].setColor(huluwa[j - 1].getColor());
                    }

                    //after the elements moving, the vacant position is for the current element i;
                    huluwa[position].setNum(num);
                    huluwa[position].setNumber(number);
                    huluwa[position].setColor(color);
                }
            }
        }
    }

    public static void main(String[] args) {
        MySort2 mySort2 = new MySort2();
        Huluwa[] huluwa = new Huluwa[7];

        huluwa[1] = new Huluwa(1,"老大","红色");
        huluwa[5] = new Huluwa(2,"老二","橙色");
        huluwa[3] = new Huluwa(3,"老三","黄色");
        huluwa[6] = new Huluwa(4,"老四","绿色");
        huluwa[0] = new Huluwa(5,"老五","青色");
        huluwa[4] = new Huluwa(6,"老六","蓝色");
        huluwa[2] = new Huluwa(7,"老七","紫色");
        mySort2.myBubbleSort(huluwa,huluwa.length);
        for (int i = 0; i < huluwa.length; i++) {
            huluwa[i].reportNumber();
        }

        huluwa[2] = new Huluwa(1,"老大","红色");
        huluwa[1] = new Huluwa(2,"老二","橙色");
        huluwa[5] = new Huluwa(3,"老三","黄色");
        huluwa[3] = new Huluwa(4,"老四","绿色");
        huluwa[6] = new Huluwa(5,"老五","青色");
        huluwa[0] = new Huluwa(6,"老六","蓝色");
        huluwa[4] = new Huluwa(7,"老七","紫色");
        mySort2.myTwoInsertSort(huluwa,huluwa.length);
        for (int i = 0; i < huluwa.length; i++) {
            huluwa[i].reportColor();
        }

    }
}


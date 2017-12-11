enum COLOR{red,orange,yellow,green,indigo,blue,violet} //赤橙黄绿青蓝紫
class huluwa{
    private int rank;
    private COLOR color;
    huluwa(int a)
    {
        rank = a;
        switch (a)
        {
            case 1: color = COLOR.red; break;
            case 2: color = COLOR.orange; break;
            case 3: color = COLOR.yellow; break;
            case 4: color = COLOR.green; break;
            case 5: color = COLOR.indigo; break;
            case 6: color = COLOR.blue; break;
            case 7: color = COLOR.violet; break;
        }
    }
    public void speak(int b, int c){
        System.out.println("老"+rank+":"+ b + "->" + c);
    }
    public void show_rank(){
        System.out.print("老"+rank+" ");
    }
    public void change(int a){
        rank = a;
        switch (rank)
        {
            case 1: color = COLOR.red; break;
            case 2: color = COLOR.orange; break;
            case 3: color = COLOR.yellow; break;
            case 4: color = COLOR.green; break;
            case 5: color = COLOR.indigo; break;
            case 6: color = COLOR.blue; break;
            case 7: color = COLOR.violet; break;
        }
    }
    public void show_color(){
        switch (color) {
            case red:
                System.out.print("红色 ");
                break;
            case orange:
                System.out.print("橙色 ");
                break;
            case yellow:
                System.out.print("黄色 ");
                break;
            case green:
                System.out.print("绿色 ");
                break;
            case indigo:
                System.out.print("青色 ");
                break;
            case blue:
                System.out.print("蓝色 ");
                break;
            case violet:
                System.out.print("紫色 ");
                break;
        }
    }
    public int get_rank(){
        return rank;
    }
    public COLOR get_color(){
        return color;
    }

}


public class huluwa_sort {
    public static huluwa []h = new huluwa [7];
    public static void init_huluwa(int[] x){
        for(int i = 0; i < 7; i++) {
            h[i]= new huluwa(x[i]);
        }
    }
    public static void bubble_sort() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7 - i - 1; j++) {
                if(h[j].get_rank()>h[j+1].get_rank()){
                    h[j].speak(j+1,j+2);
                    huluwa t = h[j];
                    h[j] = h[j+1];
                    h[j+1] = t;
                }
            }
        }
        for(int i = 0; i < 7; i++)
            h[i].show_rank();
        System.out.print("\n");
    }
    public static void binary_sort(){
        int i=1;
        while(i<7)
        {
            int head = 0, tail = i-1;
            huluwa x = h[i];
            while(head <= tail)
            {
                int mid = (head + tail)/2;
                if (x.get_color().compareTo(h[mid].get_color())>0)
                    head = mid+1;
                else
                    tail = mid -1;
            }
            int tag = 0;
            for(int j = i-1;j >= head;j--){
                x.speak(j+2,j+1);
                h[j+1]= h[j];
                tag = 1;
            }
            if(tag == 0)
                x.speak(i+1,head+1);
            h[head] = x;
            i++;
        }
        for(int k = 0; k < 7; k++){
            h[k].show_color();
        }
            System.out.print("\n");
    }
    public static void main(String[] args){
        int[] t1 = {3,1,5,4,7,6,2};
        int[] t2 = {4,2,7,5,1,6,3};
        init_huluwa(t1);
        bubble_sort();
        init_huluwa(t2);
        binary_sort();
    }
}
public class Huluwa {
    private int no;
    private String name;
    private String color;

    Huluwa(int no, String name, String color){
        this.no = no;
        this.name = name;
        this.color = color;
    }

    void get_name() {
        System.out.print(name+" ");
    }

    void get_color() {
        System.out.print(color+" ");
    }

    int get_no(){
        return no;
    }

    void set_no(int no){
        this.no = no;
    }

    void report_position(int i, int j){
        System.out.println(name +  ": " +  i + "->" + j);
    }
    
}


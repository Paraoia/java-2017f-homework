
public class StrImage extends Image {
    String img;
    static final String newline = "\n";

    StrImage(String img){
        this.img = img;
    }

    public void draw(){
        System.out.print(img);
    }
    static public void drawNewLine(){
        System.out.print(newline);
    }
}

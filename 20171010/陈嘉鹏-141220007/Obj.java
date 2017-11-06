import javafx.geometry.Pos;

public class Obj {
    Image img;

    Position pos;

    Obj(Position pos, Image img){
        this.pos = pos;
        this.img = img;
    }
    Obj(Image img){
        this.img = img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Image getImg() {
        return img;
    }

    public void setPositon(Position pos){
        this.pos = pos;
    }

    public Position getPosition(){
        return pos;
    }

    public void layout(Space sp){
        sp.Set(pos, this);
    }
    public void flush(Space sp){
        sp.flush(pos);
    }

    public void draw(){
        img.draw();
    }
}

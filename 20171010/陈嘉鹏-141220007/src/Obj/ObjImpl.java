package Obj;

import Image.Image;
import Position.Position;

public class ObjImpl implements Obj{
    Image image;
    Position position;

    public ObjImpl(Position position, Image image){
        this.position = position;
        this.image = image;
    }
    public ObjImpl(Image image){
        this.image = image;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
}

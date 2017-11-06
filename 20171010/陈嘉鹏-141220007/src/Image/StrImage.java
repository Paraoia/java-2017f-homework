package Image;

import Position.Position;

public class StrImage implements Image{
    String image;

    public StrImage(String image){
        this.image = image;
    }

    @Override
    public void draw(Position position){
        System.out.print(image);
    }

    @Override
    public void drawNewLine(){
        System.out.print("\n");
    }

    @Override
    public Integer getHeight(){
        return 1;
    }

    @Override
    public Integer getWidth(){
        return image.length();
    }
}

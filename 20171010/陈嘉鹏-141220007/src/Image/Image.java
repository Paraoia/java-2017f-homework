package Image;

import Position.Position;

public interface Image {
    public void draw(Position position);

    public void drawNewLine();

    public Integer getHeight();

    public Integer getWidth();

}

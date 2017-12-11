package formation;

import field.Coordinate;
import javafx.util.Pair;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FormationImage {
    private Integer N;
    private BufferedImage img;

    public FormationImage(String picture, Integer N) {
        this.N = N;
        try {
            img = ImageIO.read(new File(picture));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Pair<Double, Coordinate>> read() {
        List<Pair<Double, Coordinate>> available = new ArrayList<>();
        int height = img.getHeight() / N;
        int width = img.getWidth() / N;
        for (int k = 0;k < N * N;k++) {
            int startX = width * (k % N);
            int startY = height * (k / N);
            double count = 0;
            for (int i = startX;i < startX + width;i++) {
                for (int j = startY;j < startY + height;j++) {
                    int rgb = 0;
                    try {
                        rgb = img.getRGB(i, j);
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.print("out");
                    }
                    if (rgb != -1) count++;
                }
            }
            double scale = count / (height * width);
            available.add(new Pair<>(scale, new Coordinate(k / N, k % N)));
        }
        available.sort(Comparator.comparing((Pair<Double, Coordinate> pair) -> pair.getKey()).reversed());
        return available;
    }
}

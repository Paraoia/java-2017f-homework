package Xzr.Sort;

import javax.imageio.ImageIO;
import Xzr.Position.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FormationImage {
    private String ImageName;
    private int M;
    private int N;

    public FormationImage(String ImageName, int M, int N){
        this.ImageName = "src/"+ImageName+".png";
        this.M = M;
        this.N = N;
    }

    public List<Position> read(){
        BufferedImage img;
        try{
             img = ImageIO.read(new File(ImageName));
        } catch(IOException a){
            return null;
        }

        List<Position> formations = new LinkedList<Position>();

        int imgHeight = img.getHeight()/M,imgWidth = img.getWidth()/N;
        int centerX=0,centerY=0;
        int rgb = 0;
        for(int k=0; k<M*N; k++){
            centerX = imgWidth*(k%N)+imgWidth/2;
            centerY = imgHeight*(k/N)+imgHeight/2;
            try {
                rgb = img.getRGB(centerX, centerY);
            }catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("out");
            }
            if (rgb != -1){
                formations.add(new PositionXY(k/N,k%N,N));
            }
        }

        return formations;
    }
}

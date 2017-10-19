package HuluwaFighting;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;

public class DrawField {

    private int[] getRGB(BufferedImage image, CenterPixel center){
        int[] rgb = new int[3];
        int pixel = image.getRGB(center.x, center.y);
        rgb[0] = (pixel & 0xff0000) >> 16;
        rgb[1] = (pixel & 0xff00) >> 8;
        rgb[2] = (pixel & 0xff);
        return rgb;
    }

    public Boolean[][] Draw(String Filename, int height, int width){

        Boolean[][] cache = new Boolean[height][width];


        //读取image文件：
        File file = new File(Filename);
        System.out.println(file.toString());
        BufferedImage image = null;
        try{
            image = ImageIO.read(file);
        }catch(Exception e){
            e.printStackTrace();
        }

        int imageHeight = image.getHeight();
        int imageWidth = image.getWidth();
        int heightStep = imageHeight/height;
        int widthStep = imageWidth/width;

        //TO DEBUG;
        //System.out.println("高："+imageHeight+" heightStep "+heightStep);
        //System.out.println("宽："+imageWidth+" widthStep "+widthStep);

        //读取每个像素块中心点：
        CenterPixel[][] DrawBoard = new CenterPixel[height][width];
        for(int row = 0; row < height; row++){
            for(int col = 0; col<width; col++){
                DrawBoard[row][col] = new CenterPixel();
                DrawBoard[row][col].y = heightStep/2 + row*heightStep;
                DrawBoard[row][col].x = widthStep/2 + col*widthStep;
            }
        }

        //根据块中心点的色彩确定cache[i][j]是否填充, 以下为测试看色彩值：
        /*test code:
        for(int i = 0; i<height; i++){
            for(int j= 0; j<width; j++){
                int[] rgb=getRGB(image, DrawBoard[i][j]);
                System.out.printf("%d:%d:%d ", rgb[0],rgb[1],rgb[2]);
            }
            System.out.printf("\n");
        }*/
        for(int row=0;  row<height; row++){
            for(int col=0; col<width; col++){
                int[] rgb=getRGB(image, DrawBoard[row][col]);
                if(rgb[0]==255&&rgb[1]==255&&rgb[2]==255)
                    cache[row][col]=false;
                else
                    cache[row][col]=true;
            }
        }

        return cache;
    }

    //Test Code:
   /* public static void main(String[] args){
        String filename = "resource/长蛇.png";
        DrawField pen = new DrawField();
        pen.Draw(filename, 10, 20);
    }*/
}



package com.l08gr05.uno.decks_cards;

import com.l08gr05.uno.Gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class Card{

    private String type;
    private String color;
    private BufferedImage image;
    private static int cardHeight;
    private static int cardWidth;

    public Card(String type) throws IOException {
        this("dark",type);
    }
    public Card(String color, String type) throws IOException {
        this.color = color;
        this.type = type;
        String resName = "/Cards/" + type + color.charAt(0) + ".png";

        image = ImageIO.read(getClass().getResource(resName));
        image = scaleImage(image,cardWidth,cardHeight);
   }

    private BufferedImage scaleImage(BufferedImage src, int w,int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int ww = src.getWidth();
        int hh = src.getHeight();
        int[] ys = new int[h];
        for (int y = 0; y < h; y++)
            ys[y] = y * hh / h;
        for (int x = 0; x < w; x++) {
            int newX = x * ww / w;
            for (int y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }
   public BufferedImage get_image(){
        return image;
   }
    public String get_type(){
        return this.type;
    };

    public String get_color(){
        return this.color;
    };

    public Boolean isNumber(){
        return Arrays.asList("00","01","02","03","04","05","06","07","08","09").contains(type);
    }
    public static void setWidthHeight(int w,int h){
        cardWidth = w;
        cardHeight = h;
        System.out.println("Width: " + w);
        System.out.println("Height: " + h);
    }
}

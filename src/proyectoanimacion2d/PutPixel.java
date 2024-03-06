package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class PutPixel {
        
    private BufferedImage bff;
    private Color c;
    
    public PutPixel(BufferedImage bff, Color c) {
        this.bff = bff;
        this.c = c;
    }
    
    public void dibujar(int x, int y) {
        bff.setRGB(x, y, c.getRGB());
    }
}

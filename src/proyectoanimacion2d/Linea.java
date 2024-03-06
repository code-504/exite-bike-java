package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;
public class Linea {
    private BufferedImage bff;
    private Color c;

    
    public Linea(BufferedImage buffer, Color c) {
        this.bff = buffer;
        this.c = c;
    }
    
    public void putPixel(int x, int y) {
        bff.setRGB(x, y, c.getRGB());
    }
    
    public void linea(int x1, int y1, int x2, int y2) {
        
        putPixel(x1, y1);
        putPixel(x2, y2);
        
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;
        
        while (x1 != x2 || y1 != y2) {
           putPixel((int) x1, (int) y1);
            int e2 = err * 2;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }       
    }
}
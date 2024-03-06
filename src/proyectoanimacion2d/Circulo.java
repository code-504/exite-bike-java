package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Circulo {
    
    private BufferedImage bff;
    
    public Circulo(BufferedImage bff) {
        this.bff = bff;
    }
    
    public void putPixel(int x, int y, Color c) {
        bff.setRGB(x, y, c.getRGB());
    }
    
    public void dibujar(int r, int x1, int y1, Color c) {
        Inundacion in = new Inundacion(bff);
        int radio = r;
        
        for (double t = 0; t < 2 * Math.PI; t += 0.01) {
            int x = (int) (x1 + radio * Math.cos(t));
            int y = (int) (y1 + radio * Math.sin(t));
            
            putPixel(x, y, c);
        }
        
        //in.inundacion(x1 - 2, y1, c, c);
    }
}

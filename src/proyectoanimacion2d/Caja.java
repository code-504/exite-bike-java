package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Caja {
    
    private BufferedImage bff;
    
    public Caja(BufferedImage bff) {
        this.bff = bff;
    }
    
    public void dibujar(int xPos, int yPos) {
        Rectangulo r = new Rectangulo(bff);
        
        int w = xPos + 40;
        int h = yPos + 20;
        
        int sw = xPos + 40;
        int sh = yPos + 20;
        
        r.dibujar(xPos, yPos, w, h, new Color(255, 140, 1));
        r.dibujar(xPos, yPos + 10, sw, sh, new Color(219, 101, 1));
    }
}

package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;


public class Publico {
    private BufferedImage bff;
    
    public Publico(BufferedImage bff) {
        this.bff = bff;
    }
    
    private void putPixel(int x, int y, Color c) {
          bff.setRGB(x, y, c.getRGB());
    }
    
    public void dibujar(int xPos, int yPos) {
        Rectangulo r1 = new Rectangulo(bff);
        Rectangulo r2 = new Rectangulo(bff);
        
        int x2 = 2, y2 = 5;
        int cuerpoAltura = 16, cuerpoAnchura = 8;
        int cabezaAltura = 6, cabezaAnchura = 4;
        
        // Cabeza
        r1.dibujar(xPos + x2, yPos, xPos + cabezaAnchura + x2, yPos + cabezaAltura, Color.WHITE);
        
        // Cuerpo
        r2.dibujar(xPos, yPos + y2, xPos+ cuerpoAnchura, yPos + cuerpoAltura, Color.RED);
        
        // Cuerpo
        r2.dibujar(xPos + cuerpoAnchura, yPos + y2, xPos+ cuerpoAnchura + cuerpoAnchura, yPos + cuerpoAltura, Color.ORANGE);
        
    }
}

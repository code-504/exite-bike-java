package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Rectangulo {
    
    private BufferedImage bff;
    
    public Rectangulo(BufferedImage bff) {
        this.bff = bff;
    }
    
    public void dibujar(int x1, int y1, int x2, int y2, Color c) {
        Linea linea = new Linea(bff, c);
        Inundacion in = new Inundacion(bff);
       
        linea.linea(x1, y2, x2, y2);
        linea.linea(x1, y1, x2, y1);
        linea.linea(x2, y1, x2, y2);
        linea.linea(x1, y1, x1, y2);
        
        in.inundacion(x1 + 1, y1 + 1, c, c);
        
    }
}

package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class PosteLuz {
 
    private BufferedImage bff;
    
    public PosteLuz(BufferedImage bff) {
        this.bff = bff;
    }
    
    public void dibujarPoste(int x1, int y1, int tSize) {
        Poligono p = new Poligono(bff);
        Inundacion in = new Inundacion(bff);
        Circulo c = new Circulo(bff);
        
        int top = 35;
        
        int[] puntosX = {x1 - 2, x1 + 2, x1 + 2, x1 - 2};
        int[] puntosY = {y1, y1, y1 - top, y1 - top};
        
        p.dibujar(puntosX, puntosY, 4, Color.RED);
        in.inundacion(x1, y1 - 4, Color.RED, Color.RED);
        
        c.dibujar(tSize, x1, y1 - top, Color.WHITE);
        
        in.inundacion(x1, y1 - top, Color.WHITE, Color.WHITE);
    }
    
}

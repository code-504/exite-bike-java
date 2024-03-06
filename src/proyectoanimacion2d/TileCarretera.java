package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class TileCarretera {
    
    private BufferedImage bff;
    private Color c;
    
    public TileCarretera(BufferedImage bff, Color c) {
        this.bff = bff;
        this.c = c;
    }
    
    public void dibujarCuadrado(int x1, int y1) {
        Rectangulo r = new Rectangulo(bff);
        
        int carreteraSize = 48;
        
        r.dibujar(x1, y1, x1 + carreteraSize, y1 + carreteraSize, c);
        
        // Dibujar lineas
        r.dibujar(x1, y1 + carreteraSize - 2, x1 + 6, y1 + carreteraSize, new Color(122, 55, 1));
        r.dibujar(x1 + 10, y1 + carreteraSize - 2, x1 + 16, y1 + carreteraSize, new Color(122, 55, 1));
        
        r.dibujar(x1 + 24, y1 + carreteraSize - 2, x1 + 30, y1 + carreteraSize, new Color(122, 55, 1));
        r.dibujar(x1 + 34, y1 + carreteraSize - 2, x1 + 40, y1 + carreteraSize, new Color(122, 55, 1));
    }
}

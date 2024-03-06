package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Triangulo {
    private BufferedImage bff;
    private Color c;
    
    public Triangulo(BufferedImage bff, Color c) {
        this.bff = bff;
        this.c = c;
    }
    
    public void dibujar(int x1, int y1, int x2, int y2, int x3, int y3) {
        Linea linea = new Linea(bff, c);
        
        linea.linea(x1, y1, x2, y2);
        linea.linea(x2, y2, x3, y3);
        linea.linea(x3, y3, x1, y1);
    }
}
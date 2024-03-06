package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Poligono {
    private BufferedImage bff;
    
    public Poligono(BufferedImage bff) {
        this.bff = bff;
    }
    
    public void dibujar(int[] puntosX, int[] puntosY, int nPoints, Color c) {
        int x0 = (int) puntosX[puntosX.length - 1];
        int y0 = (int) puntosY[puntosY.length - 1];
        
        Linea linea = new Linea(bff, c);

        for (int i = 0; i < nPoints; i++) {
            int x1 = (int) puntosX[i];
            int y1 = (int) puntosY[i];
            linea.linea(x0, y0, x1, y1);
            x0 = x1;
            y0 = y1;
        }     
        
    }
}

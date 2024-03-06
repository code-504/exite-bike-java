package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Rampa {
    
    private BufferedImage bff;
    
    public Rampa(BufferedImage bff) {
        this.bff = bff;
    }
    
    public void dibujarRampa(int xPos, int yPos, int altura) {
        Color colorRampa1 = new Color(137, 63, 0);
        Color colorRampa2 = new Color(216, 100, 5);
        Color colorRampa3 = new Color(255, 137, 0);
        Linea l = new Linea(bff, colorRampa1);
        
        Poligono p = new Poligono(bff);
        Inundacion in = new Inundacion(bff);
        Rectangulo r = new Rectangulo(bff);
        
        // Dibujar base
        int[] puntosX = {xPos + 0, xPos + 110, xPos + 110, xPos + 0};
        int[] puntosY = {yPos + 0, yPos - 90, yPos + altura, yPos + altura + 90};
      
        p.dibujar(puntosX, puntosY, 4, colorRampa1);
        in.inundacion(xPos + 1, yPos + 1, colorRampa1, colorRampa1);
        
        // Dibujar mitad
        r.dibujar(xPos + 110, yPos - 90, xPos + 140, yPos + altura, colorRampa2);
        
        for (int i = 1; i <= 4; i ++)
            l.linea(xPos + 110, yPos - 90 + (i * 40), xPos + 140, yPos - 90 + (i * 40));
        
        // Dibujar final de la rampa
        int[] puntosX1 = {xPos + 140, xPos + 220, xPos + 220, xPos + 140};
        int[] puntosY1= {yPos - 90, yPos, yPos + altura + 90, yPos + altura};
      
        p.dibujar(puntosX1, puntosY1, 4, colorRampa3);
        in.inundacion(puntosX1[0] + 1, puntosY1[0] + 2, colorRampa3, colorRampa3);
        
        // Dibujar tapadera
        int[] puntosX2 = {xPos, xPos + 110, xPos + 140, xPos + 220};
        int[] puntosY2 = {yPos + altura + 90, yPos + altura, yPos + altura, yPos + altura + 90};
      
        p.dibujar(puntosX2, puntosY2, 4, colorRampa3);
        in.inundacion(xPos + 2, yPos + altura + 90 - 1, colorRampa3, colorRampa1);
    }
}

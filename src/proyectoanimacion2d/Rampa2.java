package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Rampa2 {
    
    private BufferedImage bff;
    
    public Rampa2(BufferedImage bff) {
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
        
        
        // Parte 1
        int anchura1    = 50;
        int altura1     = 50;
        int yPosAltura  = yPos - altura1;
        int[] puntosX  = {xPos, xPos + anchura1, xPos + anchura1, xPos};
        int[] puntosY   = {yPos + 0, yPosAltura, yPosAltura + altura + 90, yPos + altura + 90};
        
        p.dibujar(puntosX, puntosY, 4, colorRampa1);
        in.inundacion(xPos + 1, yPos + 1, colorRampa1, colorRampa1);
        
        // Parte 2
        int anchura2    = 150;
        int altura2     = 50;
        int yPosAltura2  = yPos - altura2;
        int[] puntosX2  = {puntosX[1], xPos + anchura2, xPos + anchura2, puntosX[1]};
        int[] puntosY2   = {puntosY[1], yPosAltura2, yPosAltura2 + altura + 90,yPosAltura2 + altura + 90};
        
        p.dibujar(puntosX2, puntosY2, 4, colorRampa2);
        in.inundacion(puntosX2[0] + 1, puntosY2[0] + 1, colorRampa2, colorRampa2);
        
        // Parte 3
        int anchura3    = 50;
        int altura3     = 90;
        int yPosAltura3  = puntosY2[0] - altura3;
        int[] puntosX3  = {puntosX2[1], puntosX2[1] + anchura3, puntosX2[1] + anchura3, puntosX2[1]};
        int[] puntosY3   = {puntosY2[1], yPosAltura3, yPosAltura3 + altura + 90,puntosY2[2]};
        
        p.dibujar(puntosX3, puntosY3, 4, colorRampa1);
        in.inundacion(puntosX3[0] + 1, puntosY3[0] + 1, colorRampa1, colorRampa1);
        
        // Parte 4
        int anchura4    = 315;
        int altura4     = 90;
        int yPosAltura4 = puntosY3[0] - altura4;
        int[] puntosX4  = {puntosX3[1], puntosX3[1] + anchura4, puntosX3[1] + anchura4, puntosX3[1]};
        int[] puntosY4  = {puntosY3[1], yPosAltura4, yPosAltura4 + altura + 90, puntosY3[2]};
        
        p.dibujar(puntosX4, puntosY4, 4, colorRampa2);
        in.inundacion(puntosX4[0] + 1, puntosY4[0] + 1, colorRampa2, colorRampa2);
        
        // Parte 5
        int anchura5    = 150;
        int altura5     = -altura3;
        int yPosAltura5 = puntosY4[0] - altura5;
        int[] puntosX5  = {puntosX4[1], puntosX4[1] + anchura5, puntosX4[1] + anchura5, puntosX4[1]};
        int[] puntosY5  = {puntosY4[1], puntosY[0], puntosY[3], puntosY4[2]};
        
        p.dibujar(puntosX5, puntosY5, 4, colorRampa3);
        in.inundacion(puntosX5[0] + 1, puntosY5[0] + 4, colorRampa3, colorRampa3);
        
        // Tapadera
        int[] puntosX6  = {puntosX[3], puntosX[2], puntosX2[2], puntosX3[2], puntosX4[2], puntosX5[2]};
        int[] puntosY6  = {puntosY[3], puntosY[2], puntosY2[2], puntosY3[2], puntosY4[2], puntosY5[2]};
        
        p.dibujar(puntosX6, puntosY6, 6, colorRampa3);
        in.inundacion(puntosX6[0] + 5, puntosY6[0] - 2, colorRampa3, colorRampa1);
    }
}

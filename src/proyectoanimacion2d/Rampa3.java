package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Rampa3 {
    
    private BufferedImage bff;
    
    public Rampa3(BufferedImage bff) {
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
        int anchura1    = 150;
        int altura1     = 150;
        int yPosAltura  = yPos - altura1;
        int[] puntosX  = {xPos, xPos + anchura1, xPos + anchura1, xPos};
        int[] puntosY   = {yPos + 0, yPosAltura, yPosAltura + altura + 90, yPos + altura + 90};
        
        p.dibujar(puntosX, puntosY, 4, colorRampa1);
        in.inundacion(xPos + 1, yPos + 1, colorRampa1, colorRampa1);
        
        // Parte 2
        int anchura2    = 60;
        int altura2     = 0;
        int yPosAltura2  = puntosY[1] - altura2;
        int[] puntosX2  = {puntosX[1], puntosX[1] + anchura2, puntosX[1] + anchura2, puntosX[1]};
        int[] puntosY2   = {puntosY[1] + 0, yPosAltura2, yPosAltura2 + altura + 90, puntosY[1] + altura + 90};
        
        p.dibujar(puntosX2, puntosY2, 4, colorRampa2);
        in.inundacion(puntosX2[0] + 1, puntosY2[0] + 1, colorRampa2, colorRampa2);
        
        // Parte 3
        int anchura3    = 500;
        int altura3     = 0;
        int yPosAltura3  = puntosY2[1] - altura3;
        int[] puntosX3  = {puntosX2[1], puntosX2[1] + anchura3, puntosX2[1] + anchura3, puntosX2[1]};
        int[] puntosY3   = {puntosY2[1], yPosAltura3, yPosAltura3 + altura, puntosY2[1] + altura};
        
        p.dibujar(puntosX3, puntosY3, 4, colorRampa2);
        in.inundacion(puntosX3[0] + 1, puntosY3[0] + 1, colorRampa2, colorRampa2);
        
        // Parte 4
        int anchura4    = 100;
        int altura4     = altura1;
        int yPosAltura4  = puntosY3[2] + altura4;
        int[] puntosX4  = {puntosX3[3], puntosX3[3] + anchura4, puntosX3[3] + anchura4, puntosX3[3]};
        int[] puntosY4   = {puntosY3[2], yPosAltura4, yPosAltura4 + 90,  puntosY[2]};
        
        p.dibujar(puntosX4, puntosY4, 4, colorRampa3);
        in.inundacion(puntosX4[0] + 3, puntosY4[0] + 8, colorRampa3, colorRampa3);
        
        // Tapadera
        int[] puntosX5  = {puntosX[0], puntosX[1], puntosX2[1], puntosX4[2]};
        int[] puntosY5   = {puntosY[3], puntosY[2], puntosY2[2], puntosY4[2]};
        
        p.dibujar(puntosX5, puntosY5, 4, colorRampa3);
        in.inundacion(puntosX5[0] + 3, puntosY5[0] - 2, colorRampa3, colorRampa1);
       
    }
}

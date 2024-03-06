package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class MallaConMatriz {
    int matriz[][];
    
    private BufferedImage bff;
    
    public MallaConMatriz(int matriz[][], BufferedImage bff) {
        this.matriz = matriz;
        this.bff = bff;
    }
    
    public void dibujarMalla(int x, int y) {
        Linea linea = new Linea(bff, new Color(25, 25, 25));
        
        int[][] parejas = new int[matriz[0].length * matriz[1].length][2];

        int contador = 0;
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz[1].length; j++) {
                parejas[contador][0] = matriz[0][i];
                parejas[contador][1] = matriz[1][j];
                contador++;
            }
        }
        
        for (int i = 0; i < parejas.length; i++) {
            for (int j = i + 1; j < parejas.length; j++) {
                
                int x1 = parejas[i][0] * 28;
                int y1 = parejas[i][1] * 28;
                
                int x2 = parejas[j][0] * 28;
                int y2 = parejas[j][1] * 28;
                
                if (distancia(x1, y1, x2, y2) <= 28) {
                    linea.linea(x1 + x, y1 + y, x2 + x, y2 + y);
                }
            }
        }
    }
    
    public double distancia(int x1, int y1, int x2, int y2) {
    double dx = x2 - x1;
    double dy = y2 - y1;
    return Math.sqrt(dx*dx + dy*dy);
}
}

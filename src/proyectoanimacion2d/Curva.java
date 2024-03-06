package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Curva {
    
    //private BufferedImage bff;
    Linea l;
    private boolean dibujar;
    
    public Curva(BufferedImage bff, boolean dibujar) {
        l = new Linea(bff, Color.BLACK);
       this.dibujar = dibujar;
    }
    
    public double[][] dibujarCurva(int cantidadPuntos, int x1, int y1, int amplitud, int longitud) {
        //l.linea(100,400, 100, 300);
        double suma = Math.PI/(cantidadPuntos - 1);
        
        double xInicial = 0;
        double yInicial = 0;
        
        double[][] posicion = new double[cantidadPuntos][2];
        int j = 0;
        for (double i = 0; i <= Math.PI; i+=suma) {
                       
            double ySen = Math.sin(i);
            
            double y = -(ySen * longitud) + y1;
            double x = (i * amplitud) + x1;
            
            posicion[j][0] = (int) x;
            posicion[j][1] = (int) y;
            
            j++;
            
            if (i == 0) {
                xInicial = x;
                yInicial = y;
            }
            
            if (dibujar)
                l.linea((int) xInicial, (int) yInicial, (int) x, (int) y);
            
            xInicial = x;
            yInicial = y;
            
        }
        
        /*for (int i = 0; i < posicion.length; i++) {
            System.out.println(posicion[i][0] + " " + posicion[i][1]);
        }*/
        //System.out.println("///////////////////////////");
        return posicion;
    }
}

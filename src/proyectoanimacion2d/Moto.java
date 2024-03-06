package proyectoanimacion2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Moto {
    
    private BufferedImage bff;
    private Color cPrimario, cSecundario, cNegro;
    private double[] posicion;
    Rotacion r;
    Traslacion t;
    Curva curva;
    private double[] translatedPoints;
    double tx = 4;
    double ty = 0;
    int contador = 0;
    int rotacion = 0;
    private double[][] cur;
    private int tiempo;
    private int tipo;
    private int posicinoY;
    
    public Moto(BufferedImage bff, Color cPrimario, Color cSecundario, int x1, int y1, int tipo) {
        this.bff = bff;
        this.cPrimario = cPrimario;
        this.cSecundario = cSecundario;
        this.cNegro = new Color(11, 11, 11);
        this.posicion = new double[] {x1, y1};
        this.tiempo = 0;
        this.tipo = tipo;
        this.posicinoY = y1;
        
        dibuarMoto( 60, 60);
        
        r = new Rotacion(bff);
        t = new Traslacion();
        
        curva = new Curva(bff, false);
    }
    
    public void animacion(Graphics g, ImageObserver gT) {
        tiempo++;
        
        switch (tipo) {
            case 1:
                animacion1(tiempo);
            break;
            
            case 2:
                animacion2(tiempo);
            break;
            
            case 3:
                animacion3(tiempo);
            break;
            
            case 4:
                animacion4(tiempo);
            break;
            
            case 5:
                animacion5(tiempo);
            break;
            
            case 6:
                animacion6(tiempo);
            break;
            
            case 7:
                animacion7(tiempo);
            break;
            
            default:
                animacion1(tiempo);
        }
        
        if (posicion[0] > 2000) {
            this.bff.flush();
        } else {
        
        this.bff = r.rotarFigura(rotacion, bff.getWidth() / 2, bff.getHeight() / 2);
        g.drawImage(bff, (int)posicion[0], (int)posicion[1], gT);
        }
    }
    
    public void animacion1(int T) {
        
        translatedPoints = t.trasladar(posicion, tx, ty);
        
        posicion[0] = translatedPoints[0];
        posicion[1] = translatedPoints[1];
        
        //System.out.println(rotacion);
        
        //curva.dibujarCurva(1000, 30, 10);
        
        int[] time = {50, 240, 79, 204, 240};
        
        if (T > time[0] && T < time[1]) {
            if (contador == 0)
                cur = curva.dibujarCurva(190, (int) posicion[0], (int) posicion[1], 200, 220);
            
            posicion[0] = cur[contador][0];
            posicion[1] = cur[contador][1];
                
            if (contador < cur.length - 1)
                contador++;
            else {
                posicion[0] = cur[contador][0];
                posicion[1] = cur[contador][1];
            }
        }
        
        if (T > time[0] && T < time[2]) {
            if (rotacion < 30)
            rotacion += 3;
            
        }
        
        if (T >= time[2] && T < time[3]) {
            rotacion += 3;
        }
        
        if (T >= time[4]) {
            if (rotacion > 360)
            rotacion -= 3;
        }
    }
    
    public void animacion2(int T) {
        
        double[] translatedPoints = t.trasladar(posicion, tx, ty);
        
        posicion[0] = translatedPoints[0];
        posicion[1] = translatedPoints[1];
        
        //System.out.println(rotacion);               
        
        int[] time = {50, 240};
        
        if (T > time[0] && T < time[1]) {
            
            if (rotacion < 30)
                rotacion += 3;
            
            if (contador == 0)
                cur = curva.dibujarCurva(190, (int) posicion[0], (int) posicion[1], 202, 220);
            
            posicion[0] = cur[contador][0];
            posicion[1] = cur[contador][1];
                
            if (contador < cur.length - 1)
                contador++;
            else {
                posicion[0] = cur[contador][0];
                posicion[1] = cur[contador][1];
            }
        }
        
        if (T > time[1]) {
            
            if (rotacion > 0)
                rotacion -= 3;
        }
    }
    
    public void animacion3(int T) {
        
        double[] translatedPoints = t.trasladar(posicion, tx, ty);
        
        posicion[0] = translatedPoints[0];
        posicion[1] = translatedPoints[1];
        
        //System.out.println(rotacion);               
        
        int[] time = {160, 262};
        
        if (T > time[0] && T < time[1]) {
            
            if (rotacion < 30)
                rotacion += 3;
            
            if (contador == 0)
                cur = curva.dibujarCurva(100, (int) posicion[0], (int) posicion[1], 80, 100);
            
            posicion[0] = cur[contador][0];
            posicion[1] = cur[contador][1];
                
            if (contador < cur.length - 1)
                contador++;
            else {
                posicion[0] = cur[contador][0];
                posicion[1] = cur[contador][1];
            }
        }
        
        if (T > time[1]) {
            
            if (rotacion > 0)
                rotacion -= 3;
        }
    }
    
    public void animacion4(int T) {
        
        translatedPoints = t.trasladar(posicion, tx, ty);
        
        posicion[0] = translatedPoints[0];
        posicion[1] = translatedPoints[1];
        
        //System.out.println(posicion[0]);               
        
        int[] time = {0, 66, 160, 262};
        
        if (T > time[0] && T < time[1]) {
            if (posicion[1] < 320)
                ty = 2;
            else {
                ty = 0;
            }
        }
        
        if (T > time[2] && T < time[3]) {
            
            if (rotacion < 30)
                rotacion += 3;
            
            if (contador == 0)
                cur = curva.dibujarCurva(100, (int) posicion[0], (int) posicion[1], 80, 100);
            
            posicion[0] = cur[contador][0];
            posicion[1] = cur[contador][1];
                
            if (contador < cur.length - 1)
                contador++;
            else {
                posicion[0] = cur[contador][0];
                posicion[1] = cur[contador][1];
            }
        }
        
        if (T > time[3]) {
            
            if (rotacion > 0)
                rotacion -= 3;
        }
    }
    
    public void animacion5(int T) {
        
        translatedPoints = t.trasladar(posicion, tx, ty);
        
        posicion[0] = translatedPoints[0];
        posicion[1] = translatedPoints[1];
        
        //System.out.println(posicion[0]);               
        
        int[] time = {50, 85, 180, 210, 250};
        
        if (T > time[0] && T < time[1]) {
            
            if (rotacion < 30)
                rotacion += 3;
            
            if (posicion[1] > posicinoY - 120)
                ty = -4;
            else {
                ty = 0;
            }
        }
        
        if (T > time[1] && T < time[2]) {
            
            if (rotacion > 0)
                rotacion -= 3;
           
        }
        
        if (T > time[2] && T < time[3]) {
            
            if (rotacion > -30)
                rotacion -= 3;
           
            if (posicion[1] < posicinoY)
                ty = 4;
            else {
                ty = 0;
            }
        }
        
        if (T > time[3] && T < time[4]) {
            
            if (rotacion < 0)
                rotacion += 3;
           
            ty = 0;
        }
        
    }
    
    public void animacion6(int T) {
        
        translatedPoints = t.trasladar(posicion, tx, ty);
        
        posicion[0] = translatedPoints[0];
        posicion[1] = translatedPoints[1];
        
        //System.out.println(posicion[0]);               
        
        int[] time = {50, 85, 230, 260, 300};
        
        if (T > time[0] && T < time[1]) {
            
            if (rotacion < 30)
                rotacion += 3;
            
            if (posicion[1] > posicinoY - 120)
                ty = -4;
            else {
                ty = 0;
            }
        }
        
        if (T > time[1] && T < time[2]) {
            
            if (rotacion > 0)
                rotacion -= 3;
           
        }
        
        if (T > time[2] && T < time[3]) {
            
            if (rotacion < 12)
                rotacion += 1;
           
            if (posicion[1] < posicinoY)
                ty = 4;
            else {
                ty = 0;
            }
        }
        
        if (T > time[3] && T < time[4]) {
            
            if (rotacion > 0)
                rotacion -= 3;
           
            ty = 0;
        }
        
    }
    
    public void animacion7(int T) {
        
        translatedPoints = t.trasladar(posicion, tx, ty);
        
        posicion[0] = translatedPoints[0];
        posicion[1] = translatedPoints[1];
        
        //System.out.println(posicion[0]);               
        
        int[] time = {45, 148, 150};
        
        if (T > time[0] && T < time[1]) {
            
            if (rotacion < 30)
                rotacion += 3;
            
            if (contador == 0)
                cur = curva.dibujarCurva(100, (int) posicion[0], (int) posicion[1], 105, 150);
            
            posicion[0] = cur[contador][0];
            posicion[1] = cur[contador][1];
                
            if (contador < cur.length - 1)
                contador++;
            else {
                posicion[0] = cur[contador][0];
                posicion[1] = cur[contador][1];
            }
        }
        
        if (T > time[2]) {
            
            if (rotacion > 0)
                rotacion -= 3;
        }
    }
    
    public void dibuarMoto(int xPos, int yPos) {
        dibujarCabeza(xPos, yPos);
        dibujarMoto(xPos, yPos);
        dibujarCuerpo(xPos, yPos);
    }
    
    public void putPixel(int x, int y, Color c) {
        bff.setRGB(x, y, c.getRGB());
    }
    
    private void dibujarCabeza(int xPos, int yPos) {
        
        Linea l = new Linea(bff, Color.WHITE);
        Rectangulo r = new Rectangulo(bff);
        Poligono p = new Poligono(bff);
        Inundacion in = new Inundacion(bff);
        
        Color black = new Color(11, 11, 11);
        
        // Dibujar base del casco
        int radio = 8;
        
        for (double t = 0; t < 2 * Math.PI; t += 0.01) {
            int x = (int) (xPos + radio * Math.cos(t));
            int y = (int) (yPos + radio * Math.sin(t));
            
            putPixel(x, y, cPrimario);
        }
        
        int[] picoX = {xPos + 2, xPos + 12, xPos + 8};
        int[] picoY = {yPos + 7, yPos + 7, yPos + 2};
        
        p.dibujar(picoX, picoY, 3, cPrimario);
        //l.linea(xPos + 2, yPos + 7, xPos + 12, yPos + 7);
        //l.linea(xPos + 12, yPos + 7, xPos + 6, yPos + 1);
        in.inundacion(xPos, yPos, cPrimario, cPrimario);
        in.inundacion(xPos + 7, yPos + 4, cPrimario, cPrimario);
        
        //// Dibujar decoracion del casco
        
        // Dibujar lentes
        r.dibujar(xPos - 8, yPos - 1, xPos, yPos, cSecundario);
        r.dibujar(xPos + 1, yPos - 1, xPos + 9, yPos, black);
        r.dibujar(xPos + 3, yPos, xPos + 6, yPos + 2, black);
        
        // Dibujar sombrerero
        int[] puntosX = {xPos + 3, xPos + 4, xPos + 15};
        int[] puntosY = {yPos - 2, yPos - 8, yPos -2};
        
        p.dibujar(puntosX, puntosY, 3, cSecundario);
        in.inundacion(xPos + 5, yPos - 4, cSecundario, cSecundario);
    }
    
    private void dibujarCuerpo(int xPos, int yPos) {
        Rectangulo r = new Rectangulo(bff);
        Color black = new Color(11, 11, 11);
        Linea l = new Linea(bff, black);
        Circulo c = new Circulo(bff);
        Poligono p = new Poligono(bff);
        Inundacion in = new Inundacion(bff);
        
        r.dibujar(xPos - 5, yPos + 8, xPos + 2, yPos + 24, cPrimario);
        r.dibujar(xPos - 5, yPos + 25, xPos + 2, yPos + 32, black);
        l.linea(xPos + 3, yPos + 32, xPos + 6, yPos + 32);
        c.dibujar(7, xPos - 5, yPos + 14, cPrimario);
        in.inundacion(xPos - 8, yPos + 14, cPrimario, cPrimario);
        
        int[] puntosX = {xPos - 3, xPos + 1, xPos, xPos + 10, xPos + 7, xPos - 7};
        int[] puntosY = {yPos + 7, yPos + 7, yPos + 13, yPos + 18, yPos + 20, yPos + 17};
              
        p.dibujar(puntosX, puntosY, 6, cSecundario);
        in.inundacion(xPos, yPos + 8, cSecundario, cSecundario);
    }
    
    private void dibujarMoto(int xPos, int yPos) {
        Rectangulo r = new Rectangulo(bff);
        Linea l = new Linea(bff, Color.RED);
        Circulo c = new Circulo(bff);
        Poligono p = new Poligono(bff);
        Inundacion in = new Inundacion(bff);
        
        Color black = new Color(11, 11, 11);
        Color red = new Color(230, 0, 0);
        
        // Cuadro de la moto
        int[] puntosX = {xPos - 36, xPos + 24, xPos + 12, xPos + 5, xPos - 5, xPos - 15};
        int[] puntosY = {yPos + 22, yPos + 22, yPos + 26, yPos + 38, yPos + 38,  yPos + 26};
        
        p.dibujar(puntosX, puntosY, 6, cSecundario);
        in.inundacion(xPos, yPos + 26, cSecundario, cSecundario);
        
        // Decoracion cuadro
            r.dibujar(xPos + 8, yPos + 20, xPos + 12, yPos + 24, black);
        //r.dibujar(xPos - 6, yPos + 30, xPos + 6, yPos + 34, black);
        
        // Ruedas
        c.dibujar(9, xPos - 18, yPos + 32, black);
        c.dibujar(8, xPos - 18, yPos + 32, black);
        c.dibujar(7, xPos - 18, yPos + 32, black);
        
        c.dibujar(9, xPos + 18, yPos + 32, black);
        c.dibujar(8, xPos + 18, yPos + 32, black);
        c.dibujar(7, xPos + 18, yPos + 32, black);
        
        //// Amortiguadores
        
        // Anortiguador izq
        int[] puntosX1 = {xPos - 22, xPos - 10, xPos - 8, xPos - 20};
        int[] puntosY1 = {yPos + 32, yPos + 24, yPos + 26, yPos + 34};
        
        p.dibujar(puntosX1, puntosY1, 4, cPrimario);
        in.inundacion(xPos - 12, yPos + 26, cPrimario, cPrimario);
        
        // Anortiguador der
        int[] puntosX2 = {xPos + 22, xPos + 10, xPos + 8, xPos + 20};
        int[] puntosY2 = {yPos + 32, yPos + 24, yPos + 26, yPos + 34};
        
        p.dibujar(puntosX2, puntosY2, 4, cPrimario);
        in.inundacion(xPos + 12, yPos + 26, cPrimario, cPrimario);
        
    }
}

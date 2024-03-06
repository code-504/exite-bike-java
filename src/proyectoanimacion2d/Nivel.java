package proyectoanimacion2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Nivel {
    private BufferedImage bff, bffR1, bffLuz;
    private int WIDTH = 1022;
    private int HEIGHT = 480;
    private int xT;
    
    private Escalacion e;
    private PosteLuz p;
    private boolean bandera;
    private int tSize;
    private double[][] es = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
    private double[][] value;
    
    public Nivel(BufferedImage bff, BufferedImage bffR1, BufferedImage bffLuz) {
        this.bff = bff;
        this.bffR1 = bffR1;
        this.bffLuz = bffLuz;
        p = new PosteLuz(bffLuz);
        e = new Escalacion();
    }
    
    public void dibujarNivel(int xT, Graphics g, ImageObserver gThis) {
        
        dibujarGradas();
        dibujarSuelo();
        dibujarCarril();
        
        //dibujarCajas(200);
        dibujarPostes(80);
               
        dibujarCajas(445);
        dibujarRampas();
        //dibujarRampas();
        this.xT = xT;
        
        
        if (xT < 1800) {
            g.drawImage(bff, 0, 0, gThis);
            g.drawImage(bffLuz, 0, 120, gThis);
            g.drawImage(bffR1, 0, 0, gThis);
        } else {
            this.bffLuz.flush();
            this.bff.flush();
            this.bffR1.flush();
        }
    }
    
    public void dibujarPostes(int yPos) {
        
        int sumx = 200;
        
        value = e.escalar(es, tSize, tSize);
        
        if (tSize <= 30 && bandera == false)
            tSize++;
        else if (tSize > 30) 
            bandera = true;
        
        if (tSize >= 5 && bandera == true)
            tSize--;
        else if (tSize < 15) 
            bandera = false;
        
        for (int i = 0; i < 3; i++) {
            p.dibujarPoste(sumx, yPos, (int) value[0][0]);
            sumx += 300;
        }
    }
    
    public void dibujarRampas() {
        Rampa r = new Rampa(bffR1);
        
        r.dibujarRampa(150, 240, 56);
        
        r.dibujarRampa(600, 240, 105);
    }
    
    public void dibujarGradas() {
        Rectangulo rec1 = new Rectangulo(bff);
        Linea l1 = new Linea(bff, Color.WHITE);
        Triangulo t1 = new Triangulo(bff,Color.WHITE); 
        
        rec1.dibujar(0, 0, WIDTH, 112, new Color(1, 137, 255));
        
        int alturaLineaGradas = 65;
        l1.linea(0, alturaLineaGradas, 1022, alturaLineaGradas);
        l1.linea(0, alturaLineaGradas - 1, 1022, alturaLineaGradas - 1);
        
        dibujarBanderas();
        dibujarPublico();
    }
    
    public void dibujarBanderas() {
        PutPixel p = new PutPixel(bff, Color.RED);
        Triangulo t = new Triangulo(bff,Color.WHITE); 
        Inundacion in = new Inundacion(bff);
        Linea l = new Linea(bff, Color.RED);
        
        int banderaSumX = 10;
        int banderaPosY = 70;
        int tamanoBanderaX = 20;
        int tamanoBanderaY = 8;
        int numBanderas = 10;
        
        l.linea(banderaSumX - 1, banderaPosY, banderaSumX - 10, banderaPosY - 5);
        
        for (int i = 0; i < numBanderas; i++) {
            t.dibujar(banderaSumX, banderaPosY, banderaSumX + tamanoBanderaX, banderaPosY, banderaSumX + ( tamanoBanderaX/ 2), banderaPosY + tamanoBanderaY);
            p.dibujar(banderaSumX + tamanoBanderaX + 1, banderaPosY);
            p.dibujar(banderaSumX + tamanoBanderaX + 2, banderaPosY);
            in.inundacion(banderaSumX + ( tamanoBanderaX/ 2), banderaPosY + 3, Color.WHITE, Color.WHITE);
            banderaSumX += tamanoBanderaX + 4;
        }
        
        l.linea(banderaSumX - 1, banderaPosY, banderaSumX + 10, banderaPosY - 5);
        
        banderaSumX += 50;
        
        l.linea(banderaSumX - 1, banderaPosY, banderaSumX - 10, banderaPosY - 5);
                
        for (int i = 0; i < numBanderas; i++) {
            t.dibujar(banderaSumX, banderaPosY, banderaSumX + tamanoBanderaX, banderaPosY, banderaSumX + ( tamanoBanderaX/ 2), banderaPosY + tamanoBanderaY);
            p.dibujar(banderaSumX + tamanoBanderaX + 1, banderaPosY);
            p.dibujar(banderaSumX + tamanoBanderaX + 2, banderaPosY);
            in.inundacion(banderaSumX + ( tamanoBanderaX/ 2), banderaPosY + 3, Color.WHITE, Color.WHITE);
            banderaSumX += tamanoBanderaX + 4;
        }
        
        l.linea(banderaSumX - 1, banderaPosY, banderaSumX + 10, banderaPosY - 5);
        
        banderaSumX += 50;
        
        l.linea(banderaSumX - 1, banderaPosY, banderaSumX - 10, banderaPosY - 5);
                
        for (int i = 0; i < numBanderas; i++) {
            t.dibujar(banderaSumX, banderaPosY, banderaSumX + tamanoBanderaX, banderaPosY, banderaSumX + ( tamanoBanderaX/ 2), banderaPosY + tamanoBanderaY);
            p.dibujar(banderaSumX + tamanoBanderaX + 1, banderaPosY);
            p.dibujar(banderaSumX + tamanoBanderaX + 2, banderaPosY);
            in.inundacion(banderaSumX + ( tamanoBanderaX/ 2), banderaPosY + 3, Color.WHITE, Color.WHITE);
            banderaSumX += tamanoBanderaX + 4;
        }
        
        l.linea(banderaSumX - 1, banderaPosY, banderaSumX + 10, banderaPosY - 5);
        
        banderaSumX += 50;
        
        l.linea(banderaSumX - 1, banderaPosY, banderaSumX - 10, banderaPosY - 5);
                
        for (int i = 0; i < 5; i++) {
            t.dibujar(banderaSumX, banderaPosY, banderaSumX + tamanoBanderaX, banderaPosY, banderaSumX + ( tamanoBanderaX/ 2), banderaPosY + tamanoBanderaY);
            p.dibujar(banderaSumX + tamanoBanderaX + 1, banderaPosY);
            p.dibujar(banderaSumX + tamanoBanderaX + 2, banderaPosY);
            in.inundacion(banderaSumX + ( tamanoBanderaX/ 2), banderaPosY + 3, Color.WHITE, Color.WHITE);
            banderaSumX += tamanoBanderaX + 4;
        }
        
        l.linea(banderaSumX - 1, banderaPosY, banderaSumX + 10, banderaPosY - 5);
    }
    
    public void dibujarPublico() {
        Publico p = new Publico(bff);
        
        int publicoXSum = 0;
        int publicoYSum = 0;
        
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 64; i++) {
                p.dibujar(publicoXSum, publicoYSum);
                publicoXSum += 16;
            }
            publicoXSum = 0;
            publicoYSum += 16;
        }
    }
    
    public void dibujarSuelo() {
        Rectangulo rec1 = new Rectangulo(bff);
        
        rec1.dibujar(0, 113, WIDTH, HEIGHT - 1, new Color(255, 176, 0));
       
    }
    
    public void dibujarCarril() {
        TileCarretera c = new TileCarretera(bff, new Color(216, 100, 1));
        
        int carreteraXSum = 0;
        int carreteraYSum = 0;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 21; j++) {
                c.dibujarCuadrado(carreteraXSum, carreteraYSum + 240);
                carreteraXSum += 49;
            }
            carreteraXSum = 0;
            carreteraYSum += 49;
        }       
    }
    
    public void dibujarCajas(int yPos) {
        Caja c = new Caja(bff);
        
        int cajaXSum = 0;
        
        for (int i = 0; i < 11; i++) {
             c.dibujar(cajaXSum + 40, yPos);
             cajaXSum += 90; 
        }
    }
}

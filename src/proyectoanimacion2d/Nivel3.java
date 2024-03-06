package proyectoanimacion2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Nivel3 {
    private BufferedImage bff, bffR1, bffMalla, bffLuz;
    private int WIDTH = 1022;
    private int HEIGHT = 480;
    private int xT;
    private Escalacion e;
    private PosteLuz p;
    private boolean bandera;
    private int tSize;
    private double[][] es = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
    private double[][] value;
    
    public Nivel3(BufferedImage bff, BufferedImage bffR1, BufferedImage bffMalla, BufferedImage bffLuz) {
        this.bff = bff;
        this.bffR1 = bffR1;
        this.bffMalla = bffMalla;
        this.tSize = 5;
        this.bffLuz = bffLuz;
        this.bandera = false;
        p = new PosteLuz(bffLuz);
                
        e = new Escalacion();
    }
    
    public void dibujarNivel(int xT, Graphics g, ImageObserver gThis) {
        
        dibujarGradas();
        dibujarSuelo();
        dibujarCarril();
        dibujarMalla();
        
        //dibujarCajas(200);
        //dibujarPostes(80);
         
               
        dibujarCajas(445);
        dibujarRampas();
        //dibujarRampas();
        this.xT = xT;
        
        if (xT > 3600) {
            //g.clearRect(0, 0, WIDTH, HEIGHT);
            //gbffLuz.clearRect(0, 0, WIDTH, HEIGHT);
            g.drawImage(bff, 0, 0, gThis);
            //g.drawImage(bffLuz, 0, 120, gThis);
            g.drawImage(bffR1, 0, 0, gThis);
            g.drawImage(bffMalla, 0, 0, gThis);
        } else {
            this.bff.flush();
            this.bffLuz.flush();
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
        
        for (int i = 0; i < 1; i++) {
            p.dibujarPoste(sumx, yPos, (int) value[0][0]);
            sumx += 300;
        }
    }
    
    public void dibujarMalla() {
        Rectangulo r = new Rectangulo(bffMalla);
        Inundacion in = new Inundacion(bffMalla);
        
        int[][] matriz = {
            {3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 10}
        };
        
        MallaConMatriz malla = new MallaConMatriz(matriz, bffMalla);
        
        int size = 20;
        int pos1X = 920;
        int pos1Y = 254;
        
        //r.dibujar(pos1X, pos1Y, pos1X + size, pos1Y + size, new Color(45, 45, 45));
        
        malla.dibujarMalla(822, 156);
        
        int sumX = 0;
        int sumY = 0;
        
        int numToDiv = 2;
        
        Color colorBlanco = new Color(244, 244, 244);
        Color colorNegro = new Color(25, 25, 25);
        
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                
                if (numToDiv % 2 == 0) {
                    in.inundacion(pos1X + sumX, pos1Y + sumY, new Color(25, 25, 25), colorBlanco);
                    numToDiv = 3;
                } else {
                    in.inundacion(pos1X + sumX, pos1Y + sumY, new Color(25, 25, 25), colorNegro); 
                    numToDiv = 2;
                }
                
                sumX += 25;
                
            }
            
            if (numToDiv % 2 == 0) {
                numToDiv = 3;
            } else {
                numToDiv = 2;
            }
            
            sumX = 0;
            sumY += 28;
            
        }
    }
    
    public void dibujarRampas() {
        Rampa3 r = new Rampa3(bffR1);
        
        r.dibujarRampa(150, 240, 105);
        

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
                if ((i == 0 || i == 1) && (j < 4 || j > 16)) 
                    c.dibujarCuadrado(carreteraXSum, carreteraYSum + 240);
                else {
                    if (i > 1) 
                    c.dibujarCuadrado(carreteraXSum, carreteraYSum + 240);
                }
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

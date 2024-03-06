package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class Inundacion {
    
    private BufferedImage bff;
    
    public Inundacion(BufferedImage bff) {
        this.bff = bff;
    }
    
    public void inundacion(int x, int y, Color colorBorde, Color colorRelleno) {
        Queue<Pixel> queue = new LinkedList<>();
        queue.add(new Pixel(x, y));
        while (!queue.isEmpty()) {
            Pixel p = queue.poll();
            if (bff.getRGB(p.x, p.y) != colorBorde.getRGB() && bff.getRGB(p.x, p.y) != colorRelleno.getRGB()) {
                bff.setRGB(p.x, p.y, colorRelleno.getRGB());
                queue.add(new Pixel(p.x + 1, p.y));
                queue.add(new Pixel(p.x - 1, p.y));
                queue.add(new Pixel(p.x, p.y + 1));
                queue.add(new Pixel(p.x, p.y - 1));
            }
        }
    }
    
    class Pixel {

        int x, y;

        Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

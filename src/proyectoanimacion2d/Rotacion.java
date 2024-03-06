package proyectoanimacion2d;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Rotacion {
    
    private BufferedImage bff;
    
    
    public Rotacion(BufferedImage bff) {
        this.bff = bff;
    }
    
    public BufferedImage rotarFigura(int an, double x1, double y1) {
        
        int width = bff.getWidth();
        int height = bff.getHeight();
       
        BufferedImage rotatedImage = new BufferedImage(width, height, bff.getType());
        
        double angle = Math.toRadians(an);
        
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        
        double[][] rotationMatrix = {
                {cos, -sin, x1 * (1 - cos) + y1 * sin},
                {sin, cos, y1 * (1 - cos) - x1 * sin},
                {0, 0, 1}
        };
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double[] homogenousCoordinates = { x, y, 1 };
                double[] transformedCoordinates = multiplyMatrixByVector(rotationMatrix, homogenousCoordinates);
                int tx = (int) Math.round(transformedCoordinates[0]);
                int ty = (int) Math.round(transformedCoordinates[1]);
                
                if (tx >= 0 && tx < width && ty >= 0 && ty < height) {
                    if (bff.getRGB(tx, ty) != Color.BLACK.getRGB())
                    rotatedImage.setRGB(x, y, bff.getRGB(tx, ty));
                }
            }
        }
        
        return rotatedImage;
    }
    
    private static double[] multiplyMatrixByVector(double[][] matrix, double[] vector) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        double[] result = new double[rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        
        return result;
    }
}

package proyectoanimacion2d;

public class Escalacion {
       
    public double[][] escalar(double[][] matrix, double scaleX, double scaleY) {
        double[][] scalingMatrix = {{scaleX, 0, 0}, {0, scaleY, 0}, {0, 0, 1}};

        double[][] result = new double[3][matrix[0].length];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += scalingMatrix[i][k] * matrix[k][j];
                }
            }
        }

        return result;
    }
}

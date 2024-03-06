package proyectoanimacion2d;

public class Traslacion {
    
    public double[] trasladar(double[] puntos, double dx, double dy) {
int filas = puntos.length;

        double[][] matrizTraslacion = {
      {1, 0, dx},
      {0, 1, dy},
      {0, 0, 1}
    };
    
    double[] puntosTrasladados = new double[filas];
    double[] puntoHomogeneo = {puntos[0], puntos[1], 1};

    double[] puntoHomogeneoTrasladado = multiplicar(matrizTraslacion, puntoHomogeneo);

    puntosTrasladados[0] = puntoHomogeneoTrasladado[0];
    puntosTrasladados[1] = puntoHomogeneoTrasladado[1];

    return puntosTrasladados;
}

private static double[] multiplicar(double[][] matriz, double[] vector) {
    int filas = matriz.length;
    int columnas = matriz[0].length;

    double[] resultado = new double[filas];
    for (int i = 0; i < filas; i++) {
        double suma = 0;
        for (int j = 0; j < columnas; j++) {
            suma += matriz[i][j] * vector[j];
        }
        resultado[i] = suma;
    }

    return resultado;
}
}

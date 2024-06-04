public class Problema_1 {
    // Definición de la función que vamos a integrar
    public static double funcion(double x) {
        // Ejemplo: f(x) = x^2
        return x * x;
    }

    // Implementación de la regla de Simpson 3/8
    public static double simpson38(double a, double b, int n) {
        // Verificamos que n sea múltiplo de 3
        if (n % 3 != 0) {
            System.out.println("n debe ser un múltiplo de 3.");
            return Double.NaN;
        }

        double h = (b - a) / n; // Paso de integración
        double suma = funcion(a) + funcion(b); // Suma de los extremos

        // Suma de los términos con coeficiente 3
        for (int i = 1; i < n; i++) {
            if (i % 3 != 0) {
                suma += 3 * funcion(a + i * h);
            }
        }

        // Suma de los términos con coeficiente 2
        for (int i = 3; i < n; i += 3) {
            suma += 2 * funcion(a + i * h);
        }

        return (3 * h / 8) * suma;
    }

    public static void main(String[] args) {
        // Intervalo de integración [a, b]
        double a = 0;
        double b = 1;
    
        // Número de subintervalos (debe ser múltiplo de 3)
        int n = 6;

        // Cálculo de la integral aproximada
        double resultado = simpson38(a, b, n);

        System.out.println("La integral aproximada es: " + resultado);
    }
}

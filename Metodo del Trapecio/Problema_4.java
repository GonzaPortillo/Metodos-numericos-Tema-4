public class Problema_4 {
    
    public static double funcion(double x) {
        // Ejemplo: f(x) = x^6 -2x^5 + 2x + 5
        return (x * x * x * x * x * x) -  (2 * x * x * x * x * x) + 2x + 5;
    }

    public static double trapecio(double a, double b, int n) {
        double h = (b - a) / n; // Paso de integración
        double suma = (funcion(a) + funcion(b)) / 2.0; // Suma de los extremos con coeficiente 1/2

        for (int i = 1; i < n; i++) {
            suma += funcion(a + i * h);
        }

        return h * suma;
    }

    public static void main(String[] args) {
        double a = -1;
        double b = 3;
        
        int n = 6;

        double resultado = trapecio(a, b, n);

        System.out.println("La integral aproximada es: " + resultado);
    }
}

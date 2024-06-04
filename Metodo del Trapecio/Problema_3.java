public class Problema_3 {
    
    public static double funcion(double x) {
        // Ejemplo: f(x) = x^3 - x^2 - x - 1
        return (x * x * x) -  (x * x) - x - 1;
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
        double b = 1;
        
        int n = 6;

        double resultado = trapecio(a, b, n);

        System.out.println("La integral aproximada es: " + resultado);
    }
}

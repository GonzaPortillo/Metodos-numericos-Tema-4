public class Problema_1 {

    public static double funcion(double x) {
        // Ejemplo: f(x) = x^2
        return x * x;
    }

    public static double simpson13(double a, double b, int n) {
        if (n % 2 != 0) {
            System.out.println("n debe ser un número par.");
            return Double.NaN;
        }

        double h = (b - a) / n; // Paso de integración
        double suma = funcion(a) + funcion(b); // Suma de los extremos

        for (int i = 1; i < n; i += 2) {
            suma += 4 * funcion(a + i * h);
        }

        for (int i = 2; i < n - 1; i += 2) {
            suma += 2 * funcion(a + i * h);
        }

        return (h / 3) * suma;
    }

    public static void main(String[] args) {
        double a = 0;
        double b = 1;
    
        int n = 6;

        double resultado = simpson13(a, b, n);

        System.out.println("La integral aproximada es: " + resultado);
    }
}

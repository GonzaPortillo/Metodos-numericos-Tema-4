# Diferenciación e Integración Numérica

## INDICE
1. [Introducción](
2. [Algoritmos](
3. [Implementación en Java](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/blob/main/README.md#implementacion-en-java)
4. [Problemas](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/blob/main/README.md#problemas)
5. [Resultados de compilación](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/blob/main/README.md#resultados-de-compilación)
6. [Conclusion](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/blob/main/README.md#conclusion)

## Introduccion

Los métodos de diferenciación e integración numérica son técnicas utilizadas en matemáticas y ciencias computacionales para aproximar las derivadas e integrales de funciones cuando no se pueden obtener soluciones analíticas exactas.

Algunos de estos metodos son:

1. Simpson 1/3: Es una técnica de integración numérica utilizada para aproximar el valor de una integral definida. Este método utiliza una interpolación cuadrática para conectar tres puntos equidistantes en el intervalo de integración y calcula el área bajo la curva utilizando la fórmula de Simpson.
2. Simspson 3/8: Es una técnica de integración numérica utilizada para aproximar el valor de una integral definida. Este método utiliza una interpolación cúbica para conectar cuatro puntos equidistantes en el intervalo de integración y calcula el área bajo la curva utilizando la fórmula de Simpson 3/8.
3. Metodo del trapecio: Es una técnica de integración numérica utilizada para aproximar el valor de una integral definida. La idea detrás del método del trapecio es aproximar el área bajo una curva mediante un conjunto de trapecios cuyas bases son segmentos de la curva y cuyas alturas son la distancia entre los puntos de la partición. En esencia, se aproxima el área bajo la curva como la suma de las áreas de los trapecios.

### Algoritmos

### Regla de Simpson 1/3
#### Formula
![10-2](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/assets/160778946/5e067e4f-377a-44be-bd06-efbd3230eb5d)

1. f(x) que se desea integrar.
2. Especificar el intervalo de integración,[a,b].
3. Dividir el intervalo [a,b] en n subintervalos de igual tamaño, donde n es un número par.
4. Calcular el ancho de cada subintervalo, h=(b−a)/2.
5. Calcular los valores de la función f(x) en los extremos de los subintervalos: f(a),f(a+h),f(a+2h),…,f(b).
6. Calcular los valores de la función f(x) en los puntos medios de los subintervalos: f(a+((h)/2)), f(a+((3h)/2)), ... , f(b+((h)/2)).
7. Aplicar la fórmula de Simpson para calcular la aproximación de la integral.
8. Devolver el valor calculado como la aproximación de la integral.

### Regla de Simpson 3/8
#### Formula
![slide_1](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/assets/160778946/bb266e88-b289-478b-881d-83153d8cfdeb)

1 Definir la función f(x). 
2. Lea el límite inferior de integración, el límite superior de integración y número de subintervalo. 
3. Cálculos: tamaño del paso = (límite superior - límite inferior)/número de subintervalo. 
4. Establecer: valor de integración = f(límite inferior) + f(límite superior). 
5. Establecer: i = 1. 
6. Si i > número de subintervalo, entonces vaya a. 
7. Calcular: k = límite inferior + i * h. 
8. Si mod 3 = 0 entonces Valor de integración = Valor de integración + 2* f(k) De lo contrario Valor de integración = Valor de integración + 3 * f(k) Terminara si. 
9. Incremente i en 1, es decir, i = i+1 y vaya al paso 7. 
10. Calcule: Valor de integración = Valor de integración * tamaño de paso*3/8. 
11. Mostrar el valor de integración como respuesta requerida. 
12. Detener.

### Metodo de Trapecio
#### Formula
![image](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/assets/160778946/380619a6-27a9-4793-9ea5-a6b7bb2158af)
1. Definir el intervalo de integración [a, b] y el número de subintervalos n en los que se dividirá el intervalo.
2. Calcular el ancho de cada subintervalo: h = (b - a) / n
3. Evaluar la función en los puntos extremos del intervalo (a y b) y en los puntos intermedios (xi = a + i*h, donde i = 1, 2, ..., n-1).
4. Calcular la aproximación de la integral definida utilizando la fórmula del trapecio: Integral aproximada = (h/2) * (f(a) + 2*[f(x1) + f(x2) + ... + f(xn-1)] + f(b)) Donde f(a), f(b) y f(xi) son los valores de la función evaluada en los puntos correspondientes.
5. Cuantos más subintervalos se tomen (es decir, mayor sea n), más precisa será la aproximación de la integral.

## Implementacion en Java
### Funcion que se resuelve en la implementación
![image](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/assets/160778946/b4c4567f-8932-4aad-8ebf-81a4ef4619f1)

### Regla de Simpson 1/3

    public class SimpsonRule {
        // Definición de la función que vamos a integrar
        public static double funcion(double x) {
            // Ejemplo: f(x) = x^2
            return x * x;
        }

        // Implementación de la regla de Simpson 1/3
        public static double simpson13(double a, double b, int n) {
            // Verificamos que n sea par
            if (n % 2 != 0) {
                System.out.println("n debe ser un número par.");
                return Double.NaN;
            }

            double h = (b - a) / n; // Paso de integración
            double suma = funcion(a) + funcion(b); // Suma de los extremos

            // Suma de los términos con coeficiente 4
            for (int i = 1; i < n; i += 2) {
                suma += 4 * funcion(a + i * h);
            }

            // Suma de los términos con coeficiente 2
            for (int i = 2; i < n - 1; i += 2) {
                suma += 2 * funcion(a + i * h);
            }

            return (h / 3) * suma;
        }

        public static void main(String[] args) {
            // Intervalo de integración [a, b]
            double a = 0;
            double b = 1;
        
            // Número de subintervalos (debe ser par)
            int n = 6;

            // Cálculo de la integral aproximada
            double resultado = simpson13(a, b, n);

            System.out.println("La integral aproximada es: " + resultado);
        }
    }

### Regla de Simpson 3/8

    public class Simpson38Rule {
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


### Metodo de Trapecio 

    public class TrapecioRule {
        // Definición de la función que vamos a integrar
        public static double funcion(double x) {
            // Ejemplo: f(x) = x^2
            return x * x;
        }

        // Implementación del método del trapecio
        public static double trapecio(double a, double b, int n) {
            double h = (b - a) / n; // Paso de integración
            double suma = (funcion(a) + funcion(b)) / 2.0; // Suma de los extremos con coeficiente 1/2

            // Suma de los términos intermedios
            for (int i = 1; i < n; i++) {
                suma += funcion(a + i * h);
            }

            return h * suma;
        }

        public static void main(String[] args) {
            // Intervalo de integración [a, b]
            double a = 0;
            double b = 1;
        
            // Número de subintervalos
            int n = 6;

            // Cálculo de la integral aproximada
            double resultado = trapecio(a, b, n);

            System.out.println("La integral aproximada es: " + resultado);
        }
    }

## Problemas
Las siguientes funciones se realizaron con los 3 algortimos presentados
![image](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/assets/160778946/b009ace8-bf44-4c38-addc-5b08e6361d13)

Las 5 funciones se encontraran aqui implementadas con los codigos anteriormente presentados

* [Simpson 1/3](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/tree/main/Simpson%201.3)
* [Simpson 3/8](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/tree/main/Simpson%203.8)
* [Trapecio](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/tree/main/Metodo%20del%20Trapecio)

## Resultados de compilación
### Funcion resuelta
![image](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/assets/160778946/b4c4567f-8932-4aad-8ebf-81a4ef4619f1)

### Regla de Simpson 1/3

![image](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/assets/160778946/c3b31a13-4cfb-468e-b72c-762913c639b4)

### Regla de Simpson 3/8

![image](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/assets/160778946/1918fd64-64d6-41ad-973e-615b10d7cba1)

### Metodo de Trapecio 

![image](https://github.com/GonzaPortillo/Metodos-numericos-Tema-4/assets/160778946/8ba1a42e-da08-48b0-9a77-4d841884ccb2)

## Conclusion
La diferenciación e integración numérica son herramientas fundamentales en el ámbito de los métodos numéricos, esenciales para resolver problemas en los que las soluciones analíticas son difíciles o imposibles de obtener. Ambas técnicas permiten aproximar derivadas e integrales de funciones a partir de datos discretos o funciones complicadas, ofreciendo soluciones prácticas en diversas áreas de la ciencia y la ingeniería.

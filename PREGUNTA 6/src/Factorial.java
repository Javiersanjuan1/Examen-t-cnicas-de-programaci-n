public class Factorial {
    public static long factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }
    public static long factorialDin(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser mayor o igual a 0.");
        }

        long[] tabla = new long[n + 1];

        tabla[0] = 1; // Caso base: 0! = 1

        for (int i = 1; i <= n; i++) {
            tabla[i] = i * tabla[i - 1];
        }

        return tabla[n];
    }
    public static void main(String[] args) {
        int numero = 5;

        System.out.println("Factorial recursivo de " + numero + ": " + factorial(numero));
        System.out.println("Factorial dinámico de " + numero + ": " + factorialDin(numero));
    }
}

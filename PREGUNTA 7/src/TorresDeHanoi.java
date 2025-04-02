public class TorresDeHanoi {

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Resolviendo las Torres de Hanoi con " + n + " discos:");
        hanoi(n, "P1", "P3", "P2");
    }

    public static void hanoi(int n, String origen, String destino, String auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
        } else {
            hanoi(n - 1, origen, auxiliar, destino);
            System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
            hanoi(n - 1, auxiliar, destino, origen);
        }
    }
}

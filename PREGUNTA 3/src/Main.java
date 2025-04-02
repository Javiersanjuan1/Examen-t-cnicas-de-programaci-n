import java.util.*;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();

        // Crea un ciclo: 1 - 2 - 3 - 4 - 1
        g.agregarArista(1, 2);
        g.agregarArista(2, 3);
        g.agregarArista(3, 4);
        g.agregarArista(4, 1);

        List<Integer> ciclo = g.encontrarCiclo(6); // Profundidad máxima permitida

        if (ciclo != null) {
            System.out.println("Ciclo encontrado: " + ciclo);
        } else {
            System.out.println("No se encontró ningún ciclo.");
        }
    }
}

class Grafo {
    private Map<Integer, List<Integer>> adyacencias = new HashMap<>();

    public void agregarArista(int origen, int destino) {
        adyacencias.putIfAbsent(origen, new ArrayList<>());
        adyacencias.putIfAbsent(destino, new ArrayList<>());
        adyacencias.get(origen).add(destino);
        adyacencias.get(destino).add(origen);
    }

    public List<Integer> encontrarCiclo(int maxProfundidad) {
        for (int inicio : adyacencias.keySet()) {
            Set<Integer> visitados = new HashSet<>();
            List<Integer> camino = new ArrayList<>();
            if (dfs(inicio, inicio, visitados, camino, maxProfundidad)) {
                return camino;
            }
        }
        return null;
    }

    private boolean dfs(int actual, int objetivo, Set<Integer> visitados, List<Integer> camino, int maxProf) {
        visitados.add(actual);
        camino.add(actual);

        if (camino.size() > maxProf) {
            camino.remove(camino.size() - 1);
            visitados.remove(actual);
            return false;
        }

        for (int vecino : adyacencias.getOrDefault(actual, new ArrayList<>())) {
            if (vecino == objetivo && camino.size() >= 3) {
                camino.add(vecino);
                return true;
            }

            if (!visitados.contains(vecino)) {
                if (dfs(vecino, objetivo, visitados, camino, maxProf)) {
                    return true;
                }
            }
        }

        camino.remove(camino.size() - 1);
        visitados.remove(actual);
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        TablaHashEmpleados tabla = new TablaHashEmpleados(50);

        CodigoEmpleado emp1 = new CodigoEmpleado("A", 23);
        CodigoEmpleado emp2 = new CodigoEmpleado("C", 134);
        CodigoEmpleado emp3 = new CodigoEmpleado("E", 1);

        tabla.insertar(emp1, "Empleado 1");
        tabla.insertar(emp2, "Empleado 2");
        tabla.insertar(emp3, "Empleado 3");

        System.out.println(tabla.obtener(emp1)); // Empleado 1
        System.out.println(tabla.obtener(emp2)); // Empleado 2
        System.out.println(tabla.obtener(emp3)); // Empleado 3
    }
}

class CodigoEmpleado {
    private String codPais;
    private int codEmpleado;

    public CodigoEmpleado(String codPais, int codEmpleado) {
        this.codPais = codPais;
        this.codEmpleado = codEmpleado;
    }

    public String getCodPais() {
        return codPais;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }
}

class TablaHashEmpleados {
    private Object[] tbl;

    public TablaHashEmpleados(int tam) {
        tbl = new Object[tam];
    }

    protected int fHash(CodigoEmpleado codigo) {
        int hashCodPais = codigo.getCodPais().charAt(0) - 'A'; // A→0, B→1, etc.
        int hashCodEmpleado = codigo.getCodEmpleado();
        int hash = hashCodPais * 1000 + hashCodEmpleado;
        return Math.abs(hash) % tbl.length;
    }

    public void insertar(CodigoEmpleado codigo, Object valor) {
        int indice = fHash(codigo);
        tbl[indice] = valor;
    }

    public Object obtener(CodigoEmpleado codigo) {
        int indice = fHash(codigo);
        return tbl[indice];
    }
}

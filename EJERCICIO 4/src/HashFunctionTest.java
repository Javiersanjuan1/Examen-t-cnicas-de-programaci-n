import org.junit.Test;
import static org.junit.Assert.*;

/*
Clase que simula CódigoEmpleado del apartado 1.
*/
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

/*
Clase que simula la tabla hash y la función fHash del apartado 1.
*/
class TablaHashEmpleados {
    private int tam;

    public TablaHashEmpleados(int tam) {
        this.tam = tam;
    }

    protected int fHash(CodigoEmpleado codigo) {
        int hashCodPais = codigo.getCodPais().charAt(0) - 'A';
        int hashCodEmpleado = codigo.getCodEmpleado();
        int hash = hashCodPais * 1000 + hashCodEmpleado;
        return Math.abs(hash) % tam;
    }
}

public class HashFunctionTest {

    /*
    Descripción de la prueba
    Objetivo: Comprobar que el índice devuelto para un código válido (A, 23) está dentro del rango.
    Preámbulo: Creamos un empleado con país A (España) y número 23, y una tabla de tamaño 50.
    Cuerpo: Se aplica fHash al empleado.
    Postámbulo: Verificamos que el índice esté entre 0 y 49.
    Resultado esperado: Valor válido dentro de la tabla hash.
    */
    @Test
    public void testHashEspanaCodigo23() {
        TablaHashEmpleados tabla = new TablaHashEmpleados(50);
        CodigoEmpleado emp = new CodigoEmpleado("A", 23);
        int hash = tabla.fHash(emp);
        assertTrue(hash >= 0 && hash < 50);
    }

    /*
    Descripción de la prueba
    Objetivo: Verificar que fHash funciona correctamente con otro país, por ejemplo Alemania ("C").
    Preámbulo: Creamos un empleado con país "C" y número 134.
    Cuerpo: Aplicamos fHash y verificamos que el valor sea válido.
    Postámbulo: Confirmamos que el índice esté dentro de los límites de la tabla.
    Resultado esperado: Índice válido (entre 0 y 49).
    */
    @Test
    public void testHashAlemaniaCodigo134() {
        TablaHashEmpleados tabla = new TablaHashEmpleados(50);
        CodigoEmpleado emp = new CodigoEmpleado("C", 134);
        int hash = tabla.fHash(emp);
        assertTrue(hash >= 0 && hash < 50);
    }

    /*
    Descripción de la prueba
    Objetivo: Comprobar que empleados distintos pueden tener el mismo índice si hay colisiones.
    Preámbulo: Creamos dos empleados con datos distintos que se espera colisionen en una tabla pequeña.
    Cuerpo: Se comparan los índices devueltos por fHash.
    Postámbulo: Verificamos si los índices son iguales (colisión válida).
    Resultado esperado: Ambos empleados devuelven el mismo índice.
    */
    @Test
    public void testColisionEsperada() {
        TablaHashEmpleados tabla = new TablaHashEmpleados(10); // tabla pequeña para forzar colisión
        CodigoEmpleado emp1 = new CodigoEmpleado("A", 23);
        CodigoEmpleado emp2 = new CodigoEmpleado("E", 1023); // 4 * 1000 + 23
        int hash1 = tabla.fHash(emp1);
        int hash2 = tabla.fHash(emp2);
        assertEquals(hash1, hash2);
    }

    /*
    Descripción de la prueba
    Objetivo: Asegurar que el hash nunca da un índice negativo.
    Preámbulo: Creamos un empleado con país "D" y número alto.
    Cuerpo: Ejecutamos fHash y verificamos el resultado.
    Postámbulo: Validamos que el índice es positivo.
    Resultado esperado: Índice ≥ 0.
    */
    @Test
    public void testHashNuncaNegativo() {
        TablaHashEmpleados tabla = new TablaHashEmpleados(50);
        CodigoEmpleado emp = new CodigoEmpleado("D", 999);
        int hash = tabla.fHash(emp);
        assertTrue(hash >= 0);
    }
}

/*
1. @SuppressWarnings("deprecation")

→ Parte del ciclo de vida: COMPILACIÓN
→ Significado: Indica al compilador que ignore ciertas advertencias (en este caso, el uso de métodos o clases obsoletas).
→ Justificación: Se usa para mantener código compatible con APIs antiguas sin generar warnings innecesarios.
2. @Deprecated

→ Parte del ciclo de vida: COMPILACIÓN (y también ayuda durante el desarrollo)
→ Significado: Marca un método o clase como obsoleto. Se recomienda NO usarlo porque puede eliminarse en versiones futuras.
→ Justificación: Sirve como aviso para desarrolladores para evitar el uso de funciones antiguas.
3. @Override

→ Parte del ciclo de vida: COMPILACIÓN
→ Significado: Indica que un método está sobrescribiendo correctamente un método heredado.
→ Justificación: El compilador verifica que realmente exista un método en la superclase. Previene errores por nombres mal escritos.
4. @Test

→ Parte del ciclo de vida: EJECUCIÓN (en tiempo de prueba con frameworks como JUnit)
→ Significado: Marca un método como prueba unitaria para ser ejecutado automáticamente.
→ Justificación: Es usada por JUnit para identificar qué métodos deben ejecutarse como pruebas al correr los test.
*/

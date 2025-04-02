/*
Memoria Stack:
- Almacena las referencias de variables locales.
- La variable `p` en main y el parámetro del método `imprimePersona` se almacenan en el stack.
- Estas referencias se crean al entrar en cada método y se eliminan al salir del mismo.

Memoria Heap:
- Almacena el objeto real creado con `new Persona()`.
- Se inserta en el heap al ejecutarse la línea `Persona p = new Persona();`.
- Se libera automáticamente por el garbage collector cuando no quedan referencias a él.

Área de métodos (method area):
- Almacena el código de la clase Persona y los métodos main e imprimePersona.
- Se carga al iniciar la ejecución y permanece en memoria durante la vida del programa.
*/

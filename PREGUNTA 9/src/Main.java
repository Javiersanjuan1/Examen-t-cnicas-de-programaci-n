/*

1. Garbage Collector (GC)
→ Ventajas:
+ Sencillez para el programador (no necesita preocuparse por liberar).
+ Puede manejar ciclos de referencias.
+ Menor riesgo de fugas de memoria por errores del programador.

→ Inconvenientes:
– El recolector se ejecuta de forma impredecible (pausas en tiempo de ejecución).
– Puede afectar al rendimiento (stop-the-world).
– Mayor consumo de recursos en programas con muchas asignaciones rápidas.

2. Automatic Reference Counting (ARC)
→ Ventajas:
+ La liberación de memoria es inmediata y predecible.
+ Sin pausas largas como las del GC.
+ Menor consumo en algunos entornos (ej. móviles).

→ Inconvenientes:
– No puede gestionar **ciclos de referencias** automáticamente (por ejemplo, dos objetos que se referencian entre sí nunca llegan a 0).
– El programador debe usar referencias débiles (`weak`) para romper ciclos.
– Puede ser más propenso a errores sutiles en estructuras complejas.

3. Conclusión
---------------------------------------------------
- El GC es más adecuado para aplicaciones grandes y complejas, donde la comodidad y seguridad son prioritarias.
- ARC es preferido en entornos donde el rendimiento y la respuesta inmediata son críticos (como aplicaciones móviles en iOS).
*/

/*
Descripción del algoritmo ávido para seleccionar personas a llevar en el coche maximizando el cariño total.

Objetivo:
Seleccionar a las personas con mayor nivel de cariño para ocupar las P plazas disponibles en el coche,
maximizando el cariño total acumulado.

Fases del algoritmo:

1. Representación de datos:
   Se representa a cada persona con su nivel de cariño como un par
2. Ordenación (criterio ávido):
   Se ordena la lista de personas de mayor a menor según su nivel de cariño.
3. Selección:
   Se recorren las personas desde el principio de la lista ordenada y se van seleccionando una a una,
   hasta llenar las P plazas del coche.
4. Resultado:
   La salida será un subconjunto de P personas con los niveles de cariño más altos,
   maximizando así el cariño total.

Este algoritmo ávido es apropiado porque el problema se puede resolver eligiendo
 la mejor opción en cada paso, sin necesidad de evaluar
todas las combinaciones posibles.
*/

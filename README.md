# AyEDD-TP3

## Explicación del Resultado

### Árbol creado (in-order traversal):
Al insertar los nodos (45, 10, 7, 12, 90, 50), el recorrido in-order muestra los nodos en el siguiente orden:
`7 10 12 45 50 90`. Esto confirma que el árbol binario de búsqueda se ha construido correctamente, ya que los nodos se presentan en orden ascendente, como es esperado en este tipo de estructura.

### Eliminación del nodo hoja (12):
Después de borrar el nodo hoja `12`, el árbol queda en el siguiente estado:
`7 10 45 50 90`. Este resultado es correcto porque el nodo `12` no tenía hijos, y por lo tanto se eliminó sin necesidad de hacer más ajustes en el árbol.

### Eliminación del nodo con un solo hijo (90):
Al eliminar el nodo `90`, que tiene un solo hijo (`50`), el árbol se reorganiza correctamente y queda:
`7 10 45 50`. El árbol mantiene el orden, ya que el único hijo de `90` reemplaza su posición.

### Eliminación del nodo con dos hijos (45):
Cuando se elimina el nodo `45`, que tiene dos hijos, el árbol reemplaza a `45` por su sucesor in-order, que es `50`. El árbol resultante es:
`7 10 50`. Este es el comportamiento esperado cuando se borra un nodo con dos hijos en un árbol binario de búsqueda.

### Búsquedas en el árbol:
- **Clave `50`**: Al buscar la clave `50`, el árbol devuelve `true` ya que el nodo está presente en el árbol.
- **Clave `12`**: La clave `12` fue eliminada anteriormente, por lo que la búsqueda devuelve `false`, lo cual es correcto.

## Consigna cumplida:

### `int ValorMinimo(Nodo raiz)`:
Este método recorre el subárbol izquierdo para encontrar el nodo con el valor más pequeño. Esto es esencial para la eliminación de nodos con dos hijos, ya que permite encontrar el sucesor in-order correctamente.

### `Nodo insertar_Recursivo(Nodo raiz, int clave)`:
Este método inserta recursivamente un nodo en el árbol de búsqueda binario, respetando las reglas de comparación: si la clave es menor, el nodo se inserta a la izquierda; si es mayor, se inserta a la derecha.

Ambos métodos han sido implementados correctamente y producen los resultados esperados tanto en la inserción como en la eliminación de nodos.

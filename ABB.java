// Clase de Arbol Binario de Búsquada ABB
class ABB {

    // Nombre: Linda Candela Paz
    // Legajo: VINF013378
    // DNI: 42379854

    // Clase Nodo de un ABB
    class Nodo {
        int clave;
        Nodo izquierda, derecha;

        public Nodo(int data) {
            clave = data;
            izquierda = derecha = null;
        }
    }

    // Nodo raiz, dato referencial
    Nodo raiz;

    // Constructor de ABB => se inicializa como arbol vacío
    ABB() {
        raiz = null;
    }

    // Método para devolver el valor mínimo del subárbol derecho
    int ValorMinimo(Nodo raiz) {
        // Inicialmente, el nodo más a la izquierda es el valor mínimo
        int minimo = raiz.clave;
        // Recorremos hacia la izquierda para encontrar el menor valor
        while (raiz.izquierda != null) {
            minimo = raiz.izquierda.clave;
            raiz = raiz.izquierda;
        }
        return minimo;
    }

    // Insertar Nodo en ABB
    void insertar(int clave) {
        raiz = insertar_Recursivo(raiz, clave);
    }

    // Función recursiva de inserción
    Nodo insertar_Recursivo(Nodo raiz, int clave) {
        // Si el árbol está vacío, crear un nuevo nodo
        if (raiz == null) {
            raiz = new Nodo(clave);
            return raiz;
        }

        // De lo contrario, recorrer el árbol recursivamente
        if (clave < raiz.clave) {
            // Si la clave es menor, ir al subárbol izquierdo
            raiz.izquierda = insertar_Recursivo(raiz.izquierda, clave);
        } else if (clave > raiz.clave) {
            // Si la clave es mayor, ir al subárbol derecho
            raiz.derecha = insertar_Recursivo(raiz.derecha, clave);
        }

        // Devolver el nodo (sin cambios si es un nodo hoja)
        return raiz;
    }

    // Otros métodos de ABB (borrar, inorder, etc.) van aquí...
}

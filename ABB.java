// Clase de Arbol Binario de Búsqueda ABB
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

    // Método para hacer un recorrido in-order
    void inorder() {
        inorder_Recursive(raiz);
    }

    // Recorrido in-order recursivo
    void inorder_Recursive(Nodo raiz) {
        if (raiz != null) {
            inorder_Recursive(raiz.izquierda);
            System.out.print(raiz.clave + " ");
            inorder_Recursive(raiz.derecha);
        }
    }

    // Método main para ejecutar el código
    public static void main(String[] args) {
        // Crear el objeto ABB
        ABB arbol = new ABB();

        // Agregar datos al ABB
        arbol.insertar(45);
        arbol.insertar(10);
        arbol.insertar(7);
        arbol.insertar(12);
        arbol.insertar(90);
        arbol.insertar(50);

        // Mostrar el árbol ABB
        System.out.println("El árbol ABB ha sido creado (izquierda-raiz-derecha):");
        arbol.inorder();

        // Borrar nodo hoja
        System.out.println("\nEl árbol ABB después de borrar 12 (Nodo hoja):");
        arbol.borrarClave(12);
        arbol.inorder();
    }

    // Método para borrar un nodo
    void borrarClave(int clave) {
        raiz = borrar_Recursivo(raiz, clave);
    }

    // Borrado recursivo
    Nodo borrar_Recursivo(Nodo raiz, int clave) {
        if (raiz == null) {
            return raiz;
        }

        if (clave < raiz.clave) {
            raiz.izquierda = borrar_Recursivo(raiz.izquierda, clave);
        } else if (clave > raiz.clave) {
            raiz.derecha = borrar_Recursivo(raiz.derecha, clave);
        } else {
            if (raiz.izquierda == null) {
                return raiz.derecha;
            } else if (raiz.derecha == null) {
                return raiz.izquierda;
            }

            raiz.clave = ValorMinimo(raiz.derecha);
            raiz.derecha = borrar_Recursivo(raiz.derecha, raiz.clave);
        }

        return raiz;
    }
}

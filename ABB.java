    // Nombre: Linda Candela Paz
    // Legajo: VINF013378
    // DNI: 42379854

class ABB {
    class Nodo {
        int clave;
        Nodo izquierda, derecha;

        public Nodo(int data) {
            clave = data;
            izquierda = derecha = null;
        }
    }

    Nodo raiz;

    // Se inicia el árbol vacío
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

        // Devuelve el nodo
        return raiz;
    }

    // Recorrido in-order
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

    // Borrar un nodo (este es el método)
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

    // Método para buscar una clave
    boolean buscar(int clave) {
        Nodo resultado = buscar_Recursivo(raiz, clave);
        return resultado != null;
    }

    // Búsqueda recursiva
    Nodo buscar_Recursivo(Nodo raiz, int clave) {
        if (raiz == null || raiz.clave == clave) {
            return raiz;
        }

        if (raiz.clave > clave) {
            return buscar_Recursivo(raiz.izquierda, clave);
        }

        return buscar_Recursivo(raiz.derecha, clave);
    }

    // Método main para ejecutar el código
    public static void main(String[] args) {
        ABB arbol = new ABB();

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

        // Borrar el nodo con un solo hijo
        System.out.println("\nEl árbol ABB después de borrar 90 (Nodo con 1 hijo):");
        arbol.borrarClave(90);
        arbol.inorder();

        // Borrar nodo con 2 hijos
        System.out.println("\nEl árbol ABB después de borrar 45 (Nodo con 2 hijos):");
        arbol.borrarClave(45);
        arbol.inorder();

        // Buscar clave en el ABB
        boolean ret_val = arbol.buscar(50);
        System.out.println("\nClave 50 en el ABB: " + ret_val);

        ret_val = arbol.buscar(12);
        System.out.println("Clave 12 en el ABB: " + ret_val);
    }
}

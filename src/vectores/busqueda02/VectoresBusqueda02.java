package vectores.busqueda02;

import java.util.ArrayList;
import java.util.Random;

public class VectoresBusqueda02 {
    void main() {
        // Definir el array con el tamanio estático 20
        int[] aleatorio = new int[20];

        //Asignar valores randmos al array creado
        Random random = new Random();
        for (int i = 0; i < aleatorio.length; i++) {
            aleatorio[i] = random.nextInt(100);
        }

        //Leer el número a buscar desde el teclado
        int numero = Integer.parseInt(IO.readln("Ingresar el numero a buscar: "));

        //bandera para saber si se encontro o no el resultado
        boolean encontrado = false;
        // Busqueda lineal del numero ingresado
        for (int i = 0; i < aleatorio.length; i++) {
            // compara si el elemento del array es igual al numero ingresado
            if (aleatorio[i] == numero) {
                //cambia el valor de encontrado a verdadero
                encontrado = true;
                //Imprime el numero con la posicion en la que se encuentra
                IO.println("El numero %s se encuentra en la posicon %s".formatted(numero, i));
            }
        }

        //Muestra un mensaje  en caso de no encontrar el numero
        if (!encontrado) {
            IO.println("El numero no se encontro");
        }

        //Crear vector con las posiciones impares del vector aleatorio
        ArrayList<Integer> impares = new ArrayList<>();

        for (int i = 1; i <= aleatorio.length; i++) {
            if(i%2 != 0){
                final var indice = i - 1;
                impares.add(aleatorio[indice]);
            }
        }

        //Imprimir el vector formado por los elementos de los indices impares
        IO.println("----- VALORES VECTOR ORIGINAL-----");
        for (int valorAleatorio: aleatorio) {
            //Imprime todos los valores para el array original
            IO.println(valorAleatorio);
        }

        IO.println("----- VALORES VECTOR CON INDICES IMPARES-----");
        for (int indice: impares) {
            //Imprime todos los valores para el array de indices impares
            IO.println(indice);
        }

        IO.println("----- NUMEROS DEL ARRAY DE INDICES IMPARES QUE SON MAYORES A 20 ------");
        for (int indice: impares) {
            if (indice > 20) {
                //Imprime valores mayores a 20
                IO.println(indice);
            }
        }
    }
}

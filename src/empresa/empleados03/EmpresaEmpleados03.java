package empresa.empleados03;


public class EmpresaEmpleados03 {
    void main() {
        // Leer la cantidad de empleados.
        int n = Integer.parseInt(IO.readln("Ingrese la cantidad de empleados: "));

        // Definir el array de códigos y de nombres.
        int[] codigos = new int[n];
        String[] nombres = new String[n];

        // Recorrer y llenar la lista de códigos y nombres.
        for (int i = 0; i < n; i++) {
            // Mostrar el empleado actual.
            IO.println("\nEmpleado %s".formatted(i + 1));

            // Leer el código del empleado.
            codigos[i] = Integer.parseInt(IO.readln("Ingrese el codigo: "));

            // Leer el nombre del empleado.
            nombres[i] = IO.readln("Ingrese el nombre: ");
        }

        // Leer el código del empleado a buscar.
        int codigoBuscar = Integer.parseInt(IO.readln("Ingrese el codigo del empleado a buscar: "));

        // Definir bandera para saber si el empleado se encontró.
        boolean encontrado = false;

        // Recorrer empleados y códigos previamente guardados.
        for (int i = 0; i < n; i++) {
            // Verificar cada item de la lista de códigos con el código a buscar.
            if (codigos[i] == codigoBuscar) {
                // Mostrar el nombre del empleado encontrado.
                IO.println("Nombre del empleado: %s".formatted(nombres[i]));

                // Indicar bandera como encontrado.
                encontrado = true;

                // Romper iteración del bucle ya que se encontró el cliente.
                break;
            }
        }

        // Verificar si el empleado se encontró.
        if (!encontrado) {
            // Mostrar mensaje en caso de que el cliente no exista.
            IO.println("No existe un empleado con ese codigo.");
        }
    }
}

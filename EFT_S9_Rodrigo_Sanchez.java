
package eft_s9_rodrigo_sanchez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EFT_S9_Rodrigo_Sanchez {

    // Variables estáticas para almacenar información del teatro y las ventas

    private static final String nombreTeatro = "Teatro Moro";
    private static final int capacidadSala = 100;
    private static int entradasDisponibles = capacidadSala;
    private static double totalIngresos = 0;

    // Estructuras de datos para almacenar detalles de ventas, asientos, clientes y descuentos

    private static ArrayList<String> ventas = new ArrayList<>();
    private static ArrayList<String> asientos = new ArrayList<>();
    private static ArrayList<String> clientes = new ArrayList<>();
    private static ArrayList<String> descuentosPromociones = new ArrayList<>();

    // Mapas para almacenar precios de eventos y tipos de asientos

    private static final Map<String, Double> preciosEventos = new HashMap<>();
    static {
        preciosEventos.put("Concierto Rolling Stones", 15000.0);
        preciosEventos.put("Obra del Quijote de la Mancha", 10000.0);
        preciosEventos.put("Concierto Chris Stapleton", 12000.0);
        preciosEventos.put("Obra El fantasma de la Opera", 13000.0);
    }

    private static final Map<String, Double> preciosAsientos = new HashMap<>();
    static {
        preciosAsientos.put("VIP", 7000.0);
        preciosAsientos.put("Platea", 5000.0);
        preciosAsientos.put("Palco", 3000.0);
    }
    
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Bucle principal para el menú interactivo
        while (continuar) {
            mostrarMenu();

            int opcion;
            try { // Manejando excepciones con 'try'
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción incorrecta. Por favor, ingrese un número.");
                continue;
            }
            
             // Evaluar la opción seleccionada por el usuario
            switch (opcion) {
                case 1:
                    // Realizar la venta de entradas
                    ventaEntradas(scanner);
                    break;
                case 2:
                    // Visualizar el resumen de ventas
                    visualizarResumenVentas();
                    break;
                case 3:
                    // Generar la boleta
                    generarBoleta();
                    break;
                case 4:
                    // Calcular los ingresos totales
                    calcularIngresosTotales();
                    break;
                case 5:
                    // Salir del programa
                    continuar = false;
                    System.out.println("Gracias por su compra.");
                    break;
                default:
                    // Manejar la opción incorrecta
                    System.out.println("Opción incorrecta. Por favor, seleccione nuevamente.");
                    break;
            }
        }
    }
    
    // Método para mostrar el menú principal
    private static void mostrarMenu() {
        System.out.println("\n=== " + nombreTeatro + " ===");
        System.out.println("1. Venta de entradas");
        System.out.println("2. Visualizar resumen de ventas");
        System.out.println("3. Generar boleta");
        System.out.println("4. Calcular ingresos totales");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
    // Método para la venta de entradas
    private static void ventaEntradas(Scanner scanner) {
        boolean comprarOtraEntrada = true;
        
        // Bucle que permite al usuario comprar varias entradas
        while (comprarOtraEntrada) {
            
            // Proceso de venta de entradas
            // Mneú
            System.out.println("\n=== Venta de Entradas ===");
            System.out.println("Eventos disponibles:");
            int contador = 1;
            for (String evento : preciosEventos.keySet()) {
                System.out.println(contador + ". " + evento + " - Precio: $" + preciosEventos.get(evento));
                contador++;
            }
            
            // Mostrar eventos disponibles
            System.out.print("Seleccione el número del evento: ");
            int opcionEvento;
            try {
                opcionEvento = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Manejar la excepción si el usuario ingresa una opción no válida
                System.out.println("Opción incorrecta. Por favor, ingrese un número.");
                return;
            }

            // Validar la opción seleccionada por el usuario
            if (opcionEvento < 1 || opcionEvento > preciosEventos.size()) {
                System.out.println("Opción incorrecta. Por favor, seleccione nuevamente.");
                return;
            }
            // Seleccionar evento
            String eventoSeleccionado = obtenerEvento(opcionEvento);

            // Mostrar asientos disponibles
            System.out.println("Asientos disponibles:");
            int contadorAsientos = 1;
            for (String asiento : preciosAsientos.keySet()) {
                System.out.println(contadorAsientos + ". " + asiento + " - Precio: $" + preciosAsientos.get(asiento));
                contadorAsientos++;
            }
            System.out.print("Seleccione el número del asiento: ");
            int opcionAsiento;
            try {
                opcionAsiento = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Manejar la excepción si el usuario ingresa una opción no válida
                System.out.println("Opción incorrecta. Por favor, ingrese un número.");
                return; // Salir del método
            }

            if (opcionAsiento < 1 || opcionAsiento > preciosAsientos.size()) {
                System.out.println("Opción incorrecta. Por favor, seleccione nuevamente.");
                return;
            }

            // Seleccionar asiento
            String asientoSeleccionado = obtenerAsiento(opcionAsiento);

            double precioBase = preciosEventos.get(eventoSeleccionado) + preciosAsientos.get(asientoSeleccionado);

            // Aplicar descuentos y calcular precio final
            System.out.print("¿Es estudiante? (S/N): ");
            boolean esEstudiante = scanner.nextLine().equalsIgnoreCase("S");
            double descuento = 0;

            if (esEstudiante) {
                descuento = 0.15; // Descuento del 15% para estudiantes
            } else {
                System.out.print("¿Es adulto mayor? (S/N): ");
                boolean esAdultoMayor = scanner.nextLine().equalsIgnoreCase("S");
                if (esAdultoMayor) {
                    descuento = 0.20; // Descuento del 20% para adultos mayores
                }
            }

            // Calcular precio final
            double precioFinal = precioBase - (precioBase * descuento);
            double descuentoPorcentaje = descuento * 100;

            // Registrar venta y actualizar información
            if (entradasDisponibles > 0) {
                System.out.println("Evento: " + eventoSeleccionado);
                System.out.println("Asiento: " + asientoSeleccionado);
                System.out.println("Costo Base: $" + precioBase);
                System.out.println("Descuento Aplicado: " + (int) descuentoPorcentaje + "%");
                System.out.println("Costo Final: $" + precioFinal);
                System.out.println("¡Entrada vendida! Disfrute del espectáculo: " + eventoSeleccionado);
                // Actualizar información de ventas y asientos
                totalIngresos += precioFinal;
                entradasDisponibles--;
                agregarVenta("Evento: " + eventoSeleccionado + ", Asiento: " + asientoSeleccionado +
                        ", Costo Base: $" + precioBase + ", Descuento Aplicado: " + (int) descuentoPorcentaje +
                        "%, Costo Final: $" + precioFinal);
            } else {
                System.out.println("Lo sentimos, no hay entradas disponibles.");
            }

            // Preguntar si desea comprar otra entrada
            System.out.print("\n¿Desea comprar otra entrada? (S/N): ");
            comprarOtraEntrada = scanner.nextLine().equalsIgnoreCase("S");
        }
    }

    // Método para obtener el evento seleccionado
    private static String obtenerEvento(int opcion) {
        int contador = 1;
        for (String evento : preciosEventos.keySet()) {
            if (contador == opcion) {
                return evento;
            }
            contador++;
        }
        return null;
    }

    // Método para obtener el asiento seleccionado
    private static String obtenerAsiento(int opcion) {
        int contador = 1;
        for (String asiento : preciosAsientos.keySet()) {
            if (contador == opcion) {
                return asiento;
            }
            contador++;
        }
        return null;
    }

    // Método para mostrar el resumen de las ventas
    private static void visualizarResumenVentas() {
        System.out.println("\n=== Resumen de Ventas ===");
        for (String venta : ventas) {
            System.out.println(venta);
        }
    }

    // Método para generar la boleta con el resumen de las ventas
    private static void generarBoleta() {
        
        // Mostrar el encabezado de la boleta
        System.out.println("\n=== Boleta ===");
        System.out.println("---------------------------------------");
        System.out.println("              " + nombreTeatro);
        System.out.println("---------------------------------------");
        
        // Iterar sobre la lista de ventas y mostrar cada venta
        for (String venta : ventas) {
            System.out.println(venta);
        }
        
        // Mostrar el total de ingresos y el mensaje de agradecimiento
        System.out.println("---------------------------------------");
        System.out.println("Total: $" + totalIngresos);
        System.out.println("Gracias por su visita al " + nombreTeatro);
        System.out.println("---------------------------------------");
    }

    // Método para calcular y mostrar los ingresos totales
    private static void calcularIngresosTotales() {
        System.out.println("\n=== Ingresos Totales ===");
        
        // Calcular el total de ingresos y mostrarlo
        System.out.println("Total Ingresos: $" + totalIngresos);
    }

    // Método para agregar una venta a la lista de ventas
    private static void agregarVenta(String venta) {
        // Agregar la venta a la lista de ventas
        ventas.add(venta);
    }
}

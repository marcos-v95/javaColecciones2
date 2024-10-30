import java.util.HashSet;
import java.util.Scanner;

class ComponenteCPU {
    String componente;
    String marca;
    int cantidad;
    double precio;

    public ComponenteCPU(String componente, String marca, int cantidad, double precio) {
        this.componente = componente;
        this.marca = marca;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    //Funcion que calcula subtotal del componente
    public double calcularSubTotal() {
        return this.cantidad * this.precio;
    }

    //Alternativa para mostrar los datos de la computadora usando string builder, una modificacion del objeto nativo string de java
    /*public String toString() {
        return String.format("Componente: %s, Marca: %s, Cantidad: %d, Precio: %.2f, Subtotal: %.2f",
                componente, marca, cantidad, precio, calcularSubTotal());
    }*/
}

class Computadora {
    String marca;
    String modelo;
    HashSet<ComponenteCPU> componentes;

    public Computadora(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.componentes = new HashSet<>();
    }

    //Funcion para agregar el componente a la coleccion hashset
    public void agregarComponente(ComponenteCPU componente) {
        this.componentes.add(componente);
    }

    //Funcion para calcular el costo total de la computadora
    public double calcularCostoTotal() {
        double total = 0;
        //itera la coleccion hashset y suma el valor de cada subtotal de los componentes
        for (ComponenteCPU comp : componentes) {
            total += comp.calcularSubTotal();
        }
        return total;
    }

    // Funcion para calcular precio sugerido
    public double calcularPrecioSugerido() {
        double costoTotal = calcularCostoTotal();
        if (costoTotal < 50000) {
            return costoTotal * 1.40;
        } else {
            return costoTotal * 1.30;
        }
    }
    // Alternativa para mostrar los datos de la computadora usando string builder, una modificacion del objeto nativo string de java
    /*public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------- Computadora ---------\n");
        sb.append("Marca: ").append(marca).append("\n");
        sb.append("Modelo: ").append(modelo).append("\n");
        sb.append("Componentes:\n");
        for (ComponenteCPU comp : componentes) {
            sb.append(comp.toString()).append("\n");
        }
        sb.append("Costo Total: ").append(calcularCostoTotal()).append("\n");
        sb.append("Precio Sugerido de Venta: ").append(calcularPrecioSugerido()).append("\n");
        return sb.toString();
    }*/
}

public class CostoComputadora {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String respuesta;

        do {
            // Pedimos al usuario que ingrese marca y modelo de computadora, y tomamos esos valores en variables
            System.out.println("Ingrese la marca de la computadora: ");
            String marcaComputadora = sc.nextLine();
            System.out.println("Ingrese el modelo de la computadora: ");
            String modeloComputadora= sc.nextLine();

            // Instanciamos la clase computadora en una variable y guardamos los datos pedidos al usuario
            Computadora computadora= new Computadora(marcaComputadora,modeloComputadora);

            // Pedimos al usuario la cantidad de componentes a agregar
            System.out.print("Indique la cantidad de componentes a agregar en la computadora: ");
            int cantComponentes = sc.nextInt();
            sc.nextLine(); //limpiamos el buffer de scanner

            for (int i = 0; i < cantComponentes; i++) {
                System.out.println("Ingrese el nombre del componente: ");
                String nombreComponente = sc.nextLine();
                System.out.println("Ingrese la marca del componente: ");
                String marcaComponente = sc.nextLine();

                System.out.println("Ingrese la cantidad del componente: ");
                int cantidadComponente = sc.nextInt();

                System.out.println("Ingrese el precio por unidad: ");
                double precioComponente = sc.nextDouble();
                sc.nextLine();

                // Instanciamos los componentes en la clase
                ComponenteCPU componente = new ComponenteCPU(nombreComponente, marcaComponente, cantidadComponente, precioComponente);
                computadora.agregarComponente(componente);
            }
            // Mostramos la computadora

            System.out.println("========= Computadora =========");
            System.out.println("Marca: " + computadora.marca);
            System.out.println("Modelo: " + computadora.modelo);
            System.out.println("Componentes:");

            for (ComponenteCPU comp : computadora.componentes) {
                System.out.println("- Componente: " + comp.componente);
                System.out.println("  Marca: " + comp.marca);
                System.out.println("  Cantidad: " + comp.cantidad);
                System.out.println("  Precio por unidad: $" + comp.precio);
                System.out.println("  Subtotal: $" + comp.calcularSubTotal());
            }
            System.out.println("Costo Total: $" + computadora.calcularCostoTotal());
            System.out.println("Precio Sugerido de Venta: $" + computadora.calcularPrecioSugerido());
            System.out.println("=======================================");

            /*System.out.println(computadora.toString());*/ //Alternativa si quisieramos mostrar los datos con string builder

            // Preguntamos si desea cotizar nueva computadora
            System.out.print("¿Desea cotizar una nueva computadora? (s/n): ");
            respuesta = sc.nextLine();

        }while(respuesta.equalsIgnoreCase("s"));

        System.out.println("Programa terminado.");
        sc.close();

    }
}
